import java.io.*;
public class TodasFacturas 
{
	private Factura [] array;
	private int ct,n;
	private CalculosFact cf;
	private VizFact vf;
	public TodasFacturas()
	{
		n=validarInt("| Introduz o numero de linhas para a lista(>0): |");
		array=new Factura[n];
		ct=0;
		cf=new CalculosFact();
		vf=new VizFact();
	}
	public void todos()
	{
		for(int fr=0;fr<n;fr++)
		{
			System.out.println("|======================|");
			System.out.println("| Dados da "+(fr+1)+"-a F|");
			array[ct]=new Factura();
			ct++;
		}
	}
	public void criarFile()
	{
		float a=0;
		a=cf.acSI(ct,array);
		CriarFile cf=new CriarFile();
		cf.criarFile(a);
	}
	public void acCI()
	{
		float ac;
		ac=cf.acCI(ct,array);
		vf.acCI(ac);
	}
	public void ctP()
	{
		int ctP;
		ctP=cf.ctP(ct, array);
		vf.ctP(ctP);
	}
	public String toString()
	{
		return vf.toString(ct,array);
	}
	/*public void pesquisar()
	{
		SelectFact sf=new SelectFact();
		int op,code;
		for(int i=0;i<ct;i++)
			code=array[i].getcode();
		op=sf.pesquisar(code,ct,array);
	}*/
	public void selectFac()
	{
		SelectFact sf=new SelectFact();
		int op;
		op=sf.selectF();
		vf.select(ct,array,op);
	}
	public int validarInt(String a)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("|===============================================|");
			System.out.println(a);
			System.out.println("|===============================================|");
			try
			{
				n=Integer.parseInt(br.readLine());
				if(n<=0)
				{
					System.out.println("|=======|");
					System.out.println("| ERRO! |");
					System.out.println("|=======|");
				}
			}
			catch(NumberFormatException z)
			{
				System.out.println(z.getMessage());
			}
			catch(IOException x)
			{
				System.out.println(x.getMessage());
			}
		}while(n<=0);
		return n;
	}
}