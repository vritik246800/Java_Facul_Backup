import java.io.*;

public class Atracao implements Serializable
{
	protected String titulo;
	protected float duracao,periodo;
	
	public Atracao(String titulo,float duracao,float periodo)
	{
		this.titulo=titulo;
		this.duracao=duracao;
		this.periodo=periodo;
	}
	public Atracao()
	{
		this("",0,0);
	}
	public String gettitulo()
	{
		return titulo;
	}
	public void settitulo(String titulo)
	{
		this.titulo=titulo;
	}
	public void setduracao(float duracao)
	{
		this.duracao=duracao;
	}
	public void setperiodo(float periodo)
	{
		this.periodo=periodo;
	}
	public float getduracao()
	{
		return duracao;
	}
	public String toString()
	{
		return "Titulo: "+titulo+"\tDuracao: "+duracao+"\tPeriodo: "+periodo;
	}
	
}
