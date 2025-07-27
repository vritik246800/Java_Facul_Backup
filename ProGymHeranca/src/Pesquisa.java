import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(ArrayList<ProGym> a,String contacto)
	{
		ProGym pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=/*(ProGym)*/a.get(i);
			if(contacto.equals(pai.getcontacto()))
				return i;
		}
		return -1;
	}
}
