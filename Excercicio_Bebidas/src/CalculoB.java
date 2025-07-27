
public class CalculoB 
{
	public CalculoB()
	{
		
	}
	public float acD(int ct,Bebida [] array)
	{
		float ac=0;
		for(int i=0;i<ct;i++)
		{
			ac+=array[i].getd();
		}
		return ac;
	}
	public int ctB(int ct,Bebida [] array,String s)
	{
		int ctw=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipoB().equalsIgnoreCase(s))
				ctw++;
		}
		return ctw;
	}
}