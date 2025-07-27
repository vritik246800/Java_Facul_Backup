import java.text.DecimalFormat;
import java.io.*;

public class Bebida implements Serializable
{
	private String marca,tipoB;
	private int preco,qty,v;
	private float teor,vp,d;
	private DecimalFormat m;
	public Bebida(String marca,String tipoB,float teor,int qty,int preco)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		this.marca=marca;
		this.tipoB=tipoB;
		this.teor=teor;
		this.qty=qty;
		this.preco=preco;
		v=valorB();
		d=valorD();
		vp=valorT();
	}
	public float valorT()
	{
		return v-d;
	}
	public float valorD()
	{
		final float D1=5/100f,D2=2/100f;
		if(tipoB.equalsIgnoreCase("Whisky") && teor>40)
			return v*D1;
		else
		{
			if(tipoB.equalsIgnoreCase("Cidra") && teor<5.5f)
				return v*D2;
		}
		return 0;
	}
	public int valorB()
	{
		return preco*qty;
	}
	public String gettipoB()
	{
		return tipoB;
	}
	public String getmarca()
	{
		return marca;
	}
	public float getvp()
	{
		return vp;
	}
	public float getd()
	{
		return d;
	}
	public String toString()
	{
		return "[ Marca: "+marca+"\t|Tipo de Bebida: "+tipoB+"\t|Com o teor: "+teor+"\t|Quantidade: "+qty+"\t|Preco Unitario: "+m.format(preco)+"\t|O valor de disconto: "+m.format(d)+"\t|O valor Final: "+m.format(vp)+"\t]";
	}
}