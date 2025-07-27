
public final class Normal extends Particular
{
	private String estrangeiro;
	private int numeroAnosForaPais;
	public static int ctNormal=0;
	
	public Normal(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,String tipoViatura,String estrangeiro,int numeroAnosForaPais)
	{
		super(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,tipoViatura);
		this.estrangeiro=estrangeiro;
		this.numeroAnosForaPais=numeroAnosForaPais;
		ctNormal++;
	}
	public Normal()
	{
		this("","","","","","",0,0,0,"","",0);	
	}
	public void setestrangeiro(String estrangeiro)
	{
		this.estrangeiro=estrangeiro;
	}
	public String gtestrangeiro()
	{
		return estrangeiro;
	}
	public void setnumeroAnosForaPais(int numeroAnosForaPais)
	{
		this.numeroAnosForaPais=numeroAnosForaPais;
	}
	public int getnumeroAnosForaPais()
	{
		return numeroAnosForaPais;
	}
	public String toString()
	{
		return super.toString()+"\t| Vai para estrangeiro: "+estrangeiro+"\t|Anos fora do pais: "+numeroAnosForaPais+"\t|";
	}
	public float direitosAdoaneiro()
	{
		return (precoViatura*TAX25);
	}
	public float direitosAdoaneiroTotal()
	{
		return precoViatura+direitosAdoaneiro();
	}
	public float desconto()
	{
		float d=0;
		if(numeroAnosForaPais>4 && estrangeiro.equalsIgnoreCase("sim"))
		{
			d=iva()-valor_Desconto();
		}
		return iva()-d;
	}
	public float valorFinal()
	{
		return desconto()+valor_Tax_Fixa();
	}
}
