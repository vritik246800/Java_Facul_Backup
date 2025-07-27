import java.io.*;
import java.text.DecimalFormat;

public class Jogador implements Serializable 
{
	private String tD;
	private int v,code;
	private float vf,vi;
	private DecimalFormat m;
	
	public Jogador(int code,String tD,int v)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		
		this.code=code;
		this.tD=tD;
		this.v=v;
		vi=valorI();
		vf=valorF();
		
		
	}
	public float valorI()
	{
		final float I=10/100f;
		if(v>0)
			return v*I;
		return 0;
	}
	public float valorF()
	{
		return v+vi;
	}
	public int getv()
	{
		return v;
	}
	public float getvi()
	{
		return vi;
	}
	public float getvf()
	{
		return vf;
	}
	public int getcode()
	{
		return code;
	}
	public String gettD()
	{
		return tD;
	}
	public String toString()
	{
		return "[Code: "+code+"\tTipo de Disporto: "+tD+"\tValor"+m.format(v)+"\tImposto: "+m.format(vi)+"\tValor Final: "+m.format(vf);
	}
}
