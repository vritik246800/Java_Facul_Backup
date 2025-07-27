import java.util.*;

public class Calculos 
{
	public Calculos()
	{
		
	}
	public float calculo_margem(float valorTotal)
	{
		return valorTotal-1900000;
	}
	public float acumuladorAdoaneiro(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
			}
			else
			{
				if(pai instanceof Normal)
				{
					pai=(Normal)pai;
				}
				else
				{
					if(pai instanceof Revendedor)
					{
						pai=(Revendedor)pai;
					}
					else
					{
						if(pai instanceof Estado)
						{
							pai=(Estado)pai;
						}
					}
				}
			}
			acumulador+=pai.direitosAdoaneiro();
		}
		
		return acumulador;
	}
	public float acumuladorGeral(ArrayList a)
	{
		float acumulador=0;
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
			}
			else
			{
				if(pai instanceof Normal)
				{
					pai=(Normal)pai;
				}
				else
				{
					if(pai instanceof Revendedor)
					{
						pai=(Revendedor)pai;
					}
					else
					{
						if(pai instanceof Estado)
						{
							pai=(Estado)pai;
						}
					}
				}
			}
			acumulador+=pai.valorFinal();
		}
		return acumulador;
	}
}
