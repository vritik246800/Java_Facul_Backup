
public class Calculo 
{
	public Calculo()
	{
		
	}
	public float acG(int ct,Cliente [] array)
	{
		float ac=0;
		for(int i=0;i<ct;i++)
		{
			ac+=array[i].getVp();
		}
		return ac;
	}
	public float acD(int ct,Cliente [] array)
	{
		float a=0;
		for(int i=0;i<ct;i++)
		{
			a+=array[i].getD();
		}
		return a;
	}
	public int ct(int ct,Cliente [] array,String m)
	{
		int n=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getTipoC().equalsIgnoreCase(m))
				n++;
		}
		return n;
	}
}
