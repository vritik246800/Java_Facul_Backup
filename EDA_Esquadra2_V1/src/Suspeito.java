
public class Suspeito extends Individuo
{
	private EscreverFicheiro escrever;
	private Validacoes val;
	private String antecedentesCriminais, advogadoPresente;
	private String grauPericulosidade, estadoDetensao, depoimento;
	private static int contadorSuspeitos=0;
	public Suspeito(String nome, String gen, String nac, String numBI, String end, String numTelefone, int idade,String grauPer, String estadoDet, String depoimento, String antecedentes, String advogado,int numPessoasEnvolvidas, String dataOcorrencia, String horaOcorrencia)
	{
		super(nome, gen, nac, numBI, end, numTelefone, idade, numPessoasEnvolvidas, dataOcorrencia, horaOcorrencia);
		this.advogadoPresente=advogado;
		this.grauPericulosidade=grauPer;
		this.estadoDetensao=estadoDet;
		this.depoimento=depoimento;
		this.antecedentesCriminais=antecedentes;
		contadorSuspeitos++;
	}
	public Suspeito()
	{
		this("","","","","","",0,"","","", "", "",0,"","");
	}
	
	public Suspeito(String novo)
	{
		escrever = new EscreverFicheiro();
		val=new Validacoes();
		nome = val.validarString("Introduza o nome do suspeito: ", "ERRO: Escreva um nome verdadeiro", 2);
		idade = val.validarInt("Idade do suspeito: ", 12);
		genero = val.validarString("Introduza o genero: ", "Masculino", "Femenino");
		nacionalidade=val.validarString("Nacionalidade do suspeito: ", "Erro: Introduza uma nacionalidade valida", 3);
		numeroBI=val.validarString("Numero de BI: ", "Erro: Introduza um numero valido", 10);
		endereco=val.validarString("Endereco do suspeito: ", "Erro: Intruduza um endereco valido", 5);
		numTelefone = val.validarNumeroTelefone("Introduza o numero de telefone: ");
		grauPericulosidade = val.validarString("Introduza o grau de periculosidade (baixo/medio/alto): ", "Baixo", "Alto", "Medio");
		antecedentesCriminais = val.validarString("O suspeito tem antecedentes criminais? (Sim/Nao): ", "Sim", "Nao");
		estadoDetensao=val.validarString("Estado de dentencao (Preso/Foragido/Solto): ", "Preso", "Foragido", "Solto");
		depoimento=val.lerTexto("Depoimento: ");
		advogadoPresente=val.validarString("O advogado esta presente(Sim/Nao): ", "Sim", "Nao");
		numPessoasEnvolvidas = val.validarInt("Numero de pessoas envilvidas: ", 1);
		dataOcorrencia = val.validarData("Data de ocorrencia(DD/MM/AAAA): ");
		horaOcorrencia = val.validarHora("Hora de ocorrencia: ");
		escrever.escreverSuspeito(nome, idade, genero, nacionalidade, numeroBI, endereco, numTelefone, grauPericulosidade,antecedentesCriminais,estadoDetensao,depoimento,advogadoPresente, numPessoasEnvolvidas, dataOcorrencia, horaOcorrencia);
	}
	
	public String isAntecedentesCriminais() {return antecedentesCriminais;}
	public String isAdvogadoPresente() {return advogadoPresente;}
	public String getGrauPericulosidade() {return grauPericulosidade;}
	public String getEstadoDetensao() {return estadoDetensao;}
	public String getDepoimento() {return depoimento;}
	public static int getContadorSuspeitos() {return contadorSuspeitos;}
	
	public void setAntecedentesCriminais(String antecedentesCriminais) {this.antecedentesCriminais = antecedentesCriminais;}
	public void setAdvogadoPresente(String advogadoPresente) {this.advogadoPresente = advogadoPresente;}
	public void setGrauPericulosidade(String grauPericulosidade) {this.grauPericulosidade = grauPericulosidade;}
	public void setEstadoDetensao(String estadoDetensao) {this.estadoDetensao = estadoDetensao;}
	public void setDepoimento(String depoimento) {this.depoimento = depoimento;}
	public static void setContadorSuspeitos(int contadorSuspeitos) {Suspeito.contadorSuspeitos = contadorSuspeitos;}
	
	
	public String toString() {
		return "Suspeito ["+super.toString()+", ntecedentesCriminais=" + antecedentesCriminais + ", advogadoPresente=" + advogadoPresente
				+ ", grauPericulosidade=" + grauPericulosidade + ", estadoDetensao=" + estadoDetensao + ", depoimento="
				+ depoimento + "]";
	}
	
	
}
