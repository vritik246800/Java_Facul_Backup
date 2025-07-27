
public abstract class Habitacao extends Obra
{
	protected String morada;
	protected int metro2;
	public static int ctHabitacao=0;
	
	public Habitacao(String nomeEng,float duracao,String morada,int metro2)
	{
		super(nomeEng,duracao);
		this.morada=morada;
		this.metro2=metro2;
		ctHabitacao++;
	}
	public Habitacao()
	{
		this("",0,"",0);
	}
	public float vpH()
	{
		final int V=100000;
		return metro2*V;
	}
	public String getmorada()
	{
		return morada;
	}
	public void setmorada(String morada)
	{
		this.morada=morada;
	}
	public int setmetro2()
	{
		return metro2;
	}
	public void setmetro2(int metro2)
	{
		this.metro2=metro2;
	}
	public String toString()
	{
		return super.toString()+"\nHabitacao:\nMorada: "+morada+"\tMetro quadado: "+metro2;
	}
}
