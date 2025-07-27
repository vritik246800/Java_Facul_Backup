import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class Visualisar 
{
	private DecimalFormat m;
	private NumberFormat u;
	public Visualisar()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		u= NumberFormat.getCurrencyInstance(Locale.US);
	}
	public void vizP(int p,Reserva [] array)
	{
		if(p==-1)
			System.out.println("O cliente nao existe");
		else
			System.out.println(array[p]);
	}
	public void vizTabelaValor(int ct,Reserva [] array)
	{
		
		System.out.println("|===============================================================|");
		System.out.println("| Tipo de Reserva | Valor a pagar em USD | Valor a pagar em MTs |");
		System.out.println("|=================|======================|======================|");
		for(int i=0;i<ct;i++)
		{
			
			System.out.printf("| %15s | %21s| %20s |\n",array[i].gettipoR(),u.format(array[i].getvpU()),m.format(array[i].getvpM()));
			System.out.println("|=================|======================|======================|");
		}
	}
	public String toString(int ct,Reserva [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
		return s;
	}
	public void vizctF(int ctF) 
	{
		DecimalFormat c=new DecimalFormat("###,### Clientes");
		System.out.println("|==============================================|");
		System.out.println("| A quantidade de clientes de epoco de feriado |");
		System.out.println("|==============================================|");
		System.out.printf("| %30s               |\n",c.format(ctF));
		System.out.println("|==============================================|");
	}
	public void vizCTR(String e,int ctE,String c,int ctC,String p,int ctP,String soma,int ctG)
	{
		System.out.println("|===========================================|");
		System.out.println("| Tipo de Reserva | Quantidades de clientes |");
		System.out.println("|===========================================|");
		System.out.printf("| %15s | %20s    |\n",e,ctE);
		System.out.printf("| %15s | %20s    |\n",c,ctC);
		System.out.printf("| %15s | %20s    |\n",p,ctP);
		System.out.println("|===========================================|");
		System.out.printf("| %15s | %15s    |\n",soma,ctG);
		System.out.println("|===========================================|");	
	}
}