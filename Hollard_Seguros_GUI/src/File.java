import java.io.*;
import java.util.*;
import javax.swing.*;

public class File extends JFrame
{
	
	public File()
	{
		
	}
	public void writeObj(ArrayList a)
	{
		try
		{
			FileOutputStream fo=new FileOutputStream("Seguro.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			
			oo.writeObject(a);
			oo.close();
			JOptionPane.showMessageDialog(null,"| File.dat criado com sucesso |");
			
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, io.getMessage());
		}
	}
}
