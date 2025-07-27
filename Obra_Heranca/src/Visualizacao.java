import java.util.*;
import java.text.DecimalFormat;

class Visualizacao 
{
	private DecimalFormat m;
	
	Visualizacao()
	{
		m=new DecimalFormat("###,###,###,###. 00Mts");
	}
	void ac(float a)
	{
		System.out.println("O valor total: "+m.format(a));
	}
	void viznome(int i,ArrayList a)
	{
		if(i==-1)
			System.out.println("Nome do Enginheiro nao existe !!");
		else
		{
			a.remove(i);
			a.trimToSize();
			System.out.println("Enginheiro removido com sucesso !!");
		}
	}
}
