import java.io.*;
public class CriarObj 
{
	public CriarObj()
	{
		
	}
	public void criarFObj(Bebida [] array)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Bebida.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(array);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de Objecto Criado com Sucesso ! ");
	}
	public void lerFObj(Bebida [] array)
	{
		try
		{
			FileInputStream fi=new FileInputStream("Bebida.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			array=(Bebida[]) oi.readObject();
			oi.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println(z.getMessage());
		}
		catch(ClassNotFoundException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("File de Obj lido com sucesso ! ");
	}
}