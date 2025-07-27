import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisaNumeroA(ArrayList a,int numeroA)
	{
		Seguro pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Seguro)a.get(i);
			if(pai.getnumeroA()==numeroA)
				return i;
		}
		return -1;
	}

}
