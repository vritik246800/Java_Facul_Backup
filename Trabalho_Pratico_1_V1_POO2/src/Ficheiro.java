import java.io.*;
import java.util.*;

public class Ficheiro
{
	public Ficheiro()
	{
		
	}
	public ArrayList lerOBJ()
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
		System.out.println("|----------------------------------------|");
		System.out.println("| Fecheiro de Objecto lido com Sucesso ! |");
		System.out.println("|----------------------------------------|");
		return a;
	}
	public void escreverOBJ(ArrayList a)
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
		
		System.out.println("|--------------------------------------|");
		System.out.println("| File de Objecto criado com Sucesso ! |");
		System.out.println("|--------------------------------------|");
	}
}
