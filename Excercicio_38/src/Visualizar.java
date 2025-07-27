import java.text.DecimalFormat;

public class Visualizar 
{
	private DecimalFormat m;
	public Visualizar()
	{
		m=new DecimalFormat();
	}
	public void vizct(int ctF,int ctT,int ctC)
	{
		System.out.println("|=============================|\n|| A quantidade nos desportos |\n|=============================|\n|Futebol: "+ctF+"|\n|Tenis: "+ctT+"|\n|Cavalo: "+ctC+"|\n|=============================|");
	}
	public String toString(int ct,Jogador [] array)
	{
		String s="";
		for(int i=0;i<ct;i++)
			s+=array[i]+"\n";
		return s;
	}
	public void vizacP(float a)
	{
		System.out.println("O valor total ganho sao de : "+m.format(a));
	}
	public void vizacN(float a)
	{
		System.out.println("O valor total ganho sao de : "+m.format(a));
	}
	public void balanco(float acP,float acN)
	{
		System.out.println("valor P: "+acP+"\t|Valor N: "+acN);
		if(acP>acN)
			System.out.println("A casa de aposta em Lucro ! ");
		else
			System.out.println("A casa de aposta em Prejuiso ! ");
	}
	public void vizpesq(int i,Jogador [] array)
	{
		if(i==-1)
			System.out.println("O jogador nao existe ! ");
		else
			System.out.println(array[i]);
	}
}