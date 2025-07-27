import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(ArrayList a,String nomeBarco)
	{
		Bilhete pai;
		BilheteBarco barco;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai instanceof BilheteBarco)
			{
				barco=(BilheteBarco)pai;
				if(barco.getnome().equalsIgnoreCase(nomeBarco))
					return i;
			}
		}
		
		return -1;
	}
	public int pesquisamatricula(ArrayList a)
	{
		int poz=-1,menoano=9999999;
		Bilhete pai;
		BilheteCarro carro;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai instanceof BilheteCarro)
			{
				carro=(BilheteCarro)pai;
				if(carro.getanoFabrico()<menoano)
				{
					menoano=carro.getanoFabrico();
					poz=i;
				}
			}
		}
		
		return poz;
	}

}
