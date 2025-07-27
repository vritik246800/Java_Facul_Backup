
public class AgenteVendedor extends Agente{
	
	private byte numVendas; //numRecargas
	private byte valRecarga;
	public static int contV;
	
	public AgenteVendedor(int c, String n, char t, float v, byte q, byte vR) 
	{
		super(c,n,t,v);
		numVendas = q;
		valRecarga = vR;
		contV++;
	}
	
	public AgenteVendedor() 
	{
		this(0,"",' ',0,(byte)0,(byte)0);
	}

	public void setNumVendas(byte numVendas) {
		this.numVendas = numVendas;
	}

	public void setValRecarga(byte valRecarga) {
		this.valRecarga = valRecarga;
	}
	
	public byte getNumVendas() {
		return numVendas;
	}

	public byte getValRecarga() {
		return valRecarga;
	}

	public static int getContV() {
		return contV;
	}

	public String toString() {
		return "AgenteVendedor [numVendas=" + numVendas + ", valRecarga=" + valRecarga + ", codigo=" + codigo
				+ ", nome=" + nome + ", tipoAgente=" + tipoAgente + ", valorComissao=" + valorComissao + "]";
	}
}
