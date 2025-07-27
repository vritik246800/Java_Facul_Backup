import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
public class Reserva implements Serializable
{
	private String numeroT,nomeC,tipoR,dataE,dataS,respPraia,respPisc,respT;
	private int qtyD,qtyC,vPra,vPis;
	private float vI_T,vpUSD,vpMTS,vd;
	private final float CAMBIO=65;
	private DecimalFormat m;
	private NumberFormat u;
	private Validacoes v;
	public Reserva()
	{ 
		v=new Validacoes();
		
		numeroT=v.validarStringT("| Introduz o numero de telefone (82/83/84/85/86/87): |","| O numero de telefone Invalido tenta novamente ! |","|====================================================|","|=================================================|");
		nomeC=v.validarStringN("| Introduz nome de cliente (>2c): |","| O nome do cliente Invalido tenta novamente ! |","|=================================|","|==============================================|");
		tipoR=v.validarString("| Introduz o tipo de reserva (Empresa || Casal     || Particular): |","| O tipo de reserva Invalida tenta novamente ! |","Empresa","Casal     ","Particular", "|==================================================================|","|==============================================|");
		dataE=v.validarDE("| Introduz data de entrada (AAAA/MM/DD): |","| Data de entrada invalida tenta novamente ! |","|========================================|","|============================================|");
		dataS=v.validarDS(dataE,"| Introduz data de saida (AAAA/MM/DD) (>dia de entrada): |","| Data de saida invalida tenta novamente ! |", "|========================================================|","|==========================================|");
		respPraia=v.validarResp("| Introduz a resposta da Praia (Sim || Nao): |","| A resposta de praia Invalida ! |","|============================================|","|================================|");
		respPisc=v.validarResp("| Introduz a resposta da Piscina (Sim || Nao): |","| A resposta de piscina Invalida ! |","|==============================================|","|==================================|");
        
	}
	/*public String getnumeroT1()
	{
		return numeroT;
	}
	public String getnomeC1()
	{
		return nomeC;
	}
	public String gettipoR1()
	{
		return tipoR;
	}
	public String getdataE1()
	{
		return dataE;
	}
	public String getdataS1()
	{
		return dataS;
	}
	public String getrespPraia1()
	{
		return respPraia;
	}
	public String getrespPisc1()
	{
		return respPisc;
	}*/
	public Reserva(String numeroT,String nomeC,String tipoR,String dataE,String dataS,String respPraia,String respPisc)
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		u= NumberFormat.getCurrencyInstance(Locale.US);
		v=new Validacoes();
		
		this.numeroT=numeroT;
		this.nomeC=nomeC;
		this.tipoR=tipoR;
		this.dataE=dataE;
		this.dataS=dataS;
		this.respPraia=respPraia;
		this.respPisc=respPisc;
		
		qtyD=quantidadeD();
		vpUSD=valorReserva();
		vPra=valorPraia();
		vPis=valorPiscina();
		vpUSD=valorT();
		vI_T=valorImp_Tax();
		vpUSD=valorSemiFinal();
		vd=valorDisconto();
		vpUSD=valorUSD();
		vpMTS=valorMTS();
	}
	public float valorMTS()
	{
		return vpUSD*CAMBIO;
	}
	public float valorUSD()
	{
		return vpUSD-vd;
	}
	public float valorDisconto()
	{
		final float V3=23/100f;
		int entrada,saida;
		entrada=Integer.parseInt(dataE.substring(8,10));
		saida=Integer.parseInt(dataS.substring(8,10));
		for(int i=entrada; i<=saida;i++)
		{
			if(i==7 || i==25)
				return 0;
		}
		return vpUSD*V3;
	}
	public float valorSemiFinal()
	{
		return vpUSD+vI_T;
	}
	public String validarResp()
	{
		String n=" ";
		n=v.validarR();
		return n;
	}
	public float valorImp_Tax()
	{
		final float V1=10/100f,V2=3/100f;
		if(tipoR.equalsIgnoreCase("Empresa"))
		{
			System.out.println("|=======================|");
			System.out.println("| E Empresa tem Imposto |");
			System.out.println("|=======================|");
			return vpUSD*V1;
		}
		else
		{
			respT=validarResp();
			if(respT.equalsIgnoreCase("Sim"))
				return vpUSD*V2;
		}
		return 0;
	}
	public float valorT()
	{
		return vpUSD+vPra+vPis;
	}
	public int valorPiscina()
	{
		final int VPC=35;
		if(respPisc.toLowerCase().equals("sim"))
			return VPC;
		return 0;
	}
	public int valorPraia()
	{
		final int VPR=50;
		if(respPraia.toLowerCase().equals("sim"))
			return VPR;
		return 0;
	}
	public int valorReserva()
	{
		String n=tipoR.toLowerCase();
		int valor=0;
		final int VEMPRESA=100,VCASAL=80,VPARTICULAR=40;
		switch(n)
		{
			case "empresa":
				valor=VEMPRESA;
			case "casal     ":
				valor=VCASAL;
			case "particular":
				valor=VPARTICULAR;
		}
		return valor*qtyD;
	}
	public int quantidadeD()
	{
		int entrada,saida;
		entrada=Integer.parseInt(dataE.substring(8,10));
		saida=Integer.parseInt(dataS.substring(8,10));
		return saida-entrada;
	}
	public int getqtyC()
	{
		return qtyC;
	}
	public int getqtyD()
	{
		return qtyD;
	}
	public float getvpM()
	{
		return vpMTS;
	}
	public String getnomeC()
	{
		return nomeC;
	}
	public String getrespPisc()
	{
		return respPisc;
	}
	public String getrespPraia()
	{
		return respPraia;
	}
	public String getdataE()
	{
		return dataE;
	}
	public String getdataS()
	{
		return dataS;
	}
	public String gettipoR()
	{
		return tipoR;
	}
	public float getvpU()
	{
		return vpUSD;
	}
	public String getnumeroT()
	{
		return numeroT;
	}
	public String toString()
	{
		return "[O numero de Telefone: "+numeroT+"\t|Nome do Cliente: "+nomeC+"\t|Tipo de reserva: "+tipoR+"\t|Data de Entrada: "+dataE+"\t|Data de Saida: "+dataS+"\t|Responta da Paia: "+respPraia+"\t|Responta da Piscina: "+respPisc+"\t|O valor da reserva em Dollar:"+u.format(vpUSD)+"\t|O valor da reserva em Dollar:"+m.format(vpMTS)+"\t]";
	}
}