import java.util.*;

public class Calculo 
{
	public Calculo()
	{
		
	}
	public float ac(ArrayList a)
	{
		float ac=0;
		Obra pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Obra)a.get(i);
			if(pai instanceof Estrada)
			{
				pai=(Estrada)pai;
			}
			else
			{
				if(pai instanceof Predio)
				{
					pai=(Predio)pai;
				}
				else
				{
					if(pai instanceof Vivenda)
					{
						pai=(Vivenda)pai;
					}
				}
			}
			ac+=pai.vp();
		}
		
		return ac;
	}
}
