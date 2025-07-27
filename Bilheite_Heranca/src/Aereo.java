
public class Aereo extends Bilhete 
{
	private int qtyM;
	private String nomeC;
	static int ctA=0;
	Aereo(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,int qtyM,String nomeC)
	{
		super(code,valor,bi,dataP,dataC,nome,formaP);
		this.qtyM=qtyM;
		this.nomeC=nomeC;
		ctA++;
	}
	Aereo()
	{
		this(0,0,"","","","","",0,"");
	}
	void setqtyM(int qtyM)
	{
		this.qtyM=qtyM;
	}
	int getqtyM()
	{
		return qtyM;
	}
	void setnomeC(String nomeC)
	{
		this.nomeC=nomeC;
	}
	String getnomeC()
	{
		return nomeC;
	}
	public String toString()
	{
		return "Aereo: \t"+super.toString()+"\tQuantidade de Milhas: "+qtyM+"\tNome da Companhia: "+nomeC;
	}
	
}
