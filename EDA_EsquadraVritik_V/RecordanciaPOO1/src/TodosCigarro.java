import java.io.*;
import java.util.*;
public class TodosCigarro 
{
	private int ct;
	private Cigarro [] array;
	
	private Calculo cal;
	private Visualizacao vis;
	private CriarFile cf;
	private ECO o;
	private Validacao val ;
	private Pesquisa pq;
	
	public TodosCigarro()
	{
		ct=0;
		array = new Cigarro[100];
		
		cal=new Calculo();
		vis=new Visualizacao();
		cf=new CriarFile();
		o=new ECO();
		val=new Validacao();
		pq=new Pesquisa();
	}
	public void todos()
	{
		String linha,marca,sabor,tipo;
		StringTokenizer seccao;
		int qtyP,qty,precoSI,qtyR;
		
		try
		{
			FileReader fr=new FileReader("dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				marca=seccao.nextToken();
				sabor=seccao.nextToken();
				tipo=seccao.nextToken();
				qtyP=Integer.parseInt(seccao.nextToken());
				qty=Integer.parseInt(seccao.nextToken());
				precoSI=Integer.parseInt(seccao.nextToken());
				qtyR=Integer.parseInt(seccao.nextToken());
				
				array[ct]=new Cigarro(marca,sabor,tipo,qtyP,qty,precoSI,qtyR);
				ct++;
				
				linha=br.readLine();
			}
			br.close();
			System.out.println("File Lido com successo !!");
			
		}
		catch(NumberFormatException z)
		{
			System.out.println(z.getMessage());
		}
		catch(FileNotFoundException x)
		{
			System.out.println("File de txt nao encontra !");
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		
	}
	public void ct()
	{
		int c=0;
		
		c=cal.ctQ(ct,array,"Menta");
		
		vis.vixC(c);
	}
	public String toString()
	{
		return vis.toString(ct,array);
	}
	public void ac()
	{
		float acR=0,acD=0;
		
		acR=cal.ac(ct,array,"Recarregavel");
		acD=cal.ac(ct,array,"Descartavel");
		
		vis.ac(acR,acD);
	}
	public void acG()
	{
		float acG=0;
		
		acG=cal.acg(ct,array);
		
		cf.criar(acG);
	}
	public void EO()
	{
		o.EO(array);
	}
	public void pesquisa()
	{
		String intCig;
		int pesq;
		
		intCig=val.lerC("Introduz a marca de cigarro que quer ( L >= 2 ) ?");
		pesq=pq.pesquisa(ct,array,intCig);
		
		vis.vizpesq(array,pesq);
		
	}
}






