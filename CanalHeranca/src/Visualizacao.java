import java.util.*;

public class Visualizacao 
{
	public Visualizacao()
	{
		
	}
	public String toString(ArrayList <Atracao> a)
	{
		String s="";
		
		for(int i=0;i<a.size();i++)
			s+=a.get(i)+"\n";
		return s;
	}
}
