import java.text.DecimalFormat;
public class Visualizar 
{
	private DecimalFormat m;
	public Visualizar()
	{
		m=new DecimalFormat();
	}
	public String toString(int ct,Cliente [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
		return s;
	}
	public void acD(float a)
	{
		System.out.println("O valor total Desconte: "+m.format(a));
	}
	public void vizpesq(int a,Cliente [] array)
	{
		if(a==-1)
			System.out.println("O cliente nao existe");
		else
			System.out.println(array[a]);
	}
	public void ctTC(int ctN,int ctE)
	{
		System.out.println("A quantidade para cada tipo de Cliente: "+"\nNormat: "+ctN+"\nEstudate: "+ctE);
	}
	public void vizM(int ctC,int ctE,int ctP)
	{
		if(ctC>ctE)
		{
			if(ctC>ctE)
				System.out.println("Corte mas que rendeu");
			else
				System.out.println("Esticar mas que rendeu");
		}
		else
		{
			if(ctP<ctE)
				System.out.println("Esticar mas que rendeu");
			else
				System.out.println("Pintar mas que rendeu");
		}
	}
	
}