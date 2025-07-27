
public class Aluno extends UmIndividuo
{
	private float media;
	private byte classe;
	
	public static int contAluno=0;
	
	public Aluno(String nome,String email,byte idade,char genero, byte classe,float media)
	{
		super (nome,email,idade,genero);
		
		this.media=media;
		this.classe=classe;
		
		contAluno++;
	}
	public Aluno()
	{
		this("","",(byte)0,' ',(byte)0,0);
	}
	public float getMedia()
	{
		return media;
	}
	public byte getClasse()
	{
		return classe;
	}
	public void setMedia(float media)
	{
		this.media=media;
	}
	public void setClasse(byte classe)
	{
		this.classe=classe;
	}
	public String toString()
	{
		return super.toString()+"\nDados do Aluno: \tClasse"+classe+" |Media: "+media ;
	}

}
