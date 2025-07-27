import java.text.DecimalFormat;

public class Viz 
{
	private DecimalFormat m;
	public Viz()
	{
		m=new DecimalFormat ("###,###,###.00 Mts");
	}
	public String toString(int ct,Visita [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
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
	public void ACG(Visita [] array,int aux,float g,float b,float c)
	{
		if(aux==-1)
			System.out.println("O tipo de actividade nao existe !!");
		else
		{
			if(array[aux].gettA().equalsIgnoreCase("Game Drive"))
				System.out.println("O valor total de Game Drive sao: "+m.format(g));
			
			if(array[aux].gettA().equalsIgnoreCase("Bush Braai"))
				System.out.println("O valor total de Bush Braai sao: "+m.format(b));
			
			if(array[aux].gettA().equalsIgnoreCase("Cycling"))
				System.out.println("O valor total de Cycling sao: "+m.format(c));
		}
	}
	
}
