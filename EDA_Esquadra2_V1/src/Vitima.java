//No final o programa deve gerar um ficheiro de texto, onde vai coletar dados
//concluidos no no caso (ex: o suspeito e um conhecido da policia ou nao)
public class Vitima extends Individuo
{
	private Validacoes val;
	private EscreverFicheiro escrever;
	private String estadoFisico, tipoDano, relatorioVitima;
	private String atendimentoMedico;
	public static int contadorVitima=0;
	
	public Vitima(String nome, String gen, String nac, String numBI, String end, String numTelefone, int idade,String estadoFisico, String tipoDano,String relatorioVitima, String atendimentoMedico, int numPessoasEnvolvidas, String dataOcorrencia, String horaOcorrencia)
	{
		super(nome, gen, nac, numBI, end, numTelefone, idade, numPessoasEnvolvidas, dataOcorrencia, horaOcorrencia);
		this.atendimentoMedico=atendimentoMedico;
		this.tipoDano=tipoDano;
		this.relatorioVitima=relatorioVitima;
		this.estadoFisico = estadoFisico;
		contadorVitima++;
	}
	public Vitima(){this("","","","","","",0,"","","","",0,"","");}
	public Vitima(String novaVitima)
	{
		val=new Validacoes();
		escrever = new EscreverFicheiro();
		nome = val.validarString("Introduza o nome da vitima: ", "ERRO: Escreva um nome verdadeiro", 2);
		idade = val.validarInt("Idade da vitima: ", 12);
		genero = val.validarString("Introduza o genero: ", "Masculino", "Femenino");
		nacionalidade=val.validarString("Nacionalidade da vitima: ", "Erro: Introduza uma nacionalidade valida", 3);
		numeroBI=val.validarString("Numero de BI: ", "Erro: Introduza um numero valido", 10);
		endereco=val.validarString("Endereco da vitima: ", "Erro: Intruduza um endereco valido", 5);
		numTelefone = val.validarNumeroTelefone("Introduza o numero de telefone: ");
		estadoFisico = val.validarString("Estado fisico da vitima(Ferido/Hospitalizado/Ileso): ", "Ferido", "Hospitalizado", "Ileso");
		tipoDano = val.validarString("Tipo de dano (Fisico/Patrimonial/Psicologico): ", "Fisico", "Patrimonial", "Psicologico");
		relatorioVitima = val.lerTexto("Relatorio da vitima: ");
		atendimentoMedico = val.validarString("A vitima teve a atendimeto medico (Sim/Nao): ", "Sim", "Nao");
		numPessoasEnvolvidas = val.validarInt("Numero de pessoas envilvidas: ", 1);
		dataOcorrencia = val.validarData("Data de ocorrencia(DD/MM/AAAA): ");
		horaOcorrencia = val.validarHora("Hora de ocorrencia: ");
		
		escrever.escreverVitima(nome, idade, genero, nacionalidade, numeroBI, endereco, numTelefone, estadoFisico, tipoDano, relatorioVitima, atendimentoMedico, numPessoasEnvolvidas, dataOcorrencia, horaOcorrencia);
	}
	
	public String getEstadoFisico() {return estadoFisico;}
	public String getTipoDano() {return tipoDano;}
	public String getRelatorioVitima() {return relatorioVitima;}
	public String isAtendimenteMedico() {return atendimentoMedico;}
	public static int getContadorVitima() {return contadorVitima;}
	
	
	public void setEstadoFisico(String estadoFisico) {this.estadoFisico = estadoFisico;}
	public void setTipoDano(String tipoDano) {this.tipoDano = tipoDano;}
	public void setRelatorioVitima(String relatorioVitima) {this.relatorioVitima = relatorioVitima;}
	public void setAtendimenteMedico(String atendimenteMedico) {this.atendimentoMedico = atendimenteMedico;}
	public static void setContadorVitima(int contadorVitima) {Vitima.contadorVitima = contadorVitima;}
	
	public String toString() 
	{
		return "Vitima   ["+super.toString()+"estadoFisico=" + estadoFisico + ", tipoDano=" + tipoDano + ", relatorioVitima="
				+ relatorioVitima + ", atendimenteMedico=" + atendimentoMedico + "]";
	}
}
