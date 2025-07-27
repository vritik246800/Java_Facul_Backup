
public final class Corrente extends Deposito
{
	private String nCartao,dataV;
	public static int  ctC=0;
	
	public Corrente(float s,String nc,String da,char t,String nC,String dv)
	{
		super(s,nc,da,t);
		this.nCartao=nC;
		this.dataV=dv;
		ctC++;
	}
	public Corrente()
	{
		this(0,"","",' ',"","");
	}
	public float calculardespesafinal()
	{
		final float V=500;
		return cP()+V;
	}
	public void setnCartao(String nCartao)
	{
		this.nCartao=nCartao;
	}
	public String getnCartao()
	{
		return nCartao;
	}
	public void setdataV(String dataV)
	{
		this.dataV=dataV;
	}
	public String getdataV()
	{
		return dataV;
	}
	public String toString ()
	{
		return super.toString()+"\tNumero Conta: "+nCartao+"\tdata de Validade: "+dataV;
	}
}
