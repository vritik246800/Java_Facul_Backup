
public class Ordenar 
{
	public Ordenar()
	{
		
	}
	public void ordenar(int ct,Reserva [] array)
	{
		int dia1,dia2;
		for(int i=0;i<ct;i++)
		{
			for(int j=0;j<ct-1;j++)
			{
				dia1=Integer.parseInt(array[j].getdataS().substring(8,10));
				dia2=Integer.parseInt(array[j+1].getdataS().substring(8,10));
				if(dia2>dia1)
					troca(array,j,j+1);
			}
		}
	}
	public void troca(Reserva [] array,int dia1,int dia2)
	{
		Reserva aux=array[dia1];
		array[dia1]=array[dia2];
		array[dia2]=aux;
	}
}