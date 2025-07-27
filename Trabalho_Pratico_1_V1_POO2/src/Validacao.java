import java.io.*;

public class Validacao 
{
	BufferedReader br;
	
	
	public Validacao()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarOpcao(String s,String s1)
	{
		byte op=0;
		System.out.println(s1);
		System.out.println(s);
		System.out.println(s1);
		try
		{
			op=Byte.parseByte(br.readLine());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		return op;
	}

}
