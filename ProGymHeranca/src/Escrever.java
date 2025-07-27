import java.util.*;
import java.io.*;

public class Escrever 
{
	public Escrever()
	{
		
	}
	public void escreverO(ArrayList a)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("ProGym.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(a);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de Objecto criado com sucesso !");
	}
}
