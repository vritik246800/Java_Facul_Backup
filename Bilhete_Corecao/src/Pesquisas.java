import java.util.*;

public class Pesquisas 
{
	public Pesquisas() {}
	
	public int pesquisarBilhetePorCodigo(ArrayList v, String c) 
	{
		Bilhete aux;
		
		for (int i = 0; i < v.size(); i++) 
		{
			aux = (Bilhete) v.get(i);
			if(aux.getCodigo().equalsIgnoreCase(c)) 
				return i;
		}
		return -1;
	}
	
	public int pesquisarBilheteAereoPorCodigo(ArrayList v, String c) 
	{
		Bilhete aux;
		Aereo a;
		for (int i = 0; i < v.size(); i++) 
		{
			aux = (Bilhete) v.get(i);
			if(aux instanceof Aereo) 
			{
				a = (Aereo) aux;
				if(aux.getCodigo().equalsIgnoreCase(c)) 
					return i;
			}
		}
		return -1;
	}
	
	public int pesquisarVooMaisLongo(ArrayList v) 
	{
		int indice = 0;
		int maior = 0;
		Bilhete b;
		Aereo a;
		for(int i = 0; i < v.size(); i++) 
		{
			b = (Bilhete) v.get(i);
			if(b instanceof Aereo) 
			{
				a = (Aereo) b;
				if(a.getQtdMilhas() > maior) 
				{
					maior = a.getQtdMilhas();
					indice = i;
				}
			}
		}		
		return indice;
	}
}
