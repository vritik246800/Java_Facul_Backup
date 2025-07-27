import java.text.DecimalFormat;
import java.io.*;

public class CriarFile 
{
	private DecimalFormat m;
	public CriarFile()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public void criar(float ac)
	{
		try
		{
			FileWriter fr=new FileWriter("Fim.txt");
			BufferedWriter bw=new BufferedWriter(fr);
			
			bw.write("O valor total da mercadoria em meticais sao de : "+m.format(ac));
			bw.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println(z.getMessage());
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
	}
}
