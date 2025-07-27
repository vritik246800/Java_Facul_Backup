import java.util.*;

public class Calculo 
{
	public Calculo()
	{
		
	}
	public float media(ArrayList a)
	{
		float media,dur=0;
		Atracao pai;
		Programa prog;
		Informativo inf;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Atracao)a.get(i);
			if(pai instanceof Informativo)
			{
				inf=(Informativo)pai;
				if(pai instanceof Programa)
				{
					prog=(Programa)pai;
					dur=prog.getduracao();
				}
				//dur=pai.getduracao();
			}
		}
		media=dur/a.size();
		return media;
	}
}
