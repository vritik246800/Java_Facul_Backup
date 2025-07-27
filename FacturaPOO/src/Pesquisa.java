public class Pesquisa
{
  public Pesquisa()
  {}
	
  public int pesquisa(int codigo, Factura [] array, int cont)
  {
	for(int i=0;i<cont;i++)
	{
      if(array[i].getCodigo()==codigo)
      {
    	return i;
      }
	}
	return -1;
  }
}