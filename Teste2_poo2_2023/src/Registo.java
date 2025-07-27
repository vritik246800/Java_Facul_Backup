
public final class Registo extends Agente 
{
	private char tipoRegisto;
	private byte numRegistos;
	public static int contR=0;
	
	public Registo(int codigo,String nome,float valComisao,char tipoAgente,char tipoRegisto,byte numRegistos)
	{
		super(codigo,nome,valComisao,tipoAgente);
		this.tipoRegisto=tipoRegisto;
		this.numRegistos=numRegistos;
		contR++;
		
	}
	public Registo()
	{
		this(0,"",0,' ',' ',(byte)0);
	}
	public void settipoRegisto(char tipoRegisto) {this.tipoRegisto=tipoRegisto;}
	public char gettipoRegisto() {return tipoRegisto;}
	public void setnumRegistos(byte numRegistos) {this.numRegistos=numRegistos;}
	public byte getnumRegistos() {return numRegistos;}
	

}
