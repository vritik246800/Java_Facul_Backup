public final class Comboio extends Terreste
{
	private String tipo;
	public static int contC = 0;
	
	public Comboio(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete, float numKilometros, String tipo) 
	{
		super(codigo, nome, bi, dataPartida, dataChegada, formaPagamento, valorBilhete, numKilometros);
		this.tipo = tipo;
		contC++;
	}
	
	public Comboio() { this("", "", "", "", "", "", 0, 0, "");}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//metodo implementado da interface
	public float calcularValorFinal() 
	{
		final float DESC = 5/100f;
		float vIVA = calcularValorComIVA();
		float d = vIVA*DESC;
		return vIVA - d;
	}

	public String toString() 
	{
		return super.toString()+" tipo=" + tipo;
	}
}
