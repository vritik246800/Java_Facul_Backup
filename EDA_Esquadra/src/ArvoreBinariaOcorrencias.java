import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaOcorrencias {
    private NoArvore raiz;
    private int contadorOcorrenciasAbertas = 0; // For alerts

    public ArvoreBinariaOcorrencias() {
        this.raiz = null;
    }

    // Inserir
    public void inserir(Ocorrencia ocorrencia) {
        raiz = inserirRec(raiz, ocorrencia);
        if (ocorrencia.getStatusCaso().equalsIgnoreCase("Aberto")) {
            contadorOcorrenciasAbertas++;
        }
    }

    private NoArvore inserirRec(NoArvore noAtual, Ocorrencia ocorrencia) {
        if (noAtual == null) {
            return new NoArvore(ocorrencia);
        }

        if (ocorrencia.getIdOcorrencia().compareTo(noAtual.ocorrencia.getIdOcorrencia()) < 0) {
            noAtual.esquerda = inserirRec(noAtual.esquerda, ocorrencia);
        } else if (ocorrencia.getIdOcorrencia().compareTo(noAtual.ocorrencia.getIdOcorrencia()) > 0) {
            noAtual.direita = inserirRec(noAtual.direita, ocorrencia);
        } else {
            // ID já existe, não inserir duplicado (ou atualizar, se for o caso)
            System.out.println("Ocorrência com ID " + ocorrencia.getIdOcorrencia() + " já existe.");
        }
        return noAtual;
    }

    // Buscar
    public Ocorrencia buscar(String idOcorrencia) {
        NoArvore resultado = buscarRec(raiz, idOcorrencia);
        return (resultado != null) ? resultado.ocorrencia : null;
    }

    private NoArvore buscarRec(NoArvore noAtual, String idOcorrencia) {
        if (noAtual == null || noAtual.ocorrencia.getIdOcorrencia().equals(idOcorrencia)) {
            return noAtual;
        }
        if (idOcorrencia.compareTo(noAtual.ocorrencia.getIdOcorrencia()) < 0) {
            return buscarRec(noAtual.esquerda, idOcorrencia);
        } else {
            return buscarRec(noAtual.direita, idOcorrencia);
        }
    }

    // Remover
    public void remover(String idOcorrencia) {
        Ocorrencia ocRemovida = buscar(idOcorrencia);
        if (ocRemovida != null && ocRemovida.getStatusCaso().equalsIgnoreCase("Aberto")) {
            contadorOcorrenciasAbertas--;
        }
        raiz = removerRec(raiz, idOcorrencia);
    }

    private NoArvore removerRec(NoArvore noAtual, String idOcorrencia) {
        if (noAtual == null) {
            return null;
        }

        if (idOcorrencia.equals(noAtual.ocorrencia.getIdOcorrencia())) {
            // Caso 1: Nó sem filhos ou com um filho
            if (noAtual.esquerda == null) {
                return noAtual.direita;
            } else if (noAtual.direita == null) {
                return noAtual.esquerda;
            }
            // Caso 2: Nó com dois filhos
            // Encontrar o menor valor na subárvore direita (sucessor in-order)
            noAtual.ocorrencia = encontrarMenorValor(noAtual.direita);
            // Remover o sucessor in-order
            noAtual.direita = removerRec(noAtual.direita, noAtual.ocorrencia.getIdOcorrencia());

        } else if (idOcorrencia.compareTo(noAtual.ocorrencia.getIdOcorrencia()) < 0) {
            noAtual.esquerda = removerRec(noAtual.esquerda, idOcorrencia);
        } else {
            noAtual.direita = removerRec(noAtual.direita, idOcorrencia);
        }
        return noAtual;
    }

    private Ocorrencia encontrarMenorValor(NoArvore no) {
        return (no.esquerda == null) ? no.ocorrencia : encontrarMenorValor(no.esquerda);
    }

    // Listar em Ordem (In-Order Traversal)
    public void listarEmOrdem() {
        listarEmOrdemRec(raiz);
    }

    private void listarEmOrdemRec(NoArvore no) {
        if (no != null) {
            listarEmOrdemRec(no.esquerda);
            System.out.println(no.ocorrencia);
            listarEmOrdemRec(no.direita);
        }
    }
    
    // Métodos para relatórios e contagem
    public int contarTotalOcorrencias() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public List<Ocorrencia> getTodasOcorrencias() {
        List<Ocorrencia> lista = new ArrayList<>();
        coletarOcorrencias(raiz, lista);
        return lista;
    }

    private void coletarOcorrencias(NoArvore no, List<Ocorrencia> lista) {
        if (no != null) {
            coletarOcorrencias(no.esquerda, lista);
            lista.add(no.ocorrencia);
            coletarOcorrencias(no.direita, lista);
        }
    }
    
    public int getContadorOcorrenciasAbertas() {
        // Recalcula para precisão, ou atualize ao mudar status
        contadorOcorrenciasAbertas = 0;
        List<Ocorrencia> todas = getTodasOcorrencias();
        for (Ocorrencia oc : todas) {
            if ("Aberto".equalsIgnoreCase(oc.getStatusCaso()) || "Em Investigação".equalsIgnoreCase(oc.getStatusCaso())) {
                contadorOcorrenciasAbertas++;
            }
        }
        return contadorOcorrenciasAbertas;
    }

    public void decrementarAbertas() {
        if (contadorOcorrenciasAbertas > 0) contadorOcorrenciasAbertas--;
    }
    public void incrementarAbertas() {
        contadorOcorrenciasAbertas++;
    }
}