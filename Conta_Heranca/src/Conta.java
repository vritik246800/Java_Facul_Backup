import java.io.*;

public class Conta implements Serializable
{
	protected float saldo;
	protected String nConta,dataA;
	
	public Conta(float saldo,String nConta,String dataA)
	{
		this.saldo=saldo;
		this.nConta=nConta;
		this.dataA=dataA;
	}
	public Conta()
	{
		this(0,"","");
	}
	public void setsaldo(float saldo)
	{
		this.saldo=saldo;
	}
	public void setnConta(String nConta)
	{
		this.nConta=nConta;
	}
	public void setdataA(String dataA)
	{
		this.dataA=dataA;
	}
	public String toString()
	{
		return "Saldo: "+saldo+"\tNumero de conta: "+nConta+"\tdata de abertura: "+dataA;
	}
	
}
