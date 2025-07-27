import java.util.*;
import java.text.DecimalFormat;

public class Visualizar 
{
	private DecimalFormat meticais;
	
	public Visualizar()
	{
		meticais=new DecimalFormat("###,###,###,###.00 Mts");
		
	}
	public void visualizar_MulherMocambicana(ArrayList a)
	{
		Cliente pai;
		String mes1,dia1,s="";
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			mes1=pai.getdataCompra().substring(0,2);
			dia1=pai.getdataCompra().substring(3,5);
			
			if(mes1.equalsIgnoreCase("04") && dia1.equalsIgnoreCase("07"))
				s+=pai.toString()+"\n";
		}
		System.out.println(s);
	}
	public void visualizar_Situacao(float valorTotal,float margem)
	{
		if(valorTotal>1900000)
		{
			System.out.println("|--------------------------------------|");
			System.out.println("| A empresa BeForward Mz esta em lucro |");
			System.out.println("|--------------------------------------|");
			 System.out.printf("| Com valor de: %-22s |\n",meticais.format(margem));
			System.out.println("|--------------------------------------|");
		}
		else
		{
			System.out.println("|-----------------------------------------|");
			System.out.println("| A empresa BeForward Mz esta em prejuiso |");
			System.out.println("|-----------------------------------------|");
			 System.out.printf("| Com valor de: %-25s |\n",meticais.format(margem));
			System.out.println("|-----------------------------------------|");
		}
	}
	public void visualizar_Pesquisa(int posicao,ArrayList a)
	{
		
		if(posicao==-1)
		{
			System.out.println("|---------------------------------------|");
			System.out.println("| O cliente nao existe na base de dados |");
			System.out.println("|---------------------------------------|");
		}
		else
		{
			Cliente pai;
			pai=(Cliente)a.get(posicao);
			System.out.println("|---------------------|");
			System.out.println("| O cliente a procuta |");
			System.out.println("|------------------------------------------------\\\\");
			System.out.println(pai);
			System.out.println("|------------------------------------------------//");
		}
	}
	public void visualizar_AcumuladorAdoaneiro(float valorAdoaneiro)
	{
		System.out.println("|------------------------------------------|");
		System.out.println("| O valor total pago em direitos adoaneiro |");
		System.out.println("|------------------------------------------|");
		 System.out.printf("| %-40s |\n",meticais.format(valorAdoaneiro));
		System.out.println("|------------------------------------------|");	
	}
	public void visualizar_AcumuladorGeral(float valorTotal)
	{
		System.out.println("|------------------------------------------|");
		System.out.println("| O valor total pago a pela BeForward Mz   |");
		System.out.println("|------------------------------------------|");
		 System.out.printf("| %-40s |\n",meticais.format(valorTotal));
		System.out.println("|------------------------------------------|");
	}
	public void visualizar_Doutorado(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|----------------------|");
		System.out.println("| Lista dos Doutorados |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Doutorado)
			{
				pai=(Doutorado)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.print(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Normal(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|-------------------|");
		System.out.println("| Lista dos Normais |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Normal)
			{
				pai=(Normal)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Revendedor(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|------------------------|");
		System.out.println("| Lista dos Revendedores |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Revendedor)
			{
				pai=(Revendedor)pai;
				s+=pai.toString()+"\n";
			}		
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_Estado(ArrayList a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|-------------------|");
		System.out.println("| Lista dos Estados |");
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai instanceof Estado)
			{
				pai=(Estado)pai;
				s+=pai.toString()+"\n";
			}	
		}
		System.out.println(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizarTClientes(ArrayList <Cliente> a)
	{
		Cliente pai;
		String s="";
		
		System.out.println("|------------------------------------------\\\\");
		for(int i=0;i<a.size();i++)
		{
			pai=a.get(i);
			s+=pai.toString()+"\n";
		}
		System.out.print(s);
		System.out.println("|------------------------------------------//");
	}
	public void visualizar_CT()
	{
		System.out.println("|------------------------------|");
		System.out.println("| A quantidade de cada cliente |");
		System.out.println("|------------------------------|");
		 System.out.printf("| Doutorado  | %-15d |\n",Doutorado.ctDoutorado);
		System.out.println("|------------------------------|");
		 System.out.printf("| Normal     | %-15d |\n",Normal.ctNormal);
		System.out.println("|------------------------------|");
		 System.out.printf("| Revendedor | %-15d |\n",Revendedor.ctRevendor);
		System.out.println("|------------------------------|");
		 System.out.printf("| Estado     | %-15d |\n",Estado.ctEstado);
		System.out.println("|------------------------------|");
	}
}
