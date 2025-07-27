
public class Familia extends ProGym
{
	private int qtyF,vpf;
	
	public static int ctFamilia=0;
	
	public Familia(String nome,int idade,String contacto,float peso,int contF)
	{
		super(nome,idade,contacto,peso);
		this.qtyF=contF;
		vpf=vpF();
		ctFamilia++;
	}
	public int vpF()
	{
		final int V=1000;
		return qtyF*V;
	}
	public int getvpf()
	{
		return vpf;
	}
	public Familia()
	{
		this("",0,"",0,0);
	}
	public int getcontF()
	{
		return qtyF;
	}
	public void setcontF(int contF)
	{
		this.qtyF=contF;
	}
	public String toString()
	{
		return super.toString()+"\nFamilia\n"+"Numero do Familiar: "+qtyF;
	}
}
