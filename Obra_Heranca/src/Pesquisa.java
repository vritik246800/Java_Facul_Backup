import java.util.*;

public class Pesquisa 
{
	Pesquisa()
	{
		
	}
	int pesquisa(ArrayList a,String n)
	{
		Obra pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Obra)a.get(i);
			if(pai.getnomeEng().equalsIgnoreCase(n))
				return i;
		}
		
		return -1;
	}
	
}
