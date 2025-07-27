import java.io.*;

public class Validacao 
{
	private BufferedReader br;
	
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public String lerC(String a)
	{
		String s="";
		do
		{
			System.out.println(a);
			
			try
			{
				
				s=br.readLine();
				if(s.length()<2)
					System.out.println("tenta novamemte !");
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		}while(s.length()<2);
		return s;
	}
}
