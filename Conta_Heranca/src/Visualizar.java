import java.text.DecimalFormat;
import java.util.*;

public class Visualizar 
{
	private DecimalFormat m;
	
	
	public Visualizar()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public void acG(float a)
	{
		System.out.println("O valor total sao de: "+m.format(a));
	}
	public void vC(ArrayList a)
	{
		Conta pai;
		String s="";
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Conta)a.get(i);
			if(pai instanceof Corrente)
			{
				pai=(Corrente)pai;
				s+=pai+"\n";
			}
		}
		System.out.println(s);
	}
	public void vP(ArrayList a)
	{
		Conta pai;
		String s="";
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Conta)a.get(i);
			if(pai instanceof Poupanca)
			{
				pai=(Poupanca)pai;
				s+=pai+"\n";
			}
		}
		System.out.println(s);
	}
	public void vS(ArrayList a)
	{
		Conta pai;
		String s="";
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Conta)a.get(i);
			if(pai instanceof Salario)
			{
				pai=(Salario)pai;
				s+=pai+"\n";
			}
		}
		System.out.println(s);
	}
}
