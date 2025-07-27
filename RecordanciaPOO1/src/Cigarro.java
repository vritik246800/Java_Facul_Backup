import java.text.DecimalFormat;
import java.io.*;
public class Cigarro implements Serializable
{
	//o tipo (Descartavel || Recarregavel)
	private String marca,sabor,tipo;
	private int qtyP,qty,precoSI,qtyR;
	private float vp,i,d;
	private DecimalFormat m;
	
	public Cigarro(String marca,String sabor,String tipo,int qtyP,int qty,int precoSI,int qtyR)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		
		this.marca=marca;
		this.sabor=sabor;
		this.tipo=tipo;
		this.qtyP=qtyP;
		this.qty=qty;
		this.precoSI=precoSI;
		this.qtyR=qtyR;
		
		vp=vp();
		vp=vpR();
		d=d();
		vp=menos();
		i=i();
		vp=mais();
	}
	public float mais()
	{
		return vp+i;
	}
	public float i()
	{
		final float I=16/100f;
		return vp*I;
	}
	public float menos()
	{
		return vp-d;
	}
	public float d()
	{
		final float D=23/100f;
		if(qty>10)
			return vp*D;
		return 0;
	}
	public float vp()
	{
		return precoSI*qty;
	}
	public float vpR()
	{
		final int VR=200;
		if(tipo.equalsIgnoreCase("Recarregavel"))
			return vp+qtyR*VR;
		return vp;
	}
	public String getmarca()
	{
		return marca;
	}
	public String getsabor()
	{
		return sabor;
	}
	public String gettipo()
	{
		return tipo;
	}
	public int getqtyP()
	{
		return qtyP;
	}
	public int getqty()
	{
		return qty;
	}
	public float getvp()
	{
		return vp;
	}
	public String toString()
	{
		return "Marca: "+marca+"\tsabor: "+sabor+"\ttipo: "+tipo+"\tqtyP:"+qtyP+"\tqty: "+qty+"\tprecoSI: "+m.format(precoSI)+"\tqtyR: "+qtyR+"\tVP: "+m.format(vp);
	}
}
