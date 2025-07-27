
public abstract class Particular extends Cliente
{
	protected String tipoViatura;
	public Particular(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,String tipoViatura)
	{
		super(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura);
		this.tipoViatura=tipoViatura;
	}
	public Particular()
	{
		this("","","","","","",0,0,0,"");
	}
	public void settipoViatura(String tipoViatura)
	{
		this.tipoViatura=tipoViatura;
	}
	public String gettipoViatura()
	{
		return tipoViatura;
	}
	public String toString()
	{
		return super.toString()+"\tTipo de viatura: "+tipoViatura;
	}
}
