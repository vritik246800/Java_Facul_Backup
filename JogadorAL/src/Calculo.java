import java.util.ArrayList;

public class Calculo 
{
	
	public Calculo()
	{
		
	}
	// podes fazer assim
	public int ct1(ArrayList <Jogador> array,String s)
	{
		int ct=0;
		
		for(int i=0;i<array.size();i++)
		{
			if(array.get(i).gettD().equalsIgnoreCase(s))
				ct++;
		}
		return ct;
	}
	// OU podes fazer assim
	public int ct(ArrayList array,String s)
	{
		int ct=0;
		Jogador ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax= (Jogador) array.get(i);
			if(ax.gettD().equalsIgnoreCase(s))
				ct++;
		}
		return ct;
	}
	public float acG(ArrayList array)
	{
		float ac=0;
		Jogador ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Jogador)array.get(i);
			if(ax.getv()>=0)
				ac+=ax.getvf();
		}
		return ac;
	}
	public float acP(ArrayList array)
	{
		float ac=0;
		Jogador ax;
		
		for(int i=0;i<array.size();i++)
		{
			ax=(Jogador)array.get(i);
			if(ax.getv()<0)
				ac+=ax.getvf();
		}
		return ac;
	}
	
}






