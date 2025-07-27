import java.io.*;

public class Validacoes
{
	private BufferedReader br;
	
	public Validacoes()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarByte(int a1,int a4,String s)
	{
		byte op=0;
		
		try
		{
			do
			{
				System.out.println(s);
				op=Byte.parseByte(br.readLine());
				if(op<a1 || op>a4)
					System.out.println("Opcao Invalida !");
			}while(op<a1 || op>a4);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		
		return op;
	}
	public String validarString(String s)
	{
		String ss="";
		do
		{
			System.out.println(s);
			try
			{
				ss=br.readLine();
				if(ss.length()<2)
					System.out.println("Nome Invalido !");
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		}while(ss.length()<2);
		
		return ss;
	}
	public float validarFloat(float a0,float a20,String msg )
	{
		float f=0;
		do
		{
			System.out.println(msg);
			try
			{
				f=Float.parseFloat(br.readLine());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(f<0 || f>20)
				System.out.println("Nota Invalida !!");
			
		}while(f<0 || f>20);
		
		return 0;
	}
}



