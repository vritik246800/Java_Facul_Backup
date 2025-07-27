import java.io.*;
public class EscreverFicheiro
{
  public EscreverFicheiro() 
  { }
  
  public void escreverFicheiro(int c)
  {
	try
	{
      FileWriter fw = new FileWriter("NovoFicheiro.txt");
	  BufferedWriter bw = new BufferedWriter(fw);
	  
	  bw.write("Numero total de prisioneiros com direito a servico comunitario:"+c);
	  System.out.println("Ficheiro criado com sucesso!");
	  bw.close();
	}
	catch(IOException e)
	{
	  System.out.println(e.getMessage());
	}
  }
}