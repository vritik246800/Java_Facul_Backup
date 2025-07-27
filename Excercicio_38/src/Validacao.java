import java.io.*;

public class Validacao 
{
	private BufferedReader br;
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public int code(String m,int a,int b)
	{
		int i=0;
		do
		{
			System.out.println(m);
			try
			{
				i=Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException z)
			{
				System.out.println(z.getMessage());
			}
			catch(IOException x)
			{
				System.out.println(x.getMessage());
			}
			if(i<a || i>b)
				System.out.println("ERRO !");
		}while(i<=0);
		return i;
	}
	public char op()
	{
		char a=' ';
		try
		{
			a=br.readLine().charAt(0);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return a;
	}
}