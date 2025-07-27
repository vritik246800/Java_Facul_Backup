import java.io.*;

public class Validacao 
{
	private BufferedReader br;
	
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarByte(String m)
	{
		byte b=0;
		
		System.out.println(m);
		try
		{
			b=Byte.parseByte(br.readLine());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return b;
	}
	public int validarInt(String mng,String mg)
	{
		int p=0;
		
		do
		{
			System.out.println(mng);
			try
			{
				p=Integer.parseInt(br.readLine());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(p<=0 || p>1000 )
				System.out.println(mg);
		}while(p<=0);
		return p;
	}
	public String validarString(String m1,String m2)
	{
		String s="";
		
		//do
		//{
			System.out.println(m1);
			try
			{
				s=br.readLine();
				if(s.length()<2)
					System.out.println("ERRO!");
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		//}while();
		return s;
	}
	
}
