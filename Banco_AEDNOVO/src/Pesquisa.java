
public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(int ct,Cliente [] array,int numeroC)
	{
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].getnumeroC()==numeroC)
				return i;
		}
		
		return -1;
	}
}
