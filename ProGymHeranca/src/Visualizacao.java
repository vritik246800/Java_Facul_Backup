import java.util.*;
import java.text.DecimalFormat;

public class Visualizacao 
{
	private DecimalFormat m;
	public Visualizacao()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		
	}
	public void total(float vf)
	{
		System.out.println("O valor total ganho pela ProGym sao de: "+m.format(vf));
	}
	public void remove(ArrayList a,int poz)
	{
		if(poz==-1)
			System.out.println("O contacto e invalido !");
		else
		{
			a.remove(poz);
			a.trimToSize();
			Estudante.ctEstudante--;
			
			System.out.println("Cliente removido com sucesso !");
		}
	}
	public String toString(ArrayList a)
	{
		String s="";
		ProGym pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			s+=pai+"\n";
		}
		return s;
	}
	public String listEstudante(ArrayList a)
	{
		String s="";
		ProGym pai;
		Estudante e;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			if(pai instanceof Estudante)
			{
				e=(Estudante)pai;
				s+=e.toString();
			}
		}
		
		return s;
	}
	public String listFamilia(ArrayList a)
	{
		String s="";
		ProGym pai;
		Familia f;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(ProGym)a.get(i);
			if(pai instanceof Familia)
			{
				f=(Familia)pai;
				s+=f.toString();
			}
		}
		return s;
	}
}
