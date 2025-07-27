
public final class Doutorado extends Particular
{
	public static int ctDoutorado=0;
	private String dataCDoutoramento;
	
	public Doutorado(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,String tipoViatura,String dataCDoutoramento)
	{
		super(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,tipoViatura);
		this.dataCDoutoramento=dataCDoutoramento;
		ctDoutorado++;
	}
	public Doutorado()
	{
		this("","","","","","",0,0,0,"","");
	}
	public void setdataCDoutoramento(String dataCDoutoramento)
	{
		this.dataCDoutoramento=dataCDoutoramento;
	}
	public String getdataCDoutoramento()
	{
		return dataCDoutoramento;
	}
	public String toString()
	{
		return super.toString()+"\t|Data do Doutoramento: "+dataCDoutoramento+"\t|";
	}
	public float desconto()
	{
		float d=0;
		String dia,mes;
		int dia1,mes1;
		
		mes=dataCDoutoramento.substring(0,2);
		dia=dataCDoutoramento.substring(3,5);
		mes1=Integer.parseInt(mes);
		dia1=Integer.parseInt(dia);
		
		if(mes1<5 && dia1<1)
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
