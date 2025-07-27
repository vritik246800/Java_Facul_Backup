
public abstract class Terrestre extends Bilhete implements API
{
	protected float km;
	static int ctT=0;
	
	Terrestre(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,float km)
	{
		super(code,valor,bi,dataP,dataC,nome,formaP);
		this.km=km;
		ctT++;
	}
	Terrestre()
	{
		this(0,0,"","","","","",0);
	}
	public float calculoI() 
	{
		return valor*IVA;
	}
	public float valorCI()
	{
		return valor+calculoI();
	}
	
	void setkm(float km)
	{
		this.km=km;
	}
	float getkm()
	{
		return km;
	}
	public String toString()
	{
		return "Terrestre: \n"+super.toString()+"\tKimoletragem: "+km;
	}
}
