import java.text.DecimalFormat;
import java.io.*;
public class CriarFile 
{
	private DecimalFormat m;
	
	public CriarFile()
	{
		m=new DecimalFormat("###,###.00 Mts");
	}
	public void criarFile(float ac10)
	{
		try
		{
			FileWriter fr=new FileWriter("FileCriado.txt");
			BufferedWriter br=new BufferedWriter(fr);
			br.write("O valor total de comissoes sao: "+m.format(ac10));
			br.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File Criado com Sucesso!!");
	}
}