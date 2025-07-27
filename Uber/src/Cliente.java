/*
  OBJ cliente
	nome
	qtyP(1-5)
	tipoViatura(Normal ou Executivo)
		normal 200
		executivo 
	calc no OBJ
	CT static
	Button para gravar 
	Button para viz
		numa janela a parte
	ArrayList
 */

public class Cliente 
{
	public static int ctC=0;
	private String nome,tpC;
	private int qtyP;
	
	public Cliente(String nome,String tpC,int qtyP)
	{
		this.nome=nome;
		this.tpC=tpC;
		this.qtyP=qtyP;
		ctC++;
	}
	public Cliente()
	{
		this("","",0);
	}
	public float calculo()
	{
		if(tpC.equalsIgnoreCase("Normal"))
			return qtyP*200;
		return 500;
	}
	public String getnome(){return nome;}
	public String gettpC() {return tpC;}
	public int getqtyP() {return qtyP;}
	
	public void setnome(String nome) {this.nome=nome;}
	public void settpC(String tpC) {this.tpC=tpC;}
	public void setqtyP(int qtyP) {this.qtyP=qtyP;}
	
	public String toString()
	{
		return "| Nome: "+nome+"\t| Tipo de Cliente: "+tpC+"\t| Quantidade de Cliente: "+qtyP+"| Valor: "+calculo();
	}
}
