import java.util.*;

public class Pesquisa 
{
	public Pesquisa()
	{
		
	}
	public int pesquisa(ArrayList a,int code,String nome)
	{
		Cliente pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai.getnomeCliente().equalsIgnoreCase(nome) && pai.getcodeViatura()==code)
				return i;
		}
		return -1;		
	}

}
