import java.io.*;
import java.util.*;
public class TodasVisita 
{
	private Visita [] array;
	private int ct;
	
	private Viz vis;
	private Cal cal;
	
	public TodasVisita()
	{
		ct=0;
		array = new Visita [100];
		
		vis=new Viz();
		cal=new Cal();
		
	}
	public void todos()
	{
		String linha,nome,datav,tA,apt;
		int qtyp;
		StringTokenizer seccao;
		
		try
		{
			//FileReader fr=new FileReader("dados.txt");
			
			BufferedReader br=new BufferedReader(new FileReader("dados.txt"));
			
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				nome=seccao.nextToken();
				datav=seccao.nextToken();
				tA=seccao.nextToken();
				qtyp=Integer.parseInt(seccao.nextToken());
				apt=seccao.nextToken();
				
				array[ct]=new Visita(nome,datav,tA,qtyp,apt);
				ct++;
				
				linha=br.readLine();
				
			}
			br.close();
			System.out.println("File lido com Successo !");
			
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de txt nao existe !");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
	}
	public String toString()
	{
		return vis.toString(ct,array);
	}
	public void ctT()
	{
		int ctG,ctB,ctC;
		Gravar g=new Gravar();
		
		ctG=cal.calct(ct,array,"Game Drive");
		ctB=cal.calct(ct,array,"Bush Braai");
		ctC=cal.calct(ct,array,"Cycling");
		
		g.gravarct(ctG,ctB,ctC);
		
	}
	public void ctDez()
	{
		int ctDez;

		ctDez=cal.ctDez(ct,array);
		
		vis.cTD(ctDez);	
	}
	public void acDesc()
	{
		float acD=0;
		
		acD=cal.acd(ct,array);
		
		vis.ACD(acD);
		
	}
	public void pesq()
	{
		String tipoA;
		int ex;
		float aG=0,aB=0,aC=0;
		
		Pesquisa p=new Pesquisa();
		Validacao val=new Validacao();
		
		aG=cal.acg(ct,array,"Game Drive");
		aB=cal.acg(ct,array,"Bush Braii");
		aC=cal.acg(ct,array,"Cycling");
		
		tipoA=val.VS();
		ex=p.pesquisa(ct,array,tipoA);
		
		vis.ACG(array,ex,aG,aB,aC);
		
	}
	
}






