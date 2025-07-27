
public class Lazer extends Atracao
{
	protected int anoL;
	protected String paiO;
	
	public static int ctLazer=0;
	
	public Lazer(String titulo,float duracao,float periodo,int anoL,String paiO)
	{
		super(titulo,duracao,periodo);
		this.anoL=anoL;
		this.paiO=paiO;
		ctLazer++;
	}
	public Lazer()
	{
		this("",0,0,0,"");
	}
	public int getanoL()
	{
		return anoL;
	}
	public String getpaiO()
	{
		return paiO;
	}
	public void setanoL(int anoL)
	{
		this.anoL=anoL;
	}
	public void setpaiO(String paiO)
	{
		this.paiO=paiO;
	}
	public String toString()
	{
		return super.toString()+"\nLazer:"+"\nAno de Lancamento: "+anoL+"\tPais Origem: "+paiO;
	}

}
