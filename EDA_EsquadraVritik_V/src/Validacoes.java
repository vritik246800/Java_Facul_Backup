
import java.io.*;
public class Validacoes 
{
	private BufferedReader ler;
	public Validacoes() 
	{
		ler = new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarOpcao(String msg, byte min, byte max)
	{
		byte numero=0;
		do
		{
			System.out.println(msg);
			try
			{
				numero=Byte.parseByte(ler.readLine());
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(numero<min||numero>max)
				System.out.println("Erro!");
		}while(numero<min||numero>max);
		return numero;
	}
	public String validarString(String msg, String msgErro, int numMinCaracteres)
	{
		String nome="";
		do
		{
			System.out.println(msg);
			try
			{
				nome = ler.readLine();
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(nome.length()<numMinCaracteres)
				System.out.println(msgErro);
		}while(nome.length()<numMinCaracteres);
		return nome;
	}
	public String validarString(String msg, String op1, String op2)
	{
		String string="";
		do
		{
			System.out.println(msg);
			try
			{
				string = ler.readLine();
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!string.equalsIgnoreCase(op1) && !string.equalsIgnoreCase(op2))
				System.out.println("ERRO: Tente novamente");
		}while(!string.equalsIgnoreCase(op1) && !string.equalsIgnoreCase(op2));
		return string;
	}
	public String validarString(String msg, String op1, String op2, String op3)
	{
		String string="";
		do
		{
			System.out.println(msg);
			try
			{
				string = ler.readLine();
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!string.equalsIgnoreCase(op1) && !string.equalsIgnoreCase(op2) && !string.equalsIgnoreCase(op3))
				System.out.println("ERRO: Tente novamente");
		}while(!string.equalsIgnoreCase(op1) && !string.equalsIgnoreCase(op2) && !string.equalsIgnoreCase(op3));
		return string;
	}
	public int validarInt(String msg, int min, int max)
	{
		int numero=0;
		do
		{
			System.out.println(msg);
			try
			{
				numero=Integer.parseInt(ler.readLine());
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(numero<min||numero>max)
				System.out.println("Erro!");
		}while(numero<min||numero>max);
		return numero;
	}
	public int validarInt(String msg, int min)
	{
		int numero=0;
		do
		{
			System.out.println(msg);
			try
			{
				numero=Integer.parseInt(ler.readLine());
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(numero<min)
				System.out.println("Erro!");
		}while(numero<min);
		return numero;
	}
	public String validarNumeroTelefone(String msg)
	{
		String numero="", prefixo;
		do
		{
			System.out.println(msg);
			try
			{
				numero=ler.readLine();
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			prefixo = numero.substring(0,2);
			if(!prefixo.equals("82") && !prefixo.equals("83") && !prefixo.equals("84") && !prefixo.equals("85") && !prefixo.equals("86") && !prefixo.equals("87") || numero.length()!=9)
				System.out.println("ERRO: Numero Invalido!");
		}while(!prefixo.equals("82") && !prefixo.equals("83") && !prefixo.equals("84") && !prefixo.equals("85") && !prefixo.equals("86") && !prefixo.equals("87") || numero.length()!=9);
		return numero;
	}
	public String lerTexto(String msg)
	{
		String dados ="";
		System.out.println(msg);
		try
		{
			dados = ler.readLine();
		}
		catch(IOException i) {System.out.println(i.getMessage());};
		return dados;
	}
}
