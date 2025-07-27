
public class Jornal extends Informativo
{
	private String chefe;
	
	public static int ctJornal=0;
	
	public Jornal(String titulo,float duracao,float periodo,String apresentador,String chefe)
	{
		super(titulo,duracao,periodo,apresentador);
		this.chefe=chefe;
		ctJornal++;
	}
	public Jornal()
	{
		this("",0,0,"","");
	}
	public String getchefe()
	{
		return chefe;
	}
	public void setchefe(String chefe)
	{
		this.chefe=chefe;
	}
	public String toString()
	{
		return super.toString()+"\nJornal:"+"\nEditor Chefe: "+chefe;
	}
}
