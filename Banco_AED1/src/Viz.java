
public class Viz 
{
	public Viz()
	{
		
	}
	public String toString(int ct,Cliente [] array)
	{
		String s="";
		
		for(int i=0;i<ct;i++)
		{
			s+=array[i]+"\n";
		}
		return s;
	}
	public void vizPEQ(Cliente [] array,int p)
	{
		if(p==-1)
			System.out.println("O numero de conta nao existe !");
		else
			System.out.println(array[p]);
	}
}
