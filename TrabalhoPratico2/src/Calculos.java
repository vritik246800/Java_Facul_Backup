
public class Calculos 
{
	public Calculos()
	{
		
	}
	public int contadorDFeriado(int ct,Reserva [] array)
	{
		int ctF=0,entrada,saida;
		for(int i=0;i<ct;i++)
		{
			entrada=Integer.parseInt(array[i].getdataE().substring(8,10));
			saida=Integer.parseInt(array[i].getdataS().substring(8,10));
			for(int j=entrada; j<saida;j++)
			{
				if(j==7 || j==25)
					ctF++;
			}
		}
		return ctF;
	}
	public int vizQT(int a,int b,int c)
	{
		return a+b+c;
	}
	public int vizQE(int ct,Reserva [] array,String t)
	{
		int ctE=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipoR().equalsIgnoreCase(t))
				//ctE+=array[i].getqtyC();
				ctE++;
		}
		return ctE;
	}
	public int acEmUSD(int ct, Reserva [] array,String t)
	{
		int n=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipoR().equalsIgnoreCase(t))
			{
				n+=array[i].getvpU();
				break;
			}	
		}
		return n;
	}
	public int acEmMTS(int ct, Reserva [] array,String t)
	{
		int n=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].gettipoR().equalsIgnoreCase(t))
			{
				n+=array[i].getvpM();
				break;
			}	
		}
		return n;
	}
}