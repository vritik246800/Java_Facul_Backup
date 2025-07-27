import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidacaoB 
{
	private BufferedReader br;
	public ValidacaoB()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public byte validarByte()
	{
		byte op=0;
		try
		{
			op=Byte.parseByte(br.readLine());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return op;
	}
}