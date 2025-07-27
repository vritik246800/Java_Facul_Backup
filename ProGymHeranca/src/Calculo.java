import java.util.*;

public class Calculo 
{
	public Calculo()
	{
		
	}
	public float acF(ArrayList a)
	{
		ProGym pai;
		Familia f;
		int acf=0;
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			if(pai instanceof Familia)
			{
				f=(Familia)pai;
				acf+=f.getvpf();
			}
		}
		return acf;
	}
	public float acE(ArrayList a)
	{
		ProGym pai;
		Estudante e;
		int acf=0;
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			if(pai instanceof Familia)
			{
				e=(Estudante)pai;
				acf+=e.getvpe();
			}
		}
		return acf;
	}
	public float vpE(ArrayList a)
	{
		float ace=0;
		ProGym pai;
		Estudante e;
	
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			if(pai instanceof Estudante)
			{
				e=(Estudante)pai;
				ace+=e.getvpe();
			}
		}
		
		return ace;
	}
}
