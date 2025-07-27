import java.text.DecimalFormat;
import java.util.*;

public class Viz 
{
	private DecimalFormat m;
	Viz()
	{
		m=new DecimalFormat("###,###,###,###.00 Mts");
	}
	void change(int p,ArrayList a,int q)
	{
		Aereo pai=(Aereo)a.get(q);
		if(p==-1)
			System.out.println("O code nao existe !");
		else
		{
			pai.setqtyM(q);
			System.out.println("A quantidade de milha tracada com sucesso !!\nE a nova Qty: "+q);
		}
	}
	void remove(int p,ArrayList a)
	{
		if(p==-1)
			System.out.println("Nao exite code !");
		else
		{
			
			Bilhete pai;
			
			pai=(Bilhete)a.get(p);
			a.remove(p);
			a.trimToSize();
			System.out.println("O obj removido com S !");
			
			if(pai instanceof Terrestre)
			{
				pai=(Terrestre)pai;
				Terrestre.ctT--;
			}
			else
			{
				if(pai instanceof Aereo)
				{
					pai=(Aereo)pai;
					Aereo.ctA--;
				}
				else
				{
					if(pai instanceof Mar)
					{
						pai=(Mar)pai;
						Mar.ctM--;
					}
				}
			}
			
		}
	}
	void vizM(int m)
	{
		System.out.println("O que tem maior numero de voo e: "+m);
	}
	void pqC(int p,ArrayList <Bilhete>a)
	{
		Bilhete pai;
		pai=a.get(p);
		if(p==-1)
			System.out.println("Nao exite code !");
		else
			System.out.println("O bilhete procurado: \n"+pai);
	}
	void vizac(float a)
	{
		System.out.println("O valor do total de bilhete sao de: "+m.format(a));
	}
	String bilhete(ArrayList a)
	{
		String s="";
		
		Bilhete pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Bilhete)a.get(i);
			s+=pai+"\n";
		}
		
		return s;
	}
}
