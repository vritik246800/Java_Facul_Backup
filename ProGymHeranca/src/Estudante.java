import java.util.ArrayList;

public class Estudante extends ProGym
{
	private String nomeE;
	private int code;
	private float vpe;
	
	public static int ctEstudante=0;
	
	public Estudante(String nome,int idade,String contacto,float peso,String nomeE,int code)
	{
		super(nome,idade,contacto,peso);
		this.nomeE=nomeE;
		this.code=code;
		
		ctEstudante++;
	}
	public float vpE()
	{
		final int E=1500;
		final float D=15/100f;
		float vp=0,d=0;
		ProGym pai;
		Estudante e;
		
		vp=E;
		if(nomeE.equalsIgnoreCase("ISCTEM"))
		{
			d=vp*D;
		}
		
		return vp-d;
	}
	public float getvpe()
	{
		return vpe;
	}
	public Estudante()
	{
		this("",0,"",0,"",0);
	}
	public String getnomeE()
	{
		return nomeE;
	}
	public int getcode()
	{
		return code;
	}
	public void setcode(int code)
	{
		this.code=code;
	}
	public void setnomeE(String nomeE)
	{
		this.nomeE=nomeE;
	}
	public String toString()
	{
		return super.toString()+"\nEstudante\n"+"Nome de Estudante: "+nomeE+"\tCode de Estudante: "+code;
	}
	
}
