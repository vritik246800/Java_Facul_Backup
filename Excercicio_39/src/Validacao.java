import java.io.*;
public class Validacao 
{
	private BufferedReader br;
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public int validar(String a )
	{
		int n=0;
		System.out.println(a);
		try
		{
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return n;
	}
	public char op()
	{
		char n=' ';
		try
		{
			n=br.readLine().charAt(0);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return n;
	}
}
