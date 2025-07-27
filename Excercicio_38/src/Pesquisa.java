
public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(int ct,Jogador [] array,int code)
	{
		for(int i=0;i<ct;i++)
			if(array[i].getcode()==code)
				return i;
		return -1;
	}
}