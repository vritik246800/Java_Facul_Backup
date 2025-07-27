
public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(int ct,Cigarro [] array,String s)
	{
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].getmarca().equalsIgnoreCase(s))
				return i;
		}
		return -1;
	}
}
