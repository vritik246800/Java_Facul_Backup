public class Calculos
{
  public Calculos() {}
  
  public int contarParticularCentral(Factura [] array, int cont)
  {
	int c = 0;
	for(int i=0;i<cont;i++)
	{
		if(array[i].getTipo().equalsIgnoreCase("Particular") && array[i].getBairro().equalsIgnoreCase("Central"))
			c++;
	}
	return c;
  }
  
  public float valorTotal(Factura [] array, int cont)
  {
	float vt = 0;
	for(int i=0;i<cont;i++)
		vt += array[i].getValorTotal();
	
	return vt;
  }

  
  public float totalImpostos(Factura [] array, int cont)
  {
	float t = 0;
	for(int i = 0;i<cont;i++)
		t += array[i].getImposto();
	return t;
  }
}