import java.io.*;
import java.util.*;
public class TodasFacturas 
{
  private Factura [] array;
  private int cont;
  private Validacoes val;
  private Calculos cal;
  private Visualizacoes vis;
  
  public TodasFacturas(int n)
  {
	val = new Validacoes(); 
	array = new Factura[n];
	cont = 0;
	cal = new Calculos();
	vis = new Visualizacoes();
  }
  
  public void receberDados()
  {
	for(int i=0;i<array.length;i++)
	{
      System.out.println("Dados da:"+(i+1)+" factura:");
      array[cont] = new Factura();
      cont++;
	}
  }
  
  public String toString()
  {
	return vis.toString(array,cont);
  }
  
  public void adapTotImp()
  {
	float t = cal.totalImpostos(array,cont);
	vis.visImpostos(t);
  }
 
  public void adapPartiCentral()
  {
    int c = cal.contarParticularCentral(array,cont);
    vis.visPartCentral(c);
  }
  
  public void adapEscreverFicheiro()
  {
	EscreverFicheiro es = new EscreverFicheiro();
	
    float vt = cal.valorTotal(array,cont);
    es.escreverFicheiro(vt);
  }
  
  public void adapPesquisa()
  {
	int cod = val.validarInt(1011,2011,"Introduza o codigo(1011-2011) que pretende pesquisar: ");  
	Pesquisa p = new Pesquisa();
	int i = p.pesquisa(cod, array, cont);
	
	vis.visualizarObjecto(i,array);
  }  
}