import java.text.DecimalFormat;
import java.io.*;
public class Jogador implements Serializable
{
	private DecimalFormat m;
	private int code,v;
	private String desp;
	private float i;
	public Jogador(int code,String desp,int v)
	{
		m=new DecimalFormat("###,###.00 Mts");
		
		this.code=code;
		this.desp=desp;
		this.v=v;
		i=valorI();
		
	}
	public float valor()
	{
		return v+i;
	}
	public float valorI()
	{
		final float I=10/100f;
		if(v>0)
			return v*I;
		return 0;
	}
	public int getcode()
	{
		return code;
	}
	public String getdesp()
	{
		return desp;
	}
	public int getv()
	{
		return v;
	}
	public float geti()
	{
		return i;
	}
	public String toString()
	{
		return "[ Code: "+code+"\t|Desporto: "+desp+"\t|Valor sem imposto: "+m.format(v)+"\t|Valor de Imposto: "+m.format(i)+"\t]";
	}
}