import java.util.*;
import java.io.*;

public class CriarFO 
{
	public CriarFO()
	{
		
	}
	public void saveO(ArrayList a)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Canal.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(a);
			oo.close();
			
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de Obj criado com sucesso !");
	}
}
