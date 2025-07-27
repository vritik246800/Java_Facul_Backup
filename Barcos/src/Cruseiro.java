
public class Cruseiro extends Barco
{
	private int qtyPassageiro;
	
	public static int ctCruz=0;
	
	public Cruseiro(String matricula,String marca,float peso,int qtyPassageiro)
	{
		super(matricula,marca,peso);
		this.qtyPassageiro=qtyPassageiro;
		ctCruz++;
	}
	public Cruseiro()
	{
		this("","",0,0);
	}
	public int getqtyPassageiro()
	{
		return qtyPassageiro;
	}
	public void setqtyPassageiro(int qtyPassageiro)
	{
		this.qtyPassageiro=qtyPassageiro;
	}
	public String toString()
	{
		return super.toString()+"\nCruseiros: "+"\nQuantidade de Passageiro: "+qtyPassageiro;
	}
}
