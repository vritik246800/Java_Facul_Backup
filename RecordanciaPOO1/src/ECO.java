import java.io.*;

public class ECO 
{
	public ECO()
	{
		
	}
	public void EO(Cigarro [] array)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Cigaro.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			
			oo.writeObject(array);
			oo.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("File de Obj Criado com successo !!");
	}
}
