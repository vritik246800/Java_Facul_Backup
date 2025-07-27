
public final class Vivenda extends Habitacao
{
	private String piscina;
	public static int ctVivenda=0;
	
	public Vivenda(String nomeEng,float duracao,String morada,int metro2,String piscina)
	{
		super(nomeEng,duracao,morada,metro2);
		this.piscina=piscina;
		ctVivenda++;
	}
	public Vivenda()
	{
		this("",0,"",0,"");
	}
	public float vp()
	{
		final int V=200000;
		if(piscina.equalsIgnoreCase("Sim"))
			return vpH()*V;
		return 0;
	}
	public String getpiscina()
	{
		return piscina;
	}
	public void setpiscina(String piscina)
	{
		this.piscina=piscina;
	}
	public String toString()
	{
		return super.toString()+"\nVivenda:\nTem Piscina: "+piscina;
	}
}
