import java.util.*;


public class Calcular 
{
	public Calcular()
	{
		
	}
	public float acG(ArrayList a)
	{
		float ac=0;
		
		Conta pai;
		Corrente c;
		Salario s;
		Poupanca p;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Conta)a.get(i);
			if(pai instanceof Corrente)
			{
				c=(Corrente)pai;
				ac+=c.calculardespesafinal();
			}
			else
			{
				if(pai instanceof Poupanca)
				{
					p=(Poupanca)pai;
					ac+=p.calculardespesafinal();
				}
			}
		}
		
		return ac;
	}

}
