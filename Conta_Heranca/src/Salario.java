
public class Salario extends Conta
{
	private String nE;
	private float vs,vp;
	public static int ctS=0;
	
	public Salario(float s,String nc,String da,String nE,float vs,float vp)
	{
		super(s,nc,da);
		this.nE=nE;
		this.vs=vs;
		this.vp=vp;
		ctS++;
	}
	public Salario()
	{
		this(0,"","","",0,0);
	}
	public float cp()
	{
		final float P=9/100f;
		return vs+vs*P;
	}
	public void setnE(String nE)
	{
		this.nE=nE;
	}
	public String getnE()
	{
		return nE;
	}
	public void setvs(float vs)
	{
		this.vs=vs;
	}
	public float getvs()
	{
		return vs;
	}
	public void setvp(float vp)
	{
		this.vp=cp();
	}
	public float getvp()
	{
		return vs;
	}
	public String toString()
	{
		return super.toString()+"\tNumero da Empresa: "+nE+"\tValor do salario: "+vs+"\tValor da pensao: "+vp;
	}
}















