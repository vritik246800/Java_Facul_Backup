
public class Alunos 
{
	private String nome;
	private int cla;
	
	public Alunos(String n,int cl)
	{
		nome=n;
		cla=cl;
	}
	public Alunos()
	{
		this("",0);
	}
	public String toString()
	{
		return "Nome: "+nome+"\tClass: "+cla;
	}

}
