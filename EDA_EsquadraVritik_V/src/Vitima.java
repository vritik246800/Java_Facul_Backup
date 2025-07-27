
public class Vitima extends Individuo
{
	private Validacoes val;
	private EscreverFicheiro escrever;
	private String estadoFisico, tipoDano, relatorioVitima;
	private String atendimentoMedico;
	public static int contadorVitima=0;
	public Vitima(String nome, String gen, String nac, String numBI, String end, String numTelefone, int idade,String estadoFisico, String tipoDano,String relatorioVitima, String atendimentoMedico)
	{
		super(nome, gen, nac, numBI, end, numTelefone, idade);
		this.atendimentoMedico=atendimentoMedico;
		this.tipoDano=tipoDano;
		this.relatorioVitima=relatorioVitima;
		this.estadoFisico = estadoFisico;
		contadorVitima++;
	}
	public Vitima(){this("","","","","","",0,"","","","");}
	public Vitima(String novaVitima)
	{
		val=new Validacoes();
		escrever = new EscreverFicheiro();
		nome = val.validarString("Introduza o nome da vitima: ", "ERRO: Escreva um nome verdadeiro", 2);
		idade = val.validarInt("Idade do vitima: ", 12);
		genero = val.validarString("Introduza o genero: ", "Masculino", "Femenino");
		nacionalidade=val.validarString("Nacionalidade do vitima: ", "Erro: Introduza uma nacionalidade valida", 3);
		numeroBI=val.validarString("Numero de BI: ", "Erro: Introduza um numero valido", 10);
		endereco=val.validarString("Endereco do vitima: ", "Erro: Intruduza um endereco valido", 5);
		numTelefone = val.validarNumeroTelefone("Introduza o numero de telefone: ");
		estadoFisico = val.validarString("Estado fisico da vitima(Ferido/Hospitalizado/Ileso): ", "Ferido", "Hospitalizado", "Ileso");
		tipoDano = val.validarString("Tipo de dano (Fisico/Patrimonial/Psicologico): ", "Fisico", "Patrimonial", "Psicologico");
		relatorioVitima = val.lerTexto("Relatorio da vitima: ");
		atendimentoMedico = val.validarString("A vitima teve a atendimeto medico (Sim/Nao): ", "Sim", "Nao");
		escrever.escreverVitima(nome, idade, genero, nacionalidade, numeroBI, endereco, numTelefone, estadoFisico, tipoDano, relatorioVitima, atendimentoMedico);
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
		return "Vitima ["+super.toString()+"estadoFisico=" + estadoFisico + ", tipoDano=" + tipoDano + ", relatorioVitima="
				+ relatorioVitima + ", atendimenteMedico=" + atendimentoMedico + "]";
	}
}
