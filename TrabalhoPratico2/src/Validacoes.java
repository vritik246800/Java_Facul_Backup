import java.io.*;
public class Validacoes 
{
	private BufferedReader br;
	public Validacoes()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public String validarR()
	{
		String n=" ";
		do
		{
			System.out.println("|====================================|");
			System.out.println("| O cliente e turista(Sim | Nao) ? : |");
			System.out.println("|====================================|");
			
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(!n.equalsIgnoreCase("Sim") && !n.equalsIgnoreCase("Nao"))
			{
				System.out.println("|=====================|");
				System.out.println("| Resposta Invalida ! |");
				System.out.println("|=====================|");
			}
		}while(!n.equalsIgnoreCase("Sim") && !n.equalsIgnoreCase("Nao"));
		return n;
	}
	public byte validarOP()
	{
		byte op=0;
		try
		{
			op=Byte.parseByte(br.readLine());	
		}
		catch(NumberFormatException z)
		{
			System.out.println(z.getMessage());
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		return op;
	}
	public String validarPesq(String msg,String l1)
	{
		String n="";
		System.out.println(l1);
		System.out.println(msg);
		System.out.println(l1);
		try
		{
			n=br.readLine();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return n;
	}
	public String validarResp(String msg1,String msg2,String l1,String l2)
	{
		String n="";
		do
		{
			System.out.println(l1);
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(!n.equalsIgnoreCase("Sim") && !n.equalsIgnoreCase("Nao"))
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(!n.equalsIgnoreCase("Sim") && !n.equalsIgnoreCase("Nao"));
		return n;
	}
	public String validarDS(String dataE,String msg1,String msg2,String l1,String l2)
	{
		String n="",ano="",mes="";
		int diaS=0,diaE=0;
		do
		{
			System.out.println(l1);
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			ano=n.substring(0,4);
			mes=n.substring(5,7);
			diaS=Integer.parseInt(n.substring(8,10));
			diaE=Integer.parseInt(n.substring(8,10));
			
			if(n.length()!=10 && !ano.equals("2024") && !mes.equals("09") && diaS<=diaE || diaS>30)
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(n.length()!=10 && !ano.equals("2024") && !mes.equals("09") && diaS<=diaE || diaS>30);
		return n;
	}
	public String validarDE(String msg1,String msg2,String l1,String l2)
	{
		String n="",ano="",mes="";
		int dia=0;
		do
		{
			System.out.println(l1);
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			
			ano=n.substring(0,4);
			mes=n.substring(5,7);
			dia=Integer.parseInt(n.substring(8,10));
			
			if(n.length()!=10 && !ano.equals("2024") && !mes.equals("09") && dia<1 || dia>29)
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(n.length()!=10 && !ano.equals("2024") && !mes.equals("09") && dia<1 || dia>29);
		return n;
	}
	public String validarString(String msg1,String msg2,String a,String b,String c,String l1,String l2)
	{
		String n="";
		do
		{
			System.out.println(l1);	
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(!n.equalsIgnoreCase(a) && !n.equalsIgnoreCase(b) && !n.equalsIgnoreCase(c))
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(!n.equalsIgnoreCase(a) && !n.equalsIgnoreCase(b) && !n.equalsIgnoreCase(c));
		return n;
	}
	public String validarStringN(String msg1,String msg2,String l1,String l2)
	{
		String n="";
		do
		{
			System.out.println(l1);
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(n.length()<2)
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(n.length()<2);
		return n;
	}
	public String validarStringT(String msg1,String msg2,String l1,String l2)
	{
		String n="",m="";
		do
		{
			System.out.println(l1);
			System.out.println(msg1);
			System.out.println(l1);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			m=n.substring(0,2);
			if(n.length()!=9 || !m.equals("82") && !m.equals("83") && !m.equals("84") && !m.equals("85") && !m.equals("86") && !m.equals("87"));
			{
				System.out.println(l2);
				System.out.println(msg2);
				System.out.println(l2);
			}
		}while(n.length()!=9 || !m.equals("82") && !m.equals("83") && !m.equals("84") && !m.equals("85") && !m.equals("86") && !m.equals("87"));
		return n;
	}
	
}