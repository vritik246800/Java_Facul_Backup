import java.io.*;
import java.util.*;

public class TodosPrisioneiros
{
  private Prisioneiro [] array;
  private int cont;
  private Visualizacoes vis;
  private Calculos cal;
  
  public TodosPrisioneiros()
  {
	array = new Prisioneiro[100];
	cont = 0;
	vis = new Visualizacoes();
	cal = new Calculos();
  }
  
  public void lerDoFicheiro()
  {
	String umaLinha, nome, motivo, duracao, dataNascimento;
	
	StringTokenizer umaCadeia;
	
	try
	{
      FileReader fr = new FileReader("Dados.txt");
	  BufferedReader br = new BufferedReader(fr);
	  
	  umaLinha = br.readLine();
	  
	  while(umaLinha!=null)
	  {
		umaCadeia = new StringTokenizer(umaLinha,";");
		nome = umaCadeia.nextToken();
		dataNascimento = umaCadeia.nextToken();
		duracao = umaCadeia.nextToken();
		motivo = umaCadeia.nextToken();
		
		array[cont] = new Prisioneiro(nome,dataNascimento,duracao,motivo);
		cont++;
	
	    umaLinha = br.readLine();
	  }
	  System.out.println("Ficheiro lido com sucesso!");
	  br.close();
	}
	catch(FileNotFoundException f)
	{
	  System.out.println("Ficheiro nao encontrado!");
	}
	catch(NumberFormatException n)
	{
	  System.out.println(n.getMessage());
	}
	catch(IOException e)
	{
	  System.out.println(e.getMessage());
	}
  }
  
  public String toString()
  {
	return vis.toString(cont,array);
  }
  
  public void adaptadorCalcularTotal()
  {
	int t;
	t = cal.calcularTotal(cont,array);
	vis.visualizarTotal(t);
  } 
  public void adaptadorEscrever()
  {
	EscreverFicheiro e = new EscreverFicheiro();
    int c;
    c = cal.contar(cont,array);
	e.escreverFicheiro(c);
  }
}