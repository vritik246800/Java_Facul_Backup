
public class Cal 
{
	public Cal()
	{
		
	}
	public int calct(int ct,Visita [] array,String a)
	{
		int c=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettA().equalsIgnoreCase(a))
				c+=array[i].getqtyp();
		}
		return c;
	}
	//DD/MM/AAAA
	public int ctDez(int ct,Visita [] array)
	{
		int c=0,dia;
		
		for(int i=0;i<ct;i++)
		{
			dia=Integer.parseInt(array[i].getdatav().substring(0,2));
		  //if(dia>23 && dia<32)
			if(dia==24 || dia== 31)
				c++;
		}
		return c;
	}
	public float acd(int ct,Visita [] array)
	{
		float a=0;
		
		for(int i=0;i<ct;i++)
			a+=array[i].getd();
		
		return a;
	}
	public float acg(int ct,Visita [] array,String s)
	{
		float a=0;
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettA().equalsIgnoreCase(s))
				a+=array[i].getvp();
		}
		return a;
		
	}
	
}








