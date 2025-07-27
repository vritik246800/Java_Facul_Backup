
public final class Poupanca extends Deposito
{
	public static int ctP=0;
	private float vdf,vj;
	private int nM;
	
	public Poupanca(float s,String nc,String da,char t,float vdf,int nM)
	{
		super(s,nc,da,t);
		this.vdf=vdf;
		this.nM=nM;
		ctP++;
	}
	public Poupanca()
	{
		this(0,"","",' ',0,0);
	}
	public float calculardespesafinal()
	{
		return cP()+3/100f*vdf;
	}
	public float cj()
	{
		final float J1=13/100f,J2=17/100f;	
		if(nM>7)
			return saldo+(saldo*J2);
		else
		{
			return saldo+(saldo*J1);
		}
	}
	public void setvdf(float vdf)
	{
		this.vdf=cj();
	}
	public float getvdf()
	{
		return vdf;
	}
	public void setvj(float vj)
	{
		this.vj=vj;
	}
	public float getvj()
	{
		return vj;
	}
	public void setnM(int nM)
	{
		this.nM=nM;
	}
	public int getnM()
	{
		return nM;
	}
	public String toString()
	{
		return super.toString()+"\tValor deposito Fixo: "+vdf+"\tValor de Juros: "+vj+"\tNumero de Mes: "+nM;
	}
	

}
