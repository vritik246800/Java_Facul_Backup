import java.io.*;

public class EscreverLerO 
{
	public EscreverLerO()
	{
		
	}
	public void gravarO(Jogador [] array)
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
		System.out.println("Ficheiro de objecto criado com sucesso !");
	}
	public void ler(Jogador [] array)
	{
		try
		{
			FileInputStream fi=new FileInputStream("Jogador.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			array=(Jogador[]) oi.readObject();
			oi.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("Ficheiro de objecto nao encontra !");
		}
		catch(ClassNotFoundException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("Ficheido de objecto lido com sucesso !");
	}
}
