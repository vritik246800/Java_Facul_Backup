import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class CriarFile 
{
	public CriarFile()
	{
		
	}
	public void criarFile(float a)
	{
		try
		{
			DecimalFormat m=new DecimalFormat("###,###,###.00 Mts");
			FileWriter fr=new FileWriter("NovoFile.txt");
			BufferedWriter bw=new BufferedWriter(fr);
			bw.write("|============================|");
			bw.newLine();
			bw.write("| O valor total sem Importo: |");
			bw.newLine();
			bw.write("|----------------------------|");
			bw.newLine();
			bw.write("| ( "+m.format(a)+" ) |");
			bw.newLine();
			bw.write("|============================|");
			bw.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("|===========================|");
		System.out.println("| File criado com sucesso!! |");
		System.out.println("|===========================|");
	}
}