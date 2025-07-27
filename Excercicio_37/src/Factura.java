import java.text.DecimalFormat;
import java.io.*;
public class Factura 
{
	private String nome,tipoC,bairro;
	private int code,qty;
	private float v,v5_15,vp;
	private DecimalFormat m;
	private BufferedReader br;
	public Factura()
	{
		m=new DecimalFormat("###,###.00 Mts");
		br=new BufferedReader(new InputStreamReader(System.in));
		code=validarInt("| Introduz o code de (1011-2011): |",1011,2011);
		nome=validarString("| Introduz o nome do Cliente: |");
		tipoC=validarString("| Introduz o tipo de Cliente(Particular || Empresa): |","Particular","Empresa");
		bairro=validarString("| Introduz o Bairro  onde reside(Central || Polana): |","Central","Polana");
		qty=validarInt("| Introduz a quantidade (>0): |");
		v=valor();
		v5_15=valor5_15();
		vp=soma();
	}
	public String validarString(String msg)
	{
		String x="";
		do
		{
			try
			{
				System.out.println("|=============================|");
				System.out.println(msg);
				System.out.println("|=============================|");
				x=br.readLine();
				if(x.length()<2)
				{
					System.out.println("|================|");
					System.out.println("| Nome Imvalido! |");
					System.out.println("|================|");
				}
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		}while(x.length()<2);
		return x;
	}
	public int validarInt(String msg)
	{
		int q=0;
		do
		{
			System.out.println("|=============================|");
			System.out.println(msg);
			System.out.println("|=============================|");
			try
			{
				q=Integer.parseInt(br.readLine());
				if(q<=0)
				{
					System.out.println("|======================|");
					System.out.println("| Quantidade Invalida! |");
					System.out.println("|======================|");
				}
			}
			catch(NumberFormatException x)
			{
				System.out.println(x.getMessage());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
		}while(q<=0);
		return q;
	}
	public String validarString(String msg,String a,String b)
	{
		String x="";
		try
		{
			do
			{
				System.out.println("|====================================================|");
				System.out.println(msg);
				System.out.println("|====================================================|");
				x=br.readLine();
				if(!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b))
				{
					System.out.println("|=======|");
					System.out.println("| ERRO! |");
					System.out.println("|=======|");
				}
			}while(!x.equalsIgnoreCase(a) && !x.equalsIgnoreCase(b));
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		return x;
	}
	public int validarInt(String msg,int a,int b)
	{
		int c=0;
		do
		{
			try
			{
				System.out.println("|----------------------|==========|");
				System.out.println(msg);
				System.out.println("|=================================|");
				c=Integer.parseInt(br.readLine());
				if(c<a || c>b)
				{
					System.out.println("|=======|");
					System.out.println("| ERRO! |");
					System.out.println("|=======|");
				}
			}
			catch(NumberFormatException x)
			{
				System.out.println(x.getMessage());
			}
			catch(IOException v)
			{
				System.out.println(v.getMessage());
			}
		}while(c<a || c>b);
		return c;
	}
	public float soma()
	{
		return v+v5_15;
	}
	public float valor5_15()
	{
		final float V5=5/100f,V15=15/100f;
		if(tipoC.equalsIgnoreCase("Particular"))
			return v*V5;
		else
			return v*V15;
	}
	public float valor()
	{
		final float VL=2.3f;
		return qty*VL;
	}
	public String gettipoC()
	{
		return tipoC;
	}
	public String getbairro()
	{
		return bairro;
	}
	public int getcode()
	{
		return code;
	}
	public float getv()
	{
		return v;
	}
	public float getvp()
	{
		return vp;
	}
	public float getv5_15()
	{
		return v5_15;
	}
	public String toString()
	{
		return "[Code: "+code+"\t|Nome: "+nome+"\t|Tipo de Cliente: "+tipoC+"\t|Bairro: "+bairro+"\t|Quantidade: "+qty+"\t|O valot sem Imposto: "+m.format(v)+"\t|O valor de Importo: "+m.format(v5_15)+"\t|O valor total: "+m.format(vp)+"\t]";
	}
}