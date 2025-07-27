import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CriarFiletxt 
{
	public CriarFiletxt()
	{
		
	}
	public void criarTXT(int ct,Bebida [] array)
	{
		try
		{
			FileWriter fr=new FileWriter("NOVOFILE.txt");
			BufferedWriter bw=new BufferedWriter(fr);	
			for(int i=0;i<ct;i++)
			{
				if(array[i].gettipoB().equalsIgnoreCase("Cerveja"))
				{
					bw.write("A marca de cerveja :"+array[i].getmarca()+" E o valor a pagar: "+array[i].getvp());
					bw.newLine();
				}	
			}	
			bw.close();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("File de txt criador ! ");
	}
}
