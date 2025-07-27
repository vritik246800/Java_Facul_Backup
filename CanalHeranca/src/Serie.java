
public class Serie extends Lazer
{
	private int nTempo,nCapPT,dExib;
	
	public static int ctSerie=0;
	
	public Serie(String titulo,float duracao,float periodo,int anoL,String paiO,int nTempo,int nCapPT,int dExib)
	{
		super(titulo,duracao,periodo,anoL,paiO);
		this.nTempo=nTempo;
		this.nCapPT=nCapPT;
		this.dExib=dExib;
		ctSerie++;
	}
	public Serie()
	{
		this("",0,0,0,"",0,0,0);
	}
	public int getnTempo()
	{
		return nTempo;
	}
	public void setnTempo(int nTempo)
	{
		this.nTempo=nTempo;
	}
	public int getnCapPT()
	{
		return nCapPT;
	}
	public void setnCapPT(int nCapPT)
	{
		this.nCapPT=nCapPT;
	}
	public int getdExib()
	{
		return dExib;
	}
	public void setdExib(int dExib)
	{
		this.dExib=dExib;
	}
	public String toString()
	{
		return super.toString()+"\nSerie:"+"\nNumero Temporada: "+nTempo+"\tNumero de Capitulo por Temporada: "+nCapPT+"\tdia de Exibicao: "+dExib;
	}

}
