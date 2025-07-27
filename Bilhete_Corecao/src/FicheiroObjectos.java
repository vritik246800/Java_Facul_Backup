import java.io.*;
import java.util.*;

public class FicheiroObjectos 
{
	public FicheiroObjectos() {}
	
	public void lerFichObj(ArrayList bilhetes) 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("Bilhete.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			bilhetes = (ArrayList) ois.readObject();
			System.out.println("Ficheiro de objectos lido com sucesso!");
			ois.close();
		} 
		catch(FileNotFoundException f) { System.out.println("Ficheiro nao encontrado!"); }
		catch(ClassNotFoundException c) { System.out.println(c.getMessage());}
		catch(IOException io) { System.out.println(io.getMessage()); }
	}
	
	public void escreverFichObj(ArrayList bilhetes) 
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream("Bilhete.dat");
			ObjectOutputStream os = new ObjectOutputStream(fos);		
			os.writeObject(bilhetes);
			System.out.println("Ficheiro de objectos gravado com sucesso!");
			os.close();
		}
		catch(IOException io) { System.out.println(io.getMessage()); }
	}

}
