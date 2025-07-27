import java.text.DecimalFormat;
public class VizFact 
{
	private DecimalFormat m;
	public VizFact()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public String toString(int ct,Factura [] array)
	{
		String x=" ";
		for(int i=0;i<ct;i++)
			x+=array[i]+"\n";
		return x;
	}
	public void ctP(int ctP)
	{
		System.out.println("|===========================================================|");
		System.out.println("| A quantidade de clientes Particular no Bairro Central sao:|");
		System.out.println("|-----------------------------------------------------------|");
		System.out.printf("|%30d                             |\n",ctP);
		System.out.println("|===========================================================|");
	}
	public void acCI(float ac)
	{
		System.out.println("|==================================|");
		System.out.println("| O valor total em imposto sao de: |");
		System.out.println("|----------------------------------|");
		System.out.printf("|%30s    |\n",m.format(ac));
		System.out.println("|==================================|");
	}
	public String select(int ct,Factura [] array,int op)
	{
		String x="";
		for(int i=0;i<ct;i++)
		{
			if(array[i].getcode()==op)
				System.out.println(array[i]);
		}
		return x;
	}
}