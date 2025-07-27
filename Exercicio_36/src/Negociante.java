import java.text.DecimalFormat;
public class Negociante
{
	private String nome,tipoO;
	private int v;
	private float vC,vp;
	private DecimalFormat m;
	
	public Negociante(String nome,String tipoO,int v)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		this.nome=nome;
		this.tipoO=tipoO;
		this.v=v;
		vC=valorC();
		vp=valorP();
	}
	public float valorP()
	{
		return v-vC;
	}
	public float valorC()
	{
		final float C=10/100f;
		if(tipoO.equalsIgnoreCase("Venda"))
			return v*C;
		return 0;
	}
	public float getVP()
	{
		return vp;
	}
	public float getvalorC()
	{
		return vC;
	}
	public String gettipoO()
	{
		return tipoO;
	}
	public String toString()
	{
		return "[Nome: "+nome+"\t|Tipo de Operacao: "+tipoO+"\t|O valor sem comissao: "+m.format(v)+"\t|O valor de comissao: "+m.format(vC)+"\t|O valor final: "+m.format(vp)+"\t]";
	}
}