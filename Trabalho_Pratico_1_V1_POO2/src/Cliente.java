import java.io.*;

public abstract class Cliente implements Serializable
{
	protected String numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura;
	protected int codeViatura,cilindragem,precoViatura;
	
	public Cliente(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura)
	{
		this.numeroTelefone=numeroTelefone;
		this.nomeCliente=nomeCliente;
		this.dataCompra=dataCompra;
		this.estadoCompra=estadoCompra;
		this.marcaViatura=marcaViatura;
		this.modeloViatura=modeloViatura;
		this.codeViatura=codeViatura;
		this.cilindragem=cilindragem;
		this.precoViatura=precoViatura;
		
	}
	public Cliente()
	{
		this("","","","","","",0,0,0);
	}
	public void setnumeroTelefone(String numeroTelefone)
	{
		this.numeroTelefone=numeroTelefone;
	}
	public String getnumeroTelefone()
	{
		return numeroTelefone;
	}
	public void setnomeCliente(String nomeCliente)
	{
		this.nomeCliente=nomeCliente;
	}
	public String getnomeCliente()
	{
		return nomeCliente;
	}
	public void setdataCompra(String dataCompra)
	{
		this.dataCompra=dataCompra;
	}
	public String getdataCompra() 
	{
		return dataCompra;
	}
	public void setestadoCompra(String estadoCompra)
	{
		this.estadoCompra=estadoCompra;
	}
	public String getestadoCompra()
	{
		return estadoCompra;
	}
	public void setmarcaViatura(String marcaViatura)
	{
		this.marcaViatura=marcaViatura;
	}
	public String getmarcaViatura()
	{
		return marcaViatura;
	}
	public void setmodeloViatura(String modeloViatura)
	{
		this.modeloViatura=modeloViatura;
	}
	public String getmodeloViatura()
	{
		return modeloViatura;
	}
	public void setcodeViatura(int codeViatura)
	{
		this.codeViatura=codeViatura;
	}
	public int getcodeViatura()
	{
		return codeViatura;
	}
	public void setcilindragem(int cilindragem)
	{
		this.cilindragem=cilindragem;
	}
	public int getcilindragem()
	{
		return cilindragem;
	}
	public void setprecoViatura(int precoViatura)
	{
		this.precoViatura=precoViatura;
	}
	public int getprecoViatura()
	{
		return precoViatura;
	}
	public String toString()
	{
		return "| Numero Telefone: "+numeroTelefone+"\t|Nome do(a) Clinete: "+nomeCliente+"\t|Data da compra: "+dataCompra+"\t|Estado da compra: "+estadoCompra+"\t|Marca da Viatura: "+marcaViatura+"\t|Modelo da Viatura: "+modeloViatura+"\t|Codigo da viatura"+codeViatura+"\t|Cilidagems: "+cilindragem+"\t|Valor da Viatura: "+precoViatura+" |";
	}
	public float direitosAdoaneiro()
	{
		final float TAX15=15/100f;
		return (precoViatura*TAX15);
	}
	public float direitosAdoaneiroTotal()
	{
		return precoViatura+direitosAdoaneiro();
	}
	public abstract float valorFinal();
	public float valor_Tax_Fixa()
	{
		final int TAXADOANEIRO10=10000,TAXINSPENSAO5=5000;
		return TAXADOANEIRO10+TAXINSPENSAO5;
	}
}
