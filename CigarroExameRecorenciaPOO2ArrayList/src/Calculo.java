import java.util.ArrayList;

public class Calculo 
{
	public Calculo()
	{
		
	}
	public int ctQ(ArrayList array,String a)
	{
		int  ctQ=0;
		Cigarro ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Cigarro) array.get(i);
			
			if(ax.getsabor().contains(a))
				ctQ++;
		}
		return ctQ;
	}
	public float ac(ArrayList array,String a)
	{
		float ac=0;
		Cigarro ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Cigarro) array.get(i);
			
			if(ax.gettipo().equalsIgnoreCase(a))
				ac+=ax.getvp();
		}
		return ac;
	}
	public float acg(ArrayList array)
	{
		float a=0;
		Cigarro ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Cigarro) array.get(i);
			
			a+=ax.getvp();
		}
		return a;
	}
	
}
