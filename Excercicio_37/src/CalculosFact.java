public class CalculosFact 
{
	public CalculosFact()
	{
		
	}
	public float acSI(int ct, Factura [] array)
	{
		float ac=0;
		for(int i=0;i<ct;i++)
			ac+=array[i].getv();
		return ac;
	}
	public int ctP(int ct,Factura [] array)
	{
		int ctP=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getbairro().equalsIgnoreCase("Central") && array[i].gettipoC().equalsIgnoreCase("Particular"))
				ctP++;
		}
		return ctP;
	}
	public float acCI(int ct,Factura [] array)
	{
		float ac=0;
		for(int i=0;i<ct;i++)
			ac+=array[i].getv5_15();
		return ac;
	}
}