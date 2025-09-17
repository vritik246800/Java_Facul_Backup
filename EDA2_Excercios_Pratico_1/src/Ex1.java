import java.io.*;
public class Ex1 
{
	public Ex1()
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int n=0,valor=0;
		try
		{
			System.out.println("Introduz n-estimo numero de Fibonacci:");
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		
		valor=somadoAntecessor(n);
		System.out.println("Resultado:"+valor);
	}
	public int somadoAntecessor(int n)
	{
		if(n==1 || n==0)
			return n;
		return somadoAntecessor(n-1)+somadoAntecessor(n-2);
	}
	public static void main(String[]args)
	{
		new Ex1();
	}
}
