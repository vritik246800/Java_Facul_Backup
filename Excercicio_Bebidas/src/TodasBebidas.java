import java.io.*;
import java.util.*;
public class TodasBebidas 
{
	private int ct;
	private Bebida [] array;
	private VisualizacaoB vb;
	private CalculoB cb;
	
	public TodasBebidas()
	{
		array=new Bebida[100];
		ct=0;
		vb=new VisualizacaoB();
		cb=new CalculoB();
	}
	public void todos()
	{
		String marca,tipoB,linha;
		StringTokenizer seccao;
		float teor;
		int preco,qty;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				marca=seccao.nextToken();
				tipoB=seccao.nextToken();
				teor=Float.parseFloat(seccao.nextToken());
				qty=Integer.parseInt(seccao.nextToken());
				preco=Integer.parseInt(seccao.nextToken());
				
				linha=br.readLine();
				
				array[ct]=new Bebida(marca,tipoB,teor,qty,preco);
				ct++;
			}
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("O file de dados nao encontrado!!");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("File de Dados Lido com Sucesso!!");
	}
	public String toString()
	{
		return vb.toString(ct,array);
	}
	public void acD()
	{
		float ac=cb.acD(ct,array);
		vb.vizacD(ac);
	}
	public void ctB()
	{
		int ctw=0,ctci=0,ctce=0;
		ctw=cb.ctB(ct,array,"Whisky");
		ctci=cb.ctB(ct,array,"Cidra");
		ctce=cb.ctB(ct,array,"Cerveja");
		vb.vizctB(ctw,ctci,ctce);
	}
	public void criarTXT()
	{
		CriarFiletxt c=new CriarFiletxt();
		c.criarTXT(ct,array);
	}
	public void CriarFObj()
	{
		CriarObj c=new CriarObj();
		c.criarFObj(array);
	}
	public void LerFObj()
	{
		CriarObj c=new CriarObj();
		c.lerFObj(array);
	}
}