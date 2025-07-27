
public class UmIndividuo 
{
	protected String nome,email;
	protected byte idade;
	protected char genero;
	
	public UmIndividuo(String nome,String email,byte idade,char genero)
	{
		this.nome=nome;
		this.email=email;
		this.idade=idade;
		this.genero=genero;
		
	}
	public UmIndividuo()
	{
		this("","",(byte) 0,' ');
	}
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setGenero(char genero)
	{
		this.genero=genero;
	}
	public void setIdade(byte idade)
	{
		this.idade=idade;
	}
	public String toString()
	{
		return "\nNome: "+nome+" |Email: "+email+" |Idade: "+idade+" |Genero: "+genero;
	}
}
