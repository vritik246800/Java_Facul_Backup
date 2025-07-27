import java.io.*;

public class Escrever_LerOBJ 
{
	public Escrever_LerOBJ()
	{
		
	}
	public void escreverO(Cliente [] array)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Cliente.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(array);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("|===========================================|");
		System.out.println("|O ficheiro de objecto criado com successo !|");
		System.out.println("|===========================================|\n");
	}
	public void lerO(Cliente [] array)
	{
		try
		{
			FileInputStream fi=new FileInputStream("Cliente.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			array=(Cliente[])oi.readObject();
			oi.close();
		}
		catch(FileNotFoundException x)
		{
			System.out.println("Ficheiro de Objecto nao encontrado !");
		}
		catch(ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
	}
}
