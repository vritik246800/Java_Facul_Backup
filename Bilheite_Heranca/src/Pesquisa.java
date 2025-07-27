import java.util.*;

public class Pesquisa 
{
	Pesquisa()
	{
		
	}
	int pqC(ArrayList a,int code)
	{
		Bilhete pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai.getcode()==code)
				return i;
		}
		return -1;
	}
	int verM(ArrayList a)
	{
		int maior=0,poz;
		Bilhete pai;
		Aereo ae;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai instanceof Aereo)
			{
				ae=(Aereo)pai;
				if(ae.getqtyM()>maior)
				{
					maior=ae.getqtyM();
					poz=i;
				}
			}
			
		}
		return maior;
	}
	
}
