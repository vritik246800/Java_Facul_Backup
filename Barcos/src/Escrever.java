import java.io.*;
import java.util.*;

public class Escrever 
{
	public Escrever()
	{
		
	}
	public void alterarF(ArrayList array,int pessoa,int poz)
	{
		Barco pai;
		Pesca pesq;
		Carga carga;
		Cruseiro cruz;
		
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter("Dados.txt"));
			BufferedReader br=new BufferedReader(new FileReader("Dados.txt"));
			String linha=br.readLine();
			
			for(int i=0;i<array.size();i++)
			{
				pai=(Barco)array.get(i);
				if(pai instanceof Cruseiro)
				{
					if(poz==i)
					{	
						bw.write(pai.getmatricula()+";"+pai.getmarca()+";"+pai.getpeso()+";"+"R"+";"+pessoa);
						bw.newLine();
					}
					else
					{
						if(pai instanceof Pesca)
						{
							pesq=(Pesca)pai;
							bw.write(pai.getmatricula()+";"+pai.getmarca()+";"+pai.getpeso()+";"+"P"+";"+pesq.getqtyMarico()+";"+pesq.getnPescador());
							bw.newLine();
						}
						else
						{
							if(pai instanceof Carga)
							{
								carga=(Carga)pai;
								bw.write(pai.getmatricula()+";"+pai.getmarca()+";"+pai.getpeso()+";"+"C"+";"+carga.getnContetor());
								bw.newLine();
							}
						}
					}
				}
			}
			br.close();
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
