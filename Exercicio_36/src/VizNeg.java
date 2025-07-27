import java.text.DecimalFormat;
public class VizNeg 
{
	private DecimalFormat m;
	public VizNeg()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public String toString(int ct,Negociante [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
		return s;
	}
	public void vizac10(float a)
	{
		System.out.println("O valor total de Imposto de vendas: "+m.format(a));
	}
	public void vizV(int v)
	{
		System.out.println("A quantidade de vendas: "+v);
	}
	public void vizC(int c)
	{
		System.out.println("A quantidade de compra: "+c);
	}
}