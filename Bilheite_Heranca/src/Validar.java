import java.io.*;


public class Validar 
{
	private BufferedReader br;
	
	Validar()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		
		
	}
	int validarI(String s)
	{
		int i=0;
		System.out.println(s);
		try
		{
			i=Integer.parseInt(br.readLine());
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		
		return i;
	}
}
