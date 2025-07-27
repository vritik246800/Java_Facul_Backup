import java.text.DecimalFormat;
import java.util.ArrayList;

public class Visualizacao 
{
	private DecimalFormat m;
	public Visualizacao()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public void vixC(int c)
	{
		System.out.println("A quantidade total de cigarro cuja sabor menta sao: "+c);
	}
	public String toString(ArrayList array)
	{
		String s="";
		Cigarro ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Cigarro)array.get(i);
			s+=ax+"\n";
			/*
			 * s+=array.get(i)+"\n";
			*/
		}
		return s;
	}
	public void ac(float a,float b)
	{
		System.out.println("O valor total de cada Cigarro sao: \nRecarregavel: "+m.format(a)+"\nDescartaveis: "+m.format(b));
	}
	public void vizpesq(ArrayList array, int p)
	{
		if(p == -1)
			System.out.println("A marca nao existe !");
		else
			System.out.println(array.get(p));
	}
}
