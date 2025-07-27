import java.util.*;

public class Calculo 
{
	public Calculo()
	{
		
	}
	public float acumulador(ArrayList a )
	{
		Bilhete pai;
		BilheteAereo aereo;
		float acum=0;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai instanceof BilheteAereo)
			{
				aereo=(BilheteAereo)pai;
				acum+=aereo.vaF();
			}
		}
		return acum;
	}

}
