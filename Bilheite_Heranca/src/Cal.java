import java.util.*;

public class Cal
{
	Cal()
	{
		
	}
	float ac(ArrayList a)
	{
		float v=0;
		Bilhete pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			if(pai instanceof Terrestre)
			{
				pai=(Terrestre)pai;
			}
			else
			{
				if(pai instanceof Aereo)
					pai=(Aereo)pai;
				else
					if(pai instanceof Mar)
						pai=(Mar)pai;
			}
			v+=pai.valor;
		}
		return v;
	}
}
