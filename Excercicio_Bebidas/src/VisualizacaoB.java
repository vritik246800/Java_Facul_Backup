import java.text.DecimalFormat;
public class VisualizacaoB 
{
	private DecimalFormat m;
	public VisualizacaoB()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
	}
	public String toString(int ct,Bebida [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
		return s;
	}
	public void vizacD(float a)
	{
		System.out.println("O valor todal de disconto: "+m.format(a));
	}
	public void vizctB(int ctw,int ctci,int ctce)
	{
		System.out.println("As quantidade de bebidas sao:");
		System.out.println("Whiskys: "+ctw+"\nCidra: "+ctci+"\nCerveja: "+ctce);
	}
}
