import java.io.*;
public class Ex4 
{
	public static void main(String[]args)
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		
		int n=0,d=0,valor=0;
		try
		{
			System.out.println("Introduz o valor do D: ");
			d=Integer.parseInt(br.readLine());
			System.out.println("Introduz o valor do N(Natural): ");
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException io) {System.out.println(io.getMessage());}
		
		valor=contarDigitos(n,d);
		System.out.println("O valor e igual: "+valor);
	}
	public static int contarDigitos(int n,int d)
	{
		if(n==0)
			return 0;
		int ultimo=n%10;
		if(ultimo==d)
			return 1+contarDigitos(n/10,d);
		else
			return contarDigitos(n/10,d);
	}
}
