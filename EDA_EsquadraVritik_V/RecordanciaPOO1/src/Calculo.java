
public class Calculo 
{
	public Calculo()
	{
		
	}
	public int ctQ(int ct,Cigarro [] array,String a)
	{
		int  ctQ=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getsabor().contains(a))
				ctQ++;
		}
		return ctQ;
	}
	public float ac(int ct,Cigarro [] array,String a)
	{
		float ac=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipo().equalsIgnoreCase(a))
				ac+=array[i].getvp();
		}
		return ac;
	}
	public float acg(int ct,Cigarro[]array)
	{
		float a=0;
		for(int i=0;i<ct;i++)
		{
			a+=array[i].getvp();
		}
		return a;
	}
	
}
