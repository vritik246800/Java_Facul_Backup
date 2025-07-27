
public class Novela extends Lazer
{
	private int nCap;
	
	public static int ctNovela=0;
	
	public Novela(String titulo,float duracao,float periodo,int anoL,String paiO,int nCap)
	{
		super(titulo,duracao,periodo,anoL,paiO);
		this.nCap=nCap;
		ctNovela++;
	}
	public Novela()
	{
		this("",0,0,0,"",0);
	}
	public int getnCap()
	{
		return nCap;
	}
	public void setnCap(int nCap)
	{
		this.nCap=nCap;
	}
	public String toString()
	{
		return super.toString()+"\nNovela:"+"\nNumero de Capitulo: "+nCap;
	}
}
