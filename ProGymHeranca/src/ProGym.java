import java.io.*;

public class ProGym implements Serializable
{
	protected String nome,contacto;
	protected int idade;
	protected float peso;
	
	public ProGym(String nome,int idade,String contacto,float peso)
	{
		this.nome=nome;
		this.idade=idade;
		this.contacto=contacto;
		this.peso=peso;
	}
	public ProGym()
	{
		this("",0,"",0);
	}
	public void setnome(String nome)
	{
		this.nome=nome;
	}
	public void setidade(int idade)
	{
		this.idade=idade;
	}
	public String getcontacto()
	{
		return contacto;
	}
	public void setcontacto(String contacto)
	{
		this.contacto=contacto;
	}
	public float getpeso()
	{
		return peso;
	}
	public void setpeso(float peso)
	{
		this.peso=peso;
	}
	public String toString()
	{
		return "[Nome: "+nome+"\tIdade: "+idade+"\tContacto: "+contacto+"\tPeso: "+peso+"\n";
	}
}
