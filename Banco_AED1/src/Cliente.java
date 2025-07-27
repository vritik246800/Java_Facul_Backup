import java.text.DecimalFormat;
import java.io.*;

public class Cliente implements Serializable
{
	private DecimalFormat m;
	
	private String nome,sex;
	private int idade, numeroC,pin;
	private float valorD;
	
	
	public Cliente(String nome,String sex,int idade,int numeroC,int pin,float valorD)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		
		this.nome=nome;
		this.sex=sex;
		this.idade=idade;
		this.numeroC=numeroC;
		this.pin=pin;
		this.valorD=valorD;
		
	}
	public String getsex()
	{
		return sex;
	}
	public int getidade()
	{
		return idade;
	}
	public String getnome()
	{
		return nome;
	}
	public float getvalorD()
	{
		return valorD;
	}
	public int getnumeroC()
	{
		return numeroC;
	}
	public int getpin()
	{
		return pin;
	}
	public String toString()
	{
		String meio,barr;
		
		barr="[--------------------------------------------------------------------------------------------------------------------------------]\n";
		meio="[ Nome: "+nome+"\t|Sexo: "+sex+"\t|Idade: "+idade+"\t|Numero de conta: "+numeroC+"\t|Pin: "+pin+"\t|Saldo: "+m.format(valorD)+"\t]\n";
		
		return barr+meio+barr;          
	}
	
}







