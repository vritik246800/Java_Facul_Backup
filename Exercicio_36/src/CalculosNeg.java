
public class CalculosNeg 
{
	public CalculosNeg()
	{
		
	}
	public float ac(int ct,Negociante [] array)
	{
		int ac=0;
		for(int i=0;i<ct;i++)
			ac+=array[i].getVP();
		return ac;
	}
	public int contar(int ct,Negociante [] array,String tipo)
	{
		int contar=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipoO().equalsIgnoreCase(tipo))
				contar++;
		}
		return contar;
	}
	public float ac10(int ct,Negociante [] array)
	{
		float ac10=0;
		for(int i=0;i<ct;i++)
		{
			ac10+=array[i].getvalorC();
		}
		return ac10;
	}
}