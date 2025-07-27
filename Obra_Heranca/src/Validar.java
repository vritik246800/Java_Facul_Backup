import java.io.*;
import java.util.*;

public class Validar 
{
	private BufferedReader br;
	
	Validar()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		
	}
	String validarString(ArrayList a)
	{
		String s="";
		
		try
		{
			do
			{
				System.out.println("Introduz o nome do Enginhero(c>2)");
				s=br.readLine();
				if(s.length()<2)
					System.out.println("ERRO!!");
			}while(s.length()<2);
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		return s;
	}



}
