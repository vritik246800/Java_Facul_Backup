import java.util.*;

public class Ordenar 
{
	public Ordenar()
	{
		
	}
	public void selectionSort(ArrayList a) 
	{
        for(int i=0;i<a.size()-1;i++) 
        {
            int menor;
            
            menor=index(a,i);
            troca(a,i,menor);
        }
	}
    private int index(ArrayList a,int i)
    {
        int menor=i;
        ProGym pai,pai1;
        
        for(int j=i+1;j<a.size();j++) 
        {
        	pai=(ProGym)a.get(i);
        	pai1=(ProGym)a.get(j);
        	
            if(pai.getpeso()<pai1.getpeso()) 
            {
            	menor=j;
            }
        }
        return menor;
    }
    private void troca(ArrayList a,int i,int j) 
    {
        ProGym pai,pai1;
        
        pai=(ProGym)a.get(i);
        pai1=(ProGym)a.get(j);
        
        a.set(i,pai1);
        a.set(j,pai);
    }
}
