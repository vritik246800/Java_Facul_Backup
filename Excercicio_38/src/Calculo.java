
public class Calculo 
{
	public Calculo()
	{
		
	}
	public float converter(float a)
	{
		return -a;
	}
	public int ct(int ct,Jogador [] array,String a)
	{
		int cont=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getdesp().equalsIgnoreCase(a))
				cont++;
		}
		return cont;
	}
	public float acP(int ct,Jogador [] array)
	{
		float a=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getv()>0)
				a+=array[i].getv();
		}
		return a;
	}
	public float acN(int ct,Jogador [] array)
	{
		float a=0;
		for(int i=0;i<ct;i++)
		{
			if(array[i].getv()<0)
				a+=array[i].getv();
		}
		return a;
	}
}