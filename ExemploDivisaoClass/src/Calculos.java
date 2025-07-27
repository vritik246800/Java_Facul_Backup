public class Calculos
{
  public Calculos() {}
  
  public int calcularTotal(int cont, Prisioneiro [] array)
  {
	int total = 0;
	
	for(int i=0;i<cont;i++)
	  total += array[i].getValorFinal();
  
    return total;
  }
  
  public int contar(int cont, Prisioneiro [] array)
  {
	int c = 0;
    int anoNascimento, idade;

    for(int i=0;i<cont;i++)
	{
   	  anoNascimento = Integer.parseInt(array[i].getDataNascimento().substring(6,10));
	  idade = 2024 - anoNascimento;
		
	  if(idade>50)
			c++;
	}
	return c;
  }  
}
