
public class Ordenar 
{
	public Ordenar()
	{
		
	}
	public void ordenar(int ct,Cliente [] array)
	{
		for(int i=0;i<ct;i++)
		{
			for(int j=0;j<ct-1;j++)
			{
				if(array[j].getCode()>array[j+1].getCode())
					troca(array,j,j+1);
			}
		}
	}
	public void troca(Cliente [] array,int code1,int code2)
	{
		Cliente aux=array[code1];
		array[code1]=array[code2];
		array[code2]=aux;
		
	}
}