
public final class Carro extends Terrestre
{
	private String mt;
	private int qtyC;
	private float vP;
	Carro(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,float km,String mt,int qtyC,float vP)
	{
		super (code,valor,bi,dataP,dataC,nome,formaP,km);
		this.mt=mt;
		this.qtyC=qtyC;
		this.vP=vP;
	}
	Carro()
	{
		this(0,0,"","","","","",0,"",0,0);
	}
	public float calcularvf()
	{
		float iva=calculoI();
		
		return valor+iva;
	}
	void setmt(String mt)
	{
		this.mt=mt;
	}
	String getmt()
	{
		return mt;
	}
	void setqtyC(int qtyC)
	{
		this.qtyC=qtyC;
	}
	float getqtyC()
	{
		return qtyC;
	}
	void setvP(float vP)
	{
		this.vP=vP;
	}
	float getvP()
	{
		return vP;
	}
	public String toString()
	{
		return "Carro: \t"+super.toString()+"\tMatricula: "+mt+"\tQuantidade Combustivel: "+qtyC+"\tValor de Portagem: "+vP;
	}
}
