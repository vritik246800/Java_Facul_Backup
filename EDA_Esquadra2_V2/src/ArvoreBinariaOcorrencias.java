import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaOcorrencias implements Serializable {
    private static final long serialVersionUID = 1L;
    private NoArvore raiz;
    private int count; // For automatic quantity update

    public ArvoreBinariaOcorrencias() {
        this.raiz = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    // Inserir
    public void inserir(Ocorrencia ocorrencia) {
        if (buscar(ocorrencia.getCodigo()) != null) {
            System.out.println("Erro: Ocorrência com código " + ocorrencia.getCodigo() + " já existe.");
            return;
        }
        this.raiz = inserirRecursivo(this.raiz, ocorrencia);
        this.count++;
    }

    //o no com o menor codigo vai ser inserido na esquerda. Os nos com os codigos maiores serao inseridos na direita;
    private NoArvore inserirRecursivo(NoArvore noAtual, Ocorrencia ocorrencia) {
        if (noAtual == null) {
            return new NoArvore(ocorrencia);
        }
        if (ocorrencia.getCodigo() < noAtual.ocorrencia.getCodigo()) {
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, ocorrencia);
        } else if (ocorrencia.getCodigo() > noAtual.ocorrencia.getCodigo()) {
            noAtual.direita = inserirRecursivo(noAtual.direita, ocorrencia);
        }
        return noAtual; // Retorna o nó (inalterado)
    }

    // Buscar
    public Ocorrencia buscar(int codigo) {
        return buscarRecursivo(this.raiz, codigo);
    }

    private Ocorrencia buscarRecursivo(NoArvore noAtual, int codigo) {
        if (noAtual == null) {
            return null;
        }
        if (codigo == noAtual.ocorrencia.getCodigo()) {
            return noAtual.ocorrencia;
        }
        return codigo < noAtual.ocorrencia.getCodigo()
               ? buscarRecursivo(noAtual.esquerda, codigo)
               : buscarRecursivo(noAtual.direita, codigo);
    }

    // Remover
    public void remover(int codigo) {
        if (buscar(codigo) == null) {
            System.out.println("Erro: Ocorrência com código " + codigo + " não encontrada para remoção.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, codigo);
        if (raiz != null || count > 0) { // Only decrement if removal was successful (node existed)
             // The check for existence is done above, so we can decrement
            this.count--;
        }
    }

    private NoArvore removerRecursivo(NoArvore noAtual, int codigo) {
        if (noAtual == null) {
            return null;
        }

        if (codigo == noAtual.ocorrencia.getCodigo()) {
            // Caso 1: Nó sem filhos (folha)
            if (noAtual.esquerda == null && noAtual.direita == null) {
                return null;
            }
            // Caso 2: Nó com um filho
            if (noAtual.direita == null) {
                return noAtual.esquerda;
            }
            if (noAtual.esquerda == null) {
                return noAtual.direita;
            }
            // Caso 3: Nó com dois filhos
            // Encontrar o menor valor na subárvore direita (sucessor in-order)
            Ocorrencia menorValor = encontrarMenorValor(noAtual.direita);
            noAtual.ocorrencia = menorValor; // Substitui o valor do nó atual
            noAtual.direita = removerRecursivo(noAtual.direita, menorValor.getCodigo()); // Remove o nó duplicado
            return noAtual;

        }
        if (codigo < noAtual.ocorrencia.getCodigo()) {
            noAtual.esquerda = removerRecursivo(noAtual.esquerda, codigo);
            return noAtual;
        }
        noAtual.direita = removerRecursivo(noAtual.direita, codigo);
        return noAtual;
    }

    private Ocorrencia encontrarMenorValor(NoArvore raizSubarvore) {
        return raizSubarvore.esquerda == null ? raizSubarvore.ocorrencia : encontrarMenorValor(raizSubarvore.esquerda);
    }

    // Travessia Em Ordem (In-Order)
    //Aashir
    public void listarEmOrdem() {
        if (raiz == null) {
            System.out.println("Nenhuma ocorrência cadastrada.");
            return;
        }
        listarEmOrdemRecursivo(this.raiz);
    }

    private void listarEmOrdemRecursivo(NoArvore no) {
        if (no != null) {
            listarEmOrdemRecursivo(no.esquerda);
            System.out.println(no.ocorrencia.toString());
            listarEmOrdemRecursivo(no.direita);
        }
    }
    
    public List<Ocorrencia> getTodasOcorrencias() {
        List<Ocorrencia> lista = new ArrayList<>();
        coletarEmOrdem(raiz, lista);
        return lista;
    }

    private void coletarEmOrdem(NoArvore no, List<Ocorrencia> lista) {
        if (no != null) {
            coletarEmOrdem(no.esquerda, lista);
            lista.add(no.ocorrencia);
            coletarEmOrdem(no.direita, lista);
        }
    }

    // Salvar para arquivo de texto
    public void salvarParaArquivo(String nomeArquivo) {
        try (PrintWriter out = new PrintWriter(new FileWriter(nomeArquivo))) {
            List<Ocorrencia> todas = getTodasOcorrencias();
            if (todas.isEmpty()){
                // Escreve um arquivo vazio se não houver ocorrências para evitar erro na leitura posterior de um arquivo inexistente
                // Ou pode-se optar por não criar o arquivo se estiver vazio.
                 System.out.println("Nenhuma ocorrência para salvar.");
                 return;
            }
            for (Ocorrencia oc : todas) {
                out.println(oc.toFileString());
            }
            System.out.println("Ocorrências salvas em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar ocorrências: " + e.getMessage());
        }
    }

    // Carregar de arquivo de texto
    public void carregarDeArquivo(String nomeArquivo) {
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            System.out.println("Arquivo " + nomeArquivo + " não encontrado. Iniciando com árvore vazia.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            this.raiz = null; // Limpa a árvore atual
            this.count = 0;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                Ocorrencia oc = Ocorrencia.fromFileString(linha);
                if (oc != null) {
                    this.inserir(oc); // Usa o método inserir para reconstruir a árvore e atualizar count
                } else {
                    System.err.println("Erro ao parsear linha (ocorrencia): " + linha);
                }
            }
            System.out.println("Ocorrências carregadas de " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao carregar ocorrências: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato numérico ao carregar ocorrências: " + e.getMessage());
        }
    }
}