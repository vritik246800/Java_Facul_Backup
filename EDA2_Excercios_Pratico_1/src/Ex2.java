import java.io.*;
public class Ex2 
{
	public Ex2()
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int n=0,valor=0;
		try
		{
			System.out.println("Introduz n para calculo do factorial:");
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		
		valor=factorial(n);
		System.out.println("Resultado:"+valor);
	}
	public int factorial(int n)
	{
		if(n==0 || n==1)
			return n;
		
		return n*factorial(n-1);
	}
	public static void main(String[]args)
	{
		new Ex2();
	}
}
