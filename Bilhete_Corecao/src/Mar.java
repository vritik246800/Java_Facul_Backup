
public final class Mar extends Bilhete 
{
	private String tipo;
	public static int contM = 0;
	
	public Mar(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete, String tipo) 
	{
		super(codigo, nome, bi, dataPartida, dataChegada, formaPagamento, valorBilhete);
		this.tipo = tipo;
		contM++;
	}
	
	public Mar() 
	{
		this("", "", "", "", "", "", 0,"");
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() 
	{
		return super.toString()+"tipo=" + tipo;
	}
}
