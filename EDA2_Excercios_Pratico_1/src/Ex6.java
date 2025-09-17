import java.io.*;
import java.util.Random;
public class Ex6 
{
	public static void main(String[]args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Random r=new Random();
		
		int n=0;
		System.out.println("Introduz o tamanho do array (>0)");
		try
		{
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException io) {System.out.println(io.getMessage());}
		if(n<=0)
		{
			System.out.println("ERRO");
			System.exit(0);
		}
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		{
			a[i]=r.nextInt(5);
			System.out.print(a[i]+"  ");
		}
		String valor=invertido(a,n-1);
		System.out.println("\nO valor invert e esse: "+valor);	
	}
	public static String invertido(int []a,int n)
	{
		if(n<0)
			return "";
		return a[n]+" "+invertido(a,n-1);
	}
}
