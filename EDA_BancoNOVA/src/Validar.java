import java.io.*;

public class Validar 
{
	private BufferedReader br;
	
	public Validar()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public int pin(String s,String s1)
	{
		int n=0;
		do
		{
			System.out.println(s1);
			System.out.println(s);
			System.out.println(s1);
			try
			{
				n=Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException x)
			{
				System.out.println(x.getMessage());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(n<1000 || n>10000)
			{
				System.out.println("|===============|");
				System.out.println("| PIN Invalido !|");
				System.out.println("|===============|");
			}
		}while(n<1000 || n>10000);
		return n;
	}
	public String sex(String s,String s1)
	{
		String st="";
		
		try
		{
			do
			{
				System.out.println(s1);
				System.out.println(s);
				System.out.println(s1);
				st=br.readLine();
				if(!st.equalsIgnoreCase("Masculino") && !st.equalsIgnoreCase("Feminino "))
				{
					System.out.println("|================|");
					System.out.println("|Sexo Invalido ! |");
					System.out.println("|================|");
				}
			}while(!st.equalsIgnoreCase("Masculino") && !st.equalsIgnoreCase("Feminino"));
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		
		return st;
	}
	public String nome(String s,String s1)
	{
		String st="";
		
		try
		{
			do
			{
				System.out.println(s1);
				System.out.println(s);
				System.out.println(s1);
				st=br.readLine();
			}while(st.length()<2);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		
		return st;
	}
	public int idade(String s,String s1)
	{
		int i=0;
		
		try
		{
			do
			{
				System.out.println(s1);
				System.out.println(s);
				System.out.println(s1);
				i=Integer.parseInt(br.readLine());
				if(i<18)
				{
					System.out.println("|================|");
					System.out.println("|Idade invalida !|");
					System.out.println("|================|");
				}
			}while(i<18);
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		
		return i;
	}
	public float valorD(String s,String s1)
	{
		float v=0;
		
		try
		{
			do
			{
				System.out.println(s1);
				System.out.println(s);
				System.out.println(s1);
				v=Float.parseFloat(br.readLine());
				if(v<=0)
				{
					System.out.println("|================|");
					System.out.println("|Valor invalido !|");
					System.out.println("|================|");
				}
			}while(v<=0);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return v;
		
	}
	public byte opcao()
	{
		byte o=0;
		System.out.println("|=======================|");
		System.out.println("|Introduz a opcao acima |");
		System.out.println("|=======================|");
		try
		{
			o= Byte.parseByte(br.readLine());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return o;
	}
	public int validarNC(String s,String s1)
	{
		int a=0;
		
		do
		{
			System.out.println(s1);
			System.out.println(s);
			System.out.println(s1);
			try
			{
				
				a=Integer.parseInt(br.readLine());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(a<10000000 || a>99999999)
			{
				System.out.println("|==========================|");
				System.out.println("|Numero de conta Invalida !|");
				System.out.println("|==========================|");
			}
		}while(a<10000000 || a>99999999);
		
		return a;
	}
}
