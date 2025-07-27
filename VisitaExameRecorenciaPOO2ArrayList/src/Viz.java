import java.text.DecimalFormat;
import java.util.ArrayList;

public class Viz 
{
	private DecimalFormat m;
	public Viz()
	{
		m=new DecimalFormat ("###,###,###.00 Mts");
	}
	public String toString(ArrayList array)
	{
		String s="";
		for(int i=0;i<array.size();i++)
			s+=array.get(i)+"\n";
		return s;
	}
	public void cTD(int c)
	{
		System.out.println("A quantidade de visitas dentro da epoca das Ferias sao de: "+c);
	}
	public void ACD(float v)
	{
		System.out.println("O valor total de Desconto sao de : "+m.format(v));
	}
	public void ACG(ArrayList array,int poz,float g,float b,float c)
	{
		Visita ax;
		ax=(Visita) array.get(poz);
		if(poz==-1)
			System.out.println("O tipo de actividade nao existe !!");
		else
		{
			if(ax.gettA().equalsIgnoreCase("Game Drive"))
				System.out.println("O valor total de Game Drive sao: "+m.format(g));
			
			if(ax.gettA().equalsIgnoreCase("Bush Braai"))
				System.out.println("O valor total de Bush Braai sao: "+m.format(b));
			
			if(ax.gettA().equalsIgnoreCase("Cycling"))
				System.out.println("O valor total de Cycling sao: "+m.format(c));
		}
	}
	
}
