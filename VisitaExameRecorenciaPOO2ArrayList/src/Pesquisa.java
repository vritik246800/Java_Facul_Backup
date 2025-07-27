import java.util.ArrayList;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(ArrayList array,String a)
	{
		Visita ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Visita)array.get(i);
			
			if(ax.gettA().equalsIgnoreCase(a))
				return i;
		}
		return -1;
		
	}
	
}
