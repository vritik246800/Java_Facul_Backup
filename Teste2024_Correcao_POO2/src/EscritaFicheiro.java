import java.io.*;

import javax.swing.JOptionPane;
public class EscritaFicheiro 
{
	public EscritaFicheiro() {}
	
	public void escreverQuantidadesTxt() 
	{
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Quantidades.txt"));
			bw.write("Quantidades Por Tipo - Comerciantes: "+AgenteComerciante.contC+
				" Vendedores:"+AgenteVendedor.contV+" Registos: "+AgenteRegisto.contR);
			bw.newLine();
			bw.close();
		}
		catch(IOException io) { JOptionPane.showMessageDialog(null, io.getMessage());}
	}
}
