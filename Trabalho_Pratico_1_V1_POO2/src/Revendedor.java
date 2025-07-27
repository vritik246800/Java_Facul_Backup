
public final class Revendedor extends Empresarial implements Calculos_API
{
	private String nomeComercial;
	public static int ctRevendor=0;
	
	public Revendedor(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,int qtyViaturas,String nomeComercial)
	{
		super(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,qtyViaturas);
		this.nomeComercial=nomeComercial;
		ctRevendor++;
	}
	public Revendedor()
	{
		this("","","","","","",0,0,0,0,"");
	}
	public void setnomeComercial(String nomeComercial)
	{
		this.nomeComercial=nomeComercial;
	}
	public String getnomeComercial()
	{
		return nomeComercial;
	}
	public String toString()
	{
		return super.toString()+"\t| Nome do Comercial: "+nomeComercial+"\t|";
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
		return imposto()+(imposto()*IVA8);
	}
	public float desconto()
	{
		float d=0;
		if(qtyViaturas>=5)
		{
			d=iva()*qtyViaturas;
			d*=DESCONTO5;
		}
		return iva()-d;
	}
	public float valorFinal()
	{
		return desconto()+valor_Tax_Fixa();
	}
}
