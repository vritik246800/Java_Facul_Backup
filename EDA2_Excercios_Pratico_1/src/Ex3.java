import java.io.*;
public class Ex3 
{
	public static void main(String[]args)
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		long x=0,n=0,valor=0;
		
		try
		{
			System.out.println("Intrduz o valor do numerador: ");
			n=Long.parseLong(br.readLine());
			System.out.println("Intrduz o valor do exploente: ");
			x=Long.parseLong(br.readLine());
		}
		catch(IOException io) {System.out.println(io.getMessage());}
		
		valor=potencia(n,x);
		System.out.println("O valor e igual: "+valor);
	}
	public static long potencia(long n,long x)
	{
		if(x==1)
			return n;
		else if(n==1 || x==0)
			return 1;
		return n*potencia(n,x-1);
	}
}
