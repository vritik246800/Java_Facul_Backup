
public class Carga extends Barco
{
	private int nContetor;
	private String pais;
	
	public static int ctCarga=0;
	
	public Carga(String matricula,String marca,float peso,int nContetor)
	{
		super(matricula,marca,peso);
		this.nContetor=nContetor;
		ctCarga++;
	}
	public Carga()
	{
		this("","",0,0);
	}
	public int getnContetor()
	{
		return nContetor;
	}
	public void setnContador(int nContetor)
	{
		this.nContetor=nContetor;
	}
	public String toString()
	{
		return super.toString()+"\nBarcos de Carga:"+"\nNumero Contador: "+nContetor;
	}

}
