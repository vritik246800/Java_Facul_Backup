import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;

public class EscreverFile 
{
	public EscreverFile()
	{
		
	}
	// ler
	
	public ArrayList lerO()
	{
		ArrayList array=null;
		try
		{
			FileInputStream fi=new FileInputStream("Jogador.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			
			array=(ArrayList)oi.readObject();
			
		}
		catch(ClassNotFoundException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de OBJ lido com successo !");
		return array;
		
	}
	public void escreverO(ArrayList array)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Jogador.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(array);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de OBJ criado com sucesso !");
	}
	public void ac10(ArrayList array)
	{
		DecimalFormat m=new DecimalFormat("###,###,###.00 Mts");
		
		Jogador ax;
		
			
			try
			{
				FileWriter fr=new FileWriter("Ganho.txt");
				BufferedWriter bw=new BufferedWriter(fr);
				for(int i=0;i<array.size();i++)
				{
					ax=(Jogador)array.get(i);
					if(ax.getv()>0)
					{
						bw.write("Code: "+ax.getcode()+" Valor do estado: "+m.format(ax.getvi()));
						bw.newLine();
					}
						
				}
				bw.close();
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		
		System.out.println("O valor total para Estado grava com sucesso !");
	}
}
