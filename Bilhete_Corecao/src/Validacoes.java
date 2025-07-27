import java.io.*;
public class Validacoes 
{
	private BufferedReader br;
	
	public Validacoes() 
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String validarString(String msg) 
	{
		String a = "";
		
		do 
		{
			System.out.println(msg);
			try 
			{
				a = br.readLine();
			}
			
			catch(IOException io) { System.out.println(io.getMessage()); }
			
			if(a.length()<3)
				System.out.println("Invalido! Introduza novamente!");
			
		} while (a.length() < 3);
		
		return a;
	}
	
	public int validarInt(String msg) 
	{
		int a = 0;
		
		do 
		{
			System.out.println(msg);
			try 
			{
				a = Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException ne) { System.out.println(ne.getMessage()); }
			catch(IOException io) { System.out.println(io.getMessage()); }
			
			if(a < 0)
				System.out.println("Invalido! Introduza novamente!");
			
		} while (a < 0);
		
		return a;
	}
}
