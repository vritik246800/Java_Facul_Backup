import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CriarO 
{
	public CriarO()
	{
		
	}
	public void gravarObj(Cliente [] array)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Reserva.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(array);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("|==========================================|");
		System.out.println("| Ficheiro de Objecto criado com SUCESSO ! |");
		System.out.println("|==========================================|");
	}
}
