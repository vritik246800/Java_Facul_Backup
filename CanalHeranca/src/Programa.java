
public class Programa extends Informativo
{
	private String nDi,tProg;
	
	public static int ctPrograma=0;;
	
	public Programa(String titulo,float duracao,float periodo,String apresentador,String nDi,String tProg)
	{
		super(titulo,duracao,periodo,apresentador);
		this.nDi=nDi;
		this.tProg=tProg;
		ctPrograma++;
	}
	public Programa()
	{
		this("",0,0,"","","");
	}
	public String getnDi()
	{
		return nDi;
	}
	public void setnDi(String nDi)
	{
		this.nDi=nDi;
	}
	public String gettProg()
	{
		return tProg;
	}
	public void settProg(String tProg)
	{
		this.tProg=tProg;
	}
	public String toString()
	{
		return super.toString()+"\nPrograma:"+"\nDirector: "+nDi+"\tTipo Programa: "+tProg;
	}
}
