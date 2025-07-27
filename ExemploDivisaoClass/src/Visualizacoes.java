import java.text.DecimalFormat;
public class Visualizacoes
{
  private DecimalFormat mt;
  
  public Visualizacoes() 
  {
	mt = new DecimalFormat("###,###.00 MTS");
  }
  
  public void visualizarTotal(int t)
  {
	System.out.println("Valor total recebido:"+mt.format(t));
  }
  
  public String toString(int cont, Prisioneiro [] array)
  {
	String s = " ";
	for(int i=0;i<cont;i++)
	  s += array[i]+"\n"; //toString	
    
	return s;
  }
}