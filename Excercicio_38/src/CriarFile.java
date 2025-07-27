import java.text.DecimalFormat;
import java.io.*;

public class CriarFile 
{
	private DecimalFormat m;
	public CriarFile()
	{
		m=new DecimalFormat("###,###.00 Mts");
	}
	public void escrever(int ct,Jogador [] array)
	{
		try
		{	
			FileWriter fw=new FileWriter("Novo.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write("[------------------------------------------]");
			bw.newLine();
			for(int i=0;i<ct;i++)
			{
				if(array[i].getv()>0)
				{
					bw.write("[ Code: "+array[i].getcode()+"| Valor de Imposto: "+m.format(array[i].geti())+" ]");
					bw.newLine();
					bw.write("[------------------------------------------]");
					bw.newLine();
				}
			}
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
		System.out.println("File criado com Sucesso !-_-! ");
	}
}