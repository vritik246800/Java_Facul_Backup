import java.util.*;
import java.io.*;

public class File 
{
	File()
	{
		
	}
	void criarObj(ArrayList a)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Bilhete.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			
			oo.writeObject(a);
			oo.close();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("File de OBJ criado com S !!");
	}
	public ArrayList lerObj()
	{
		ArrayList a=null;
		
		try
		{
			FileInputStream fi=new FileInputStream("Bilhete.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			
			a=(ArrayList)oi.readObject();
			oi.close();
			
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de OBJ lido com S !!");
		return a;
	}
}
