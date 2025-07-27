import java.util.*;

public class Visualizacao 
{
	public Visualizacao()
	{
		
	}
	public void vizct(String msg1,int ct1,String msg2,int ct2,String msg3,int ct3)
	{
		System.out.println(msg1+ct1+msg2+ct2+msg3+ct3);
	}
	public void vizVP(String msg1,String ct1,String msg2,String ct2,String msg3,String ct3)
	{
		System.out.println(msg1+ct1+msg2+ct2+msg3+ct3);
	}
	public String arraypesca(ArrayList array)
	{
		String p="";
		
		Barco pai;
		Pesca pesc;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Pesca)
			{
				pesc=(Pesca)pai;
				p+=pesc+"\n";
			}
		}
		return p;
	}
	public String arraycarga(ArrayList array)
	{
		String c="";
		
		Barco pai;
		Carga crg;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Carga)
			{
				crg=(Carga)pai;
				c+=crg+"\n";
			}
		}
		return c;
	}
	public String arraycruz(ArrayList array)
	{
		String s="";
		
		Barco pai;
		Cruseiro cruz;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(Barco)array.get(i);
			if(pai instanceof Cruseiro)
			{
				cruz=(Cruseiro)pai;
				s+=cruz+"\n";
			}
		}
		return s;
	}
}
