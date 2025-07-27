import java.util.ArrayList;
import java.text.DecimalFormat;


public class Viz 
{
	private DecimalFormat m;
	
	public Viz()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		
	}
	public String toString(ArrayList array)
	{
		String s="";
		for(int i=0;i<array.size();i++)
			s+=array.get(i)+"\n";
		return s;
	}
	public void vizct(int f,int t,int c)
	{
		System.out.println("A quantidade de jogadores que apostam em cada desporto sao de:");
		System.out.println("Futebol: "+f+"\nTenis: "+t+"\nCavalos: "+c);
	}
	public void acGP(float g,float p)
	{
		System.out.println("O valor total sao de: ");
		System.out.println("Perdido: "+m.format(g)+"\nGanho: "+m.format(p));
	}
	public void ac(float ac)
	{
		if(ac>0)
			System.out.println("A casa de Aposta esta em Lucro !\nCom valor de :"+m.format(ac));
		else
			System.out.println("A case de Aposta esta em Prejuiso!\nCom valor de :\"+m.format(ac)");
	}
}
