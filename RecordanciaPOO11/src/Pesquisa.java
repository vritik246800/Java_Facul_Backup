
public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(int ct,Visita [] array,String a)
	{
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettA().equalsIgnoreCase(a))
				return i;
		}
		return -1;
		
	}
	
}
