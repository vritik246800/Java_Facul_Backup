
public final class Carro extends Terreste
{
	private String matricula;
	private float qtdCombustivel;
	private int valorPortagem;
	public static int contV=0;

	public Carro(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete, float numKilometros, String matricula, float qtdCombustivel, int valorPortagem) 
	{
		super(codigo, nome, bi, dataPartida, dataChegada, formaPagamento, valorBilhete, numKilometros);
		this.matricula = matricula;
		this.qtdCombustivel = qtdCombustivel;
		this.valorPortagem = valorPortagem;
		contV++;
	}

	public Carro() 
	{
		this("", "", "", "", "", "", 0, 0, "", 0, 0);
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setQtdCombustivel(float qtdCombustivel) {
		this.qtdCombustivel = qtdCombustivel;
	}
	public void setValorPortagem(int valorPortagem) {
		this.valorPortagem = valorPortagem;
	}
	
	//metodo implementado da interface
	public float calcularValorFinal() {
		float vIVA = calcularValorComIVA();
		return (vIVA+valorPortagem);
	}
	
	public String toString() 
	{
		return super.toString()+" matricula=" + matricula + ", qtdCombustivel=" + qtdCombustivel + ", valorPortagem="
				+ valorPortagem;
	}

}
