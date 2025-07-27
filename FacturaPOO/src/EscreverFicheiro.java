import java.io.*;

import java.text.DecimalFormat;
public class EscreverFicheiro
{
  private DecimalFormat mt;
  
  public EscreverFicheiro()
  {
	mt = new DecimalFormat("###,###.00 MTS");
  }
  
  public void escreverFicheiro(float vt)
  {
    try
	{
	  FileWriter fw = new FileWriter("NovoFicheiro.txt");
	  BufferedWriter bw = new BufferedWriter(fw);
	  
	  bw.write("Valor total sem impostos:"+mt.format(vt));
	  bw.close();
	  System.out.println("Ficheiro criado com sucesso!");
	}
	catch(IOException e)
	{
	  System.out.println(e.getMessage());
	}
  }
}