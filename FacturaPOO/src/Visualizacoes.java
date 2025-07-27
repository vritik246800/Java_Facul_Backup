import java.text.DecimalFormat;
public class Visualizacoes
{
  private DecimalFormat mt;
  
  public Visualizacoes()
  {
	mt = new DecimalFormat("###,###.00 MTS");
  }
  
  public void visPartCentral(int c)
  {
	System.out.println("Clientes particulares no bairro central:"+c);
  }
  
  public void visImpostos(float t)
  {
	System.out.println("Total de Impostos:"+mt.format(t));
  }
  
  public void visualizarObjecto(int i, Factura [] array)
  {
	if(i==-1)
      System.out.println("Objecto nao foi encontrado!");
	else
	  System.out.println(array[i]);
  }
  
  public String toString(Factura [] array, int cont)
  {
	String x = "";
	for(int i=0;i<cont;i++)
	{
	  x += array[i] + "\n";
	}
	return x;
  }
}