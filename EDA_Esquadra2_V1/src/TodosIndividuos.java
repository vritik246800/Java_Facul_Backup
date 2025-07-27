import java.util.*;
import java.io.*;

public class TodosIndividuos
{
private ArrayList<Individuo> lista; // Typed ArrayList
private BinaryTree<Individuo> arvoreIndividuos; // Tree of Individuo objects
private Validacoes val;
private Visualizacoes vis;

public TodosIndividuos()
{
	val = new Validacoes();
	lista = new ArrayList<Individuo>(); // Typed ArrayList
	arvoreIndividuos = new BinaryTree<>(); // Initialize the tree
	vis = new Visualizacoes();
}

public ArrayList<Individuo> getLista() {
    return lista;
}

public BinaryTree<Individuo> getArvoreIndividuos() {
    return arvoreIndividuos;
}



public void lerDados() {
    //Atributos do individuo
    String nome, genero, nacionalidade, bI, endereco, numTelefone;
    int idade;
    //Atributos da vitima
    String estadoFisico, tipoDano, relatorioVitima, atendimentoMedico;
    //Atributos do suspeito
    String grauPericulosidadeFromFile, antecedentesFromFile, estadoDetensao, depoimento, advogadoPresente;
    String criterio; // Removida 'dados' daqui, será usada localmente no loop
    String dataOcorrencia, horaOcorrencia;
    int numPessoas;

    StringTokenizer umaCadeia;
    String linhaAtual; // Para ler cada linha

    try (BufferedReader ler = new BufferedReader(new FileReader("dados.txt"))) { // try-with-resources

        while ((linhaAtual = ler.readLine()) != null) {
            if (linhaAtual.trim().isEmpty()) { // Skip empty lines
                continue;
            }

            umaCadeia = new StringTokenizer(linhaAtual, ";");

            try { // Try-catch para cada linha, para pular linhas problemáticas
                nome = umaCadeia.nextToken().trim();
                idade = Integer.parseInt(umaCadeia.nextToken().trim());
                genero = umaCadeia.nextToken().trim();
                nacionalidade = umaCadeia.nextToken().trim();
                bI = umaCadeia.nextToken().trim();
                endereco = umaCadeia.nextToken().trim();
                numTelefone = umaCadeia.nextToken().trim();

                criterio = umaCadeia.nextToken().trim(); // Este é o 8º campo ("VV" ou "SS")

                // Debug: Verifique o critério e o número de tokens restantes
                // System.out.println("Lendo linha: " + nome + ", Critério: '" + criterio + "', Tokens restantes: " + umaCadeia.countTokens());

                if (criterio.equalsIgnoreCase("VV")) {
                    if (umaCadeia.countTokens() < 7) { // VV precisa de mais 7 campos
                        System.err.println("Linha de Vítima incompleta (esperava 7 campos após critério): " + linhaAtual);
                        continue;
                    }
                    estadoFisico = umaCadeia.nextToken().trim();
                    tipoDano = umaCadeia.nextToken().trim();
                    relatorioVitima = umaCadeia.nextToken().trim();
                    atendimentoMedico = umaCadeia.nextToken().trim();
                    numPessoas = Integer.parseInt(umaCadeia.nextToken().trim());
                    dataOcorrencia = umaCadeia.nextToken().trim();
                    horaOcorrencia = umaCadeia.nextToken().trim();
                    criarVitima(nome, idade, genero, nacionalidade, bI, endereco, numTelefone, estadoFisico, tipoDano, relatorioVitima, atendimentoMedico, numPessoas, dataOcorrencia, horaOcorrencia);
                } else if (criterio.equalsIgnoreCase("SS")) {
                    if (umaCadeia.countTokens() < 8) { // SS precisa de mais 8 campos
                        System.err.println("Linha de Suspeito incompleta (esperava 8 campos após critério): " + linhaAtual);
                        continue;
                    }
                    grauPericulosidadeFromFile = umaCadeia.nextToken().trim();
                    antecedentesFromFile = umaCadeia.nextToken().trim();
                    estadoDetensao = umaCadeia.nextToken().trim();
                    depoimento = umaCadeia.nextToken().trim();
                    advogadoPresente = umaCadeia.nextToken().trim();
                    numPessoas = Integer.parseInt(umaCadeia.nextToken().trim());
                    dataOcorrencia = umaCadeia.nextToken().trim();
                    horaOcorrencia = umaCadeia.nextToken().trim();
                    criarSuspeito(nome, idade, genero, nacionalidade, bI, endereco, numTelefone, antecedentesFromFile, grauPericulosidadeFromFile, estadoDetensao, depoimento, advogadoPresente, numPessoas, dataOcorrencia, horaOcorrencia);
                } else {
                    System.err.println("Critério desconhecido ou linha malformatada (criterio='" + criterio + "'): " + linhaAtual);
                }
            } catch (NoSuchElementException nsee) {
                System.err.println("Erro de formatação (campos faltando) na linha: '" + linhaAtual + "'. Detalhe: " + nsee.getMessage());
            } catch (NumberFormatException nfe) {
                System.err.println("Erro de formatação de número na linha: '" + linhaAtual + "'. Detalhe: " + nfe.getMessage());
            }
        } // Fim do while

        lista.trimToSize();
        System.out.println("Ficheiro de dados lido com sucesso! Total de registros: " + lista.size());
        // ler.close(); // Não é necessário com try-with-resources

    } catch (FileNotFoundException f) {
        System.out.println("Ficheiro de texto nao encontrado! (Certifique-se de que esta criado ou tem o nome 'dados.txt')");
    } catch (IOException i) {
        System.out.println("Erro de I/O ao ler o ficheiro: " + i.getMessage());
    }
}
/*IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
Java
IGNORE_WHEN_COPYING_END

Principais alterações no lerDados() acima:

Loop de Leitura: Utiliza try-with-resources para o BufferedReader (garante que ler.close() é chamado) e um loop while((linhaAtual = ler.readLine()) != null) mais padrão.

trim() em tudo: Adicionado .trim() a cada nextToken() e à linhaAtual ao verificar se está vazia.

Verificação do Critério: Alterado para equalsIgnoreCase("VV") e equalsIgnoreCase("SS").

Tratamento de Erros por Linha: Envolve o processamento de cada linha em um bloco try-catch para NoSuchElementException (campos faltando) e NumberFormatException. Se uma linha tiver um problema, uma mensagem de erro é impressa para essa linha, e o loop continua para a próxima.

Verificação de Tokens Restantes: Adicionada uma verificação simples umaCadeia.countTokens() antes de tentar ler todos os campos específicos de Vítima ou Suspeito para evitar NoSuchElementException de forma mais elegante e dar uma mensagem de erro mais clara.

Teste com essas modificações. Se o Total de registros ainda for 0, adicione a linha de System.out.println que comentei (para Debug) dentro do loop para ver o que está sendo lido para criterio e quantos tokens restam em cada linha, isso ajudará a identificar se o problema persiste na identificação do tipo de registro ou na contagem de campos.
*/
public void criarSuspeito( String nome, int idade, String genero, String nacionalidade, String bI, String endereco, String numTelefone, String antecedentes, String grauPericulosidade, String estadoDetensao, String depoimento, String advogadoPresente, int pessoas, String dataOcorrencia, String horaOcorrencia)
{
	Suspeito s = new Suspeito();
	s.setNome(nome);
	s.setIdade(idade);
	s.setGenero(genero);
	s.setNacionalidade(nacionalidade);
	s.setNumeroBI(bI);
	s.setEndereco(endereco);
	s.setNumTelefone(numTelefone);
	s.setAntecedentesCriminais(antecedentes);
	s.setGrauPericulosidade(grauPericulosidade);
	s.setEstadoDetensao(estadoDetensao);
	s.setDepoimento(depoimento);
	s.setAdvogadoPresente(advogadoPresente);
	s.setNumPessoasEnvolvidas(pessoas); // Corrected setter name
	s.setDataOcorrencia(dataOcorrencia); // Corrected setter name
	s.setHoraOcorrencia(horaOcorrencia);
	
	// CORREÇÃO: Adicionar tanto à lista quanto à árvore
	lista.add(s);
	arvoreIndividuos.insert(s); // Add to the BST
}

public void criarVitima( String nome, int idade, String genero, String nacionalidade, String bI, String endereco, String numTelefone, String estadoFisico, String tipoDano, String relatorioVitima, String atendimentoMedico, int pessoas, String dataOcorrencia, String horaOcorrencia)
{
	Vitima v = new Vitima();
	v.setNome(nome);
	v.setIdade(idade);
	v.setGenero(genero);
	v.setNacionalidade(nacionalidade);
	v.setNumeroBI(bI);
	v.setEndereco(endereco);
	v.setNumTelefone(numTelefone);
	v.setEstadoFisico(estadoFisico);
	v.setTipoDano(tipoDano);
	v.setRelatorioVitima(relatorioVitima);
	v.setAtendimenteMedico(atendimentoMedico);
	v.setNumPessoasEnvolvidas(pessoas); // Corrected setter name
	v.setDataOcorrencia(dataOcorrencia); // Corrected setter name
	v.setHoraOcorrencia(horaOcorrencia);
	
	// CORREÇÃO: Adicionar tanto à lista quanto à árvore
	lista.add(v);
	arvoreIndividuos.insert(v); // Add to the BST
}

// This method's approach of using constructors with side effects (input/output) is not ideal.
// For robust integration with the tree, objects should be fully formed before insertion.
// The current Suspeito("Novo") and Vitima("Nova") constructors handle input and file writing.
// They don't return the created object directly for use here, but they do populate fields.
// We will assume that after new Vitima/Suspeito, the object added to the list is complete.
public void novaDenucia()
{
	String resp;
	resp = val.validarString("Tem Vitima(Sim/Nao): ", "Sim", "Nao");
	if(resp.equalsIgnoreCase("Sim"))
	{
		System.out.println("|=====================|DADOS DA VITIMA|=====================|");
		Vitima vitima = new Vitima("Nova"); // This constructor prompts user, creates, and writes to file
		lista.add(vitima); // Assumes 'vitima' is fully populated by its constructor
		arvoreIndividuos.insert(vitima); // Add to BST

		resp = val.validarString("Tem Suspeito(Sim/Nao): ", "Sim", "Nao");
		if(resp.equalsIgnoreCase("Sim"))
		{
			System.out.println("|=====================|DADOS DO SUSPEITO|=====================|");
			Suspeito suspeito = new Suspeito("Novo"); // This constructor prompts user, creates, and writes to file
			lista.add(suspeito); // Assumes 'suspeito' is fully populated
			arvoreIndividuos.insert(suspeito); // Add to BST
		}
	}
	else
	{
		System.out.println("|=====================|DADOS DO SUSPEITO|=====================|");
		Suspeito suspeito = new Suspeito("Novo");
		lista.add(suspeito);
		arvoreIndividuos.insert(suspeito);
	}
    System.out.println("Nova denúncia registada e adicionada à árvore. Total de registros: " + lista.size());
}

public void adaptarVerTodosDados()
{
	if (lista.isEmpty()) {
		System.out.println("Nenhum dado para mostrar. Carregue ou insira dados primeiro.");
		return;
	}
	System.out.println("=== DADOS DA LISTA (Total: " + lista.size() + " registros) ===");
	vis.verTodosDados(lista);
}


}