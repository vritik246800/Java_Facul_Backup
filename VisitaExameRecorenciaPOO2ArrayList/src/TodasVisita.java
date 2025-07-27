import java.io.*;
import java.util.ArrayList;

import java.util.*;
public class TodasVisita 
{
	private ArrayList array;
	
	private Viz vis;
	private Cal cal;
	
	public TodasVisita()
	{
		array = new ArrayList();
		
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
				
				Visita v =new Visita(nome,datav,tA,qtyp,apt);
				array.add(v);
				
				linha=br.readLine();
				
			}
			array.trimToSize();
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
		return vis.toString(array);
	}
	public void ctT()
	{
		int ctG,ctB,ctC;
		Gravar g=new Gravar();
		
		ctG=cal.calct(array,"Game Drive");
		ctB=cal.calct(array,"Bush Braai");
		ctC=cal.calct(array,"Cycling");
		
		g.gravarct(ctG,ctB,ctC);
		
	}
	public void ctDez()
	{
		int ctDez;

		ctDez=cal.ctDez(array);
		
		vis.cTD(ctDez);	
	}
	public void acDesc()
	{
		float acD=0;
		
		acD=cal.acd(array);
		
		vis.ACD(acD);
	}
	public void pesq()
	{
		String tipoA;
		int poz;
		float aG=0,aB=0,aC=0;
		
		Pesquisa p=new Pesquisa();
		Validacao val=new Validacao();
		
		aG=cal.acg(array,"Game Drive");
		aB=cal.acg(array,"Bush Braii");
		aC=cal.acg(array,"Cycling");
		
		tipoA=val.VS();
		poz=p.pesquisa(array,tipoA);
		
		vis.ACG(array,poz,aG,aB,aC);
		
	}
}






