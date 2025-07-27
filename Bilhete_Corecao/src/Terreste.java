public abstract class Terreste extends Bilhete implements CalculoIVA
{
	protected float numKilometros;
	
	public Terreste(String codigo, String nome, String bi, String dataPartida, String dataChegada,
			String formaPagamento, int valorBilhete, float numKilometros) 
	{
		super(codigo, nome, bi, dataPartida, dataChegada, formaPagamento, valorBilhete);
		this.numKilometros = numKilometros;
	}

	public float getNumKilometros() {
		return numKilometros;
	}

	public void setNumKilometros(float numKilometros) {
		this.numKilometros = numKilometros;
	}
	
	public float calcularIVA() {
		return (valorBilhete * IVA);
	}
	
	//valor do IVA aplicado ao preco do bilhete
	public float calcularValorComIVA() 
	{
		return valorBilhete+calcularIVA();
	}

	public String toString() 
	{
		return super.toString()+" numKilometros=" + numKilometros + ", ";
	}
}
