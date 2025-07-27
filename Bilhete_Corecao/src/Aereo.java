
public final class Aereo extends Bilhete 
{
	private int qtdMilhas;
	private String companhiaAerea;
	public static int contA = 0;

	public Aereo(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete, int milhas, String companhia) 
	{
		super(codigo, nome, bi, dataPartida, dataChegada, formaPagamento, valorBilhete);
		this.qtdMilhas = milhas;
		this.companhiaAerea = companhia;
		contA++;
	}
	
	public Aereo() 
	{
		this("", "", "", "", "", "", 0, 0, "");
	}

	public int getQtdMilhas() {
		return qtdMilhas;
	}

	public void setQtdMilhas(int qtdMilhas) {
		this.qtdMilhas = qtdMilhas;
	}

	public void setCompanhiaAerea(String companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}

	public String toString() 
	{
		return super.toString()+ "qtdMilhas=" + qtdMilhas + ", companhiaAerea=" + companhiaAerea;
	}
	
	
}
