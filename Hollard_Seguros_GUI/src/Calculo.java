import java.util.*;

public class Calculo 
{
	
	public Calculo()
	{
		
	}
	public float acumulador(ArrayList a)
	{
		float v=0;
		Seguro pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Seguro)a.get(i);
			v+=pai.vf();
		}
		return v;
	}
}
