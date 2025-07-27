import java.util.ArrayList;

public class Cal 
{
	public Cal()
	{
		
	}
	public int calct(ArrayList array,String a)
	{
		int c=0;
		Visita ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Visita) array.get(i);
			
			if(ax.gettA().equalsIgnoreCase(a))
				c+=ax.getqtyp();
		}
		return c;
	}
	//DD/MM/AAAA
	public int ctDez(ArrayList array)
	{
		int c=0,dia;
		Visita ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Visita) array.get(i);
			dia=Integer.parseInt(ax.getdatav().substring(0,2));
			
		  //if(dia>23 && dia<32)
			if(dia==24 || dia== 31)
				c++;
		}
		return c;
	}
	public float acd(ArrayList array)
	{
		float a=0;
		Visita ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Visita) array.get(i);
			
			a+=ax.getd();
		}
		
		return a;
	}
	public float acg(ArrayList array,String s)
	{
		float a=0;
		Visita ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Visita)array.get(i);
			
			if(ax.gettA().equalsIgnoreCase(s))
				a+=ax.getvp();
		}
		return a;
		
	}
	
}








