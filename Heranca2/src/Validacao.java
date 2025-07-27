import java.io.*;

public class Validacao 
{
	BufferedReader br;
	
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarByte(String mng)
	{
		byte b=0;
		System.out.println(mng);
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
}
