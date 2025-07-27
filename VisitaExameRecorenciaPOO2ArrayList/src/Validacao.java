import java.io.*;

public class Validacao
{
	private BufferedReader br;
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public String VS()
	{
		String s="";
		
		do
		{
			System.out.println("Introduz o tipo de Actividade ( Game Drive || Bush Braai || Cycling ) ?");
			try
			{
				s=br.readLine();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(s.length()<2);
				System.out.println("O tipo de actividade Invalida !! ");
			
		}while(s.length()<2);
		
		return s;
	}
	
}
