import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesq(ArrayList a)
	{
		Atracao pai;
		Novela nov;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Atracao)a.get(i);
			if(pai instanceof Novela)
			{
				nov=(Novela)pai;
				if(nov.gettitulo().equalsIgnoreCase("Chocolate_com_pimenta"))
					return i;
			}
		}
		return -1;
	}
}
