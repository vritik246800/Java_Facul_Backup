
public abstract class Particular extends Cliente implements Calculos_API
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
	public float imposto()
	{
		final float IMPOSTO=10/100f;
		if(cilindragem>2000)
		{
			return direitosAdoaneiroTotal()+(direitosAdoaneiroTotal()*IMPOSTO);
		}
		return direitosAdoaneiroTotal();
	}
	public float iva()
	{
		return imposto()+(imposto()*IVA16);
	}
	public float valor_Desconto()
	{
		return (iva()*DESCONTO3);
	}
}
