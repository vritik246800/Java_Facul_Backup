import java.io.*;
import java.util.Random;
public class Ex5 
{
	public static void main(String[]args)
	{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		Random r=new Random();
		
		int n=0,valor;
		try
		{
			System.out.println("Introduz o tamalho de array: ");
			n=Integer.parseInt(br.readLine());
		}
		catch(IOException io) {System.out.println(io.getMessage());}
		
		int d[]=new int[n];
		for(int i=0;i<d.length;i++)
		{
			d[i]=r.nextInt(500);
			System.out.println(d[i]);
		}
		valor=array(d,0);
		System.out.println("O valor e igual: "+valor);
	}
	public static int array(int [] a,int i)
	{
		if(i==a.length)
			return 0;
		return a[i]+array(a,i+1);
	}
}
