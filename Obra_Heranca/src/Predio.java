
public final class Predio extends Habitacao
{
	private int nAndar;
	public static int ctPredio=0;
	
	public Predio(String nomeEng,float duracao,String morada,int metro2,int nAndar)
	{
		super(nomeEng,duracao,morada,metro2);
		this.nAndar=nAndar;
		ctPredio++;
	}
	public Predio()
	{
		this("",0,"",0,0);
	}
	public float vp()
	{
		return vpH()*nAndar;
	}
	public int getnAndar()
	{
		return nAndar;
	}
	public void setnAndar(int nAndar)
	{
		this.nAndar=nAndar;
	}
	public String toString()
	{
		return super.toString()+"\nPredio:\nNumero de andar: "+nAndar;
	}
}
