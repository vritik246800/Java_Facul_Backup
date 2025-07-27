
public class Vendedor extends Agente 
{
	private byte numVendas,valRecarga;
	public static int contV=0;
	
	public Vendedor(int codigo,String nome,float valComisao,char tipoAgente,byte numVendas,byte valRecarga) 
	{
		super(codigo,nome,valComisao,tipoAgente);
		this.numVendas=numVendas;
		this.valRecarga=valRecarga;
		contV++;
		
	}
	public Vendedor()
	{
		this(0,"",0,' ',(byte)0,(byte)0);
	}
	public void setnumVendas(byte numVendas) {this.numVendas=numVendas;}
	public byte getnumVendas() {return numVendas;}
	public void setvalRecarga(byte valRecarga) {this.valRecarga=valRecarga;}
	public byte getvalRecarga() {return valRecarga;}
	

}
