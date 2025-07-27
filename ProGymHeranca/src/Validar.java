import java.io.*;

public class Validar 
{
	private BufferedReader br;
	public Validar()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public String contacto(String mng)
	{
		String n="";
		
		do
		{
			System.out.println(mng);
			try
			{
				n=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(!n.substring(0,2).equals("82") && !n.substring(0,2).equals("83") && !n.substring(0,2).equals("84") && !n.substring(0,2).equals("85") && !n.substring(0,2).equals("86") && !n.substring(0,2).equals("87") || n.length()!=9)
				System.out.println("Erro!");
		}while(!n.substring(0,2).equals("82") && !n.substring(0,2).equals("83") && !n.substring(0,2).equals("84") && !n.substring(0,2).equals("85") && !n.substring(0,2).equals("86") && !n.substring(0,2).equals("87") || n.length()!=9);
		
		return n;
	}
}
