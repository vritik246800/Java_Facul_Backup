
public final class Comboio extends Terrestre 
{
	private String tipoC;
	Comboio(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,float km,String tipo)
	{
		super(code,valor,bi,dataP,dataC,nome,formaP,km);
		this.tipoC=tipo;
	}
	Comboio()
	{
		this(0,0,"","","","","",0,"");
	}
	
	void settipo(String tipo)
	{
		this.tipoC=tipo;
	}
	
	public float calcularvf()
	{
		float vd,vp,iva;
		float vIVA=calculoI();
		vd=vIVA*D;
		
		return valorCI()-vd;
	}
	String gettipo()
	{
		return tipoC;
	}
	public String toString()
	{
		return "Comboio: \t"+super.toString()+"\tTipo de Comboio: "+tipoC;
	}

}
