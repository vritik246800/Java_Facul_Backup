import java.text.DecimalFormat;
import java.io.*;

public class Cliente implements Serializable
{
	private int code,v;
	private float d,vp;
	private String nome,tipoS,tipoC;
	private DecimalFormat m;
	public Cliente(int code,String nome,String tipoS,int v,String tipoC)
	{
		m=new DecimalFormat("###,###,###.00 mts");
		this.code=code;
		this.nome=nome;
		this.tipoS=tipoS;
		this.v=v;
		this.tipoC=tipoC;
		d=valorD();
		vp=valor();
	}
	public float valor()
	{
		return v-d;
	}
	public float valorD()
	{
		final float D=7/100f;
		if(tipoC.equalsIgnoreCase("Estudante"))
			return v*D;
		return 0;
	}
	public int getCode() {
		return code;
	}
	public int getV() {
		return v;
	}
	public float getD() {
		return d;
	}
	public float getVp() {
		return vp;
	}
	public String getNome() {
		return nome;
	}
	public String getTipoS() {
		return tipoS;
	}
	public String getTipoC() {
		return tipoC;
	}
	public String toString() {
		return "[ Code=" + code + ", v=" + m.format(v) + ", d=" + m.format(d) + ", vp=" + m.format(vp) + ", nome=" + nome + ", tipoS=" + tipoS+ ", tipoC=" + tipoC +"\t]";
	}
	
	
}
