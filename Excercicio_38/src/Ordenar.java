
public class Ordenar 
{
	public Ordenar()
	{
		
	}
	public void bb(int ct,Jogador [] array)
	{
		for(int i=0;i<ct;i++)
		{
			for(int j=0;j<ct-1;j++)
			{
				if(array[j].getv()>array[j+1].getv())
					trocar(array,j,j+1);
			}
		}
	}
	public void trocar(Jogador [] array,int j1,int j2)
	{
		Jogador aux=array[j1];
		array[j1]=array[j2];
		array[j2]=aux;
	}
}
