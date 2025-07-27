import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(String matricula,ArrayList array)
	{
		Barco pai;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Cruseiro && pai.getmatricula().equalsIgnoreCase(matricula))
				return i;
		}
		return -1;
	}
}
