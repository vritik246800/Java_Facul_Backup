import java.io.*;

public class Bilhete implements Serializable
{
	protected String destino,passaport;
	protected int valor;
	
	public Bilhete(String destino,String passaport,int valor)
	{
		this.destino=destino;
		this.passaport=passaport;
		this.valor=valor;
		
	}
	public Bilhete() 
	{
		this("","",0);
	}
	public String getdestino(){return destino;}
	public String getpassaport() {return passaport;}
	public int getvalor() {return valor;}
	
	public void setvalor(int valor) {this.valor=valor;}
	public void setpassaport(String passaport) {this.passaport=passaport;}
	public void setdestino(String destino){this.destino=destino;}

	public float vf()
	{
		final float D=20/100f;
		return valor*D;
	}
}
