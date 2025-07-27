
public class AgenteComerciante extends Agente{
	
	private int codComerciante; // numTransacoes
	private int valTransacao;
	public static int contC;
	
	public AgenteComerciante(int c, String n, char t, float v, int cD, int vT) 
	{
		super(c,n,t,v);
		codComerciante = cD;
		valTransacao = vT;
		contC++;
	}
	
	public AgenteComerciante() 
	{
		this(0,"",' ',0,0,0);
	}

	public void setCodComerciante(int codComerciante) {
		this.codComerciante = codComerciante;
	}

	public void setValTransacao(int valTransacao) {
		this.valTransacao = valTransacao;
	}
	
	public int getCodComerciante() {
		return codComerciante;
	}

	public int getValTransacao() {
		return valTransacao;
	}

	public String toString() {
		return "AgenteComerciante [codComerciante=" + codComerciante + ", valTransacao=" + valTransacao + ", codigo="
				+ codigo + ", nome=" + nome + ", tipoAgente=" + tipoAgente + ", valorComissao=" + valorComissao + "]";
	}	
}
