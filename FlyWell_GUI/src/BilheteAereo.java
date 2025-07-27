
public final class BilheteAereo extends Bilhete
{
	private String companhiaAerea;
	public static int ctA=0;
	
	public BilheteAereo(String destino,String passaport,int valor,String companhiaAerea)
	{
		super(destino,passaport,valor);
		this.companhiaAerea=companhiaAerea;
		ctA++;
		
	}
	public BilheteAereo()
	{
		this("","",0,"");
	}
	public String getcompanhiaAerea() {return companhiaAerea;}
	
	public float valorTAX()
	{
		final float TAX=5/100f;
		return vf()*TAX;
	}
	public float vaF()
	{
		return vf()+valorTAX();
	}
	
	public void setcompanhiaAerea(String companhiaAerea) {this.companhiaAerea=companhiaAerea;}

}
