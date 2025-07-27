
public class Pesca extends Barco
{
	private int qtyMarisco,nPescador;
	
	public static int ctPesca=0;
	
	public Pesca(String matricula,String marca,float peso,int qtyMarisco,int nPescador)
	{
		super(matricula,marca,peso);
		
		this.qtyMarisco=qtyMarisco;
		this.nPescador=nPescador;
		ctPesca++;
	}
	public Pesca()
	{
		this("","",0,0,0);
	}
	public int getqtyMarico()
	{
		return qtyMarisco;
	}
	public int getnPescador()
	{
		return nPescador;
	}
	public void setqtyMarisco(int qtyMarico)
	{
		this.qtyMarisco=qtyMarico;
	}
	public void setnPescador(int nPescador)
	{
		this.nPescador=nPescador;
	}
	public String toString()
	{
		return super.toString()+"\nBarcos de pesca: "+"\nQuantidade de Marisco: "+qtyMarisco+"\tNumero de pescador: "+nPescador;
	}
}
