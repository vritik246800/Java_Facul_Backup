
public class Calculo 
{
	public Calculo()
	{
		
	}
	public float soma(int poz,Cliente [] array,float valor)
	{
		float soma=0;
		
		if(poz==-1)
			System.out.println("O numero de conta nao existe !");
		else
			soma=array[poz].getvalorD()+valor;
		
		return soma;
	}
}
