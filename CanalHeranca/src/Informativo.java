
public class Informativo extends Atracao
{
	protected String apresentador;
	
	public static int ctInformativo=0;
	
	public Informativo(String titulo,float duracao,float periodo,String apresentador)
	{
		super(titulo,duracao,periodo);
		this.apresentador=apresentador;
		ctInformativo++;
	}
	public Informativo()
	{
		this("",0,0,"");
	}
	public String getapresentador()
	{
		return apresentador;
	}
	public void setapresentador(String apresentador)
	{
		this.apresentador=apresentador;
	}
	public String toString()
	{
		return super.toString()+"\nInformativo:"+"\nNome Apresentador: "+apresentador;
	}
}
