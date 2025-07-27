import java.text.DecimalFormat;
import java.io.*;

public class Escrever 
{
	private DecimalFormat m;
	
	public Escrever()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public void escrever(float a)
	{
		try
		{
			FileWriter fr=new FileWriter("Novo.txt");
			BufferedWriter bw=new BufferedWriter(fr);
			bw.write("O valor Total sao de: "+m.format(a));
			bw.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File criado com sucesso!");
	}
	
}
