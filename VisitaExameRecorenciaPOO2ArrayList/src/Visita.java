import java.text.DecimalFormat;
import java.io.*;

public class Visita implements Serializable
{
	private String nome,datav,tA,apt;
	private int qtyp;
	private float vpBWP,vpMT,d;
	
	private DecimalFormat m;
	
	
	public Visita(String nome,String datav,String tA,int qtyp,String apt)
	{
		m = new DecimalFormat("###,###,###. 00 Mts");
		
		this.nome=nome;
		this.datav=datav;
		this.tA=tA;
		this.qtyp=qtyp;
		this.apt=apt;
		
		vpBWP=VPBWP();
		vpMT=VPMT();
		vpMT=VPGAME();
		d=valorD();
		vpMT=menos();
		
	}
	public float menos()
	{
		return vpMT-d;
	}
	private float VPGAME()
	{
		final int MAIS=150;
		if(tA.equalsIgnoreCase("game drive") && apt.equalsIgnoreCase("sim"))
			return vpMT+MAIS*qtyp;
		return vpMT;
	}
	public float VPMT()
	{
		final float CAMB=4.7f;
		return vpBWP*CAMB;
	}
	public float VPBWP()
	{
		final int GD=1200,BB=750,CC=300;
		switch(tA.toLowerCase())
		{
			case "game drive":
				return qtyp*GD;
			case "bush braai":
				return qtyp*BB;
			case "cycling":
				return qtyp*CC;
		}
		return 0;
	}
	public float valorD()
	{
		final float D10=10/100f,D5=5/100f;
		if(qtyp>100)
			return vpMT*D10;
		else
		{
			if(qtyp>50)
				return vpMT*D5;
		}
		return 0;
	}
	public int getqtyp()
	{
		return qtyp;
	}
	public float getvp()
	{
		return vpMT;
	}
	public String gettA()
	{
		return tA;
	}
	public String getdatav()
	{
		return datav;
	}
	public float getd()
	{
		return d;
	}
	public String toString()
	{
		return "Nome: "+nome+"\tData Visita: "+datav+"\tTipo de Actividade: "+tA+"\tNumero de Pessoas: "+qtyp+"\tAperitivos: "+apt+"\tVP sem final: "+m.format(vpMT);
	}
	
}
