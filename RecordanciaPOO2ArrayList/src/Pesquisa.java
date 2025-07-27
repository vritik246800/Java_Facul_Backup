import java.util.ArrayList;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(ArrayList array,String s)
	{
		Cigarro ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Cigarro)array.get(i);
			
			if(ax.getmarca().equalsIgnoreCase(s))
				return i;
		}
		return -1;
	}
}
