
public class AgenteRegisto extends Agente {

	private char tipoRegisto; ///tipoCartao
	private byte numRegistos; //numVendas
	public static int contR;
	
	public AgenteRegisto(int c, String n, char t, float v, char tC, byte nV) 
	{
		super(c,n,t,v);
		tipoRegisto = tC;
		numRegistos = nV;
		contR++;
	}
	
	public AgenteRegisto() 
	{
		this(0,"",' ',0,' ',(byte) 0);
	}

	public void setTipoRegisto(char tipoRegisto) {
		this.tipoRegisto = tipoRegisto;
	}

	public void setNumRegistos(byte numRegistos) {
		this.numRegistos = numRegistos;
	}
	
	public char getTipoRegisto() {
		return tipoRegisto;
	}

	public byte getNumRegistos() {
		return numRegistos;
	}

	public String toString() {
		return "AgenteRegisto [tipoRegisto=" + tipoRegisto + ", numRegistos=" + numRegistos + ", codigo=" + codigo
				+ ", nome=" + nome + ", tipoAgente=" + tipoAgente + ", valorComissao=" + valorComissao + "]";
	}
}

