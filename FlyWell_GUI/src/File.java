import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class File 
{
	private DecimalFormat m;
	
	public File()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public void write(float acum)
	{
		try
		{
			FileWriter fr=new FileWriter("Acumulador.txt");
			BufferedWriter br=new BufferedWriter(fr);
			
			br.write("O valor dos bilhetes que viajaram pela TAP sao: "+m.format(acum));
			br.close();
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, io.getMessage());
		}
	}

}
