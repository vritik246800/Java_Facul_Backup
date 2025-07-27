
public class Professor extends UmIndividuo
{
	private byte numeHora;
	
	public static int contProfessor=0;
	
	public Professor(String nome,String email,byte idade,char genero,byte numeHora)
	{
		super(nome,email,idade,genero);
		
		this.numeHora=numeHora;
		contProfessor++;
		
	}
	public Professor()
	{
		this("","",(byte)0,' ',(byte)0);
	}
	public byte getNumHora()
	{
		return numeHora;
	}
	public void setNumHora(byte numeHora)
	{
		this.numeHora=numeHora;
	}
	public String toString()
	{
		return super.toString()+"\nDados do PROFESSOR: "+"Numero de Horas: "+numeHora ;
	}
	
}
