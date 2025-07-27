import java.io.*;
import java.util.*;
public class TodosJogadores 
{
	private int ct;
	private Jogador [] array;
	private Calculo cal;
	private Visualizar vis;
	private Validacao vl;
	private EscreverLerO o;
	private float acP,acN;
	
	public TodosJogadores()
	{
		ct=0;
		array =new Jogador[100];
		
		cal=new Calculo();
		vis=new Visualizar();
		vl=new Validacao();
		o=new EscreverLerO();
		
		acP=0;
		acN=0;
	}
	public void todos()
	{
		String linha,desp;
		int v,code;
		StringTokenizer seccao;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader (fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				code=Integer.parseInt(seccao.nextToken());
				desp=seccao.nextToken();
				v=Integer.parseInt(seccao.nextToken());
				
				array[ct]=new Jogador(code,desp,v);
				ct++;
				
				linha=br.readLine();
			}
			br.close();
		}
		catch(NumberFormatException z)
		{
			System.out.println(z.getMessage());
		}
		catch(FileNotFoundException x)
		{
			System.out.println("File de Dados.txt nao encontra ! ");
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("File de dados lido com Sucesso ! ! ");
	}
	public void Ordenacao()
	{
		Ordenar o=new Ordenar();
		o.bb(ct,array);
	}
	public void EscververOBJ()
	{
		o.gravarO(array);
	}
	public void LerOBJ()
	{
		o.ler(array);
	}
	public void pesquisa()
	{
		int i,code;
		Pesquisa pq=new Pesquisa();
		
		code=vl.code("Introduz o codigo do jogador (>0): ",101,999);
		i=pq.pesquisa(ct,array,code);
		
		vis.vizpesq(i,array);
	}
	public void balanco()
	{
		float acNn=cal.converter(acN);
		vis.balanco(acP,acNn);
	}
	public void escrever()
	{
		CriarFile cf=new CriarFile();
		cf.escrever(ct, array);
	}
	public void acP()
	{
		acP=cal.acP(ct, array);
		vis.vizacP(acP);
	}
	public void acN()
	{
		acN=cal.acN(ct, array);
		vis.vizacN(acN);
	}
	public String toString()
	{
		return vis.toString(ct, array);
	}
	public void ct()
	{
		int ctF=0,ctT=0,ctC=0;
		
		ctF=cal.ct(ct, array, "Futebol");
		ctT=cal.ct(ct, array, "Tenis");
		ctC=cal.ct(ct, array, "Cavalo");
		
		vis.vizct(ctF,ctT,ctC);
	}
}