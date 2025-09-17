import java.io.*;

public class Ex7 
{
	public static void main(String[]args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int numero=0;
		System.out.println("Introduz numero int para converter para binario: ");
		try
		{
			numero=Integer.parseInt(br.readLine());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		System.out.println("O valor: "+numero+" para binario e: ");
		converterBin(numero);
	}
	public static void converterBin(int n)
	{
		if(n>0)
			converterBin(n/2);
		System.out.print(n%2);
	}
}
