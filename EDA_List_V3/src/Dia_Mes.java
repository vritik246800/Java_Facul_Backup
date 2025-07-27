
public class Dia_Mes 
{
	private String nome;
	private int poz;
	
	public Dia_Mes(String n,int a)
	{
		nome=n;
		poz=a;
	}
	public Dia_Mes()
	{
		this("",0);
	}
	public String toString()
	{
		return "Nome dia ou mes: "+nome+"\tPosicao de dia ou mes: "+poz;
	}
}
