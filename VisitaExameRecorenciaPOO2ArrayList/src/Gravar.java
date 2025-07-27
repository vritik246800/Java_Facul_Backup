import java.io.*;

public class Gravar 
{
	public Gravar()
	{
		
	}
	public void gravarct(int a,int b,int c)
	{
		try
		{
			FileWriter fw=new FileWriter("Contador tipo.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write("A quantidade de cada tipo de Actividade sao: ");
			bw.newLine();
			bw.write("Game Drive: "+a);
			bw.newLine();
			bw.write("Bush Braai: "+b);
			bw.newLine();
			bw.write("Cycling: "+c);
			bw.newLine();
			bw.close();
			
		}
		catch(NumberFormatException z)
		{
			System.out.println(z.getMessage());
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
	}
	
}
