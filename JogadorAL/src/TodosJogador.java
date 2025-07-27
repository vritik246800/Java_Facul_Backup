import java.io.*;
import java.util.*;


public class TodosJogador 
{
	private ArrayList array;
	
	private Viz vis;
	private Calculo cal;
	private EscreverFile esc;
	
	public TodosJogador()
	{
		array=new ArrayList();
		
		vis=new Viz();
		cal=new Calculo();
		esc=new EscreverFile();
	}
	public void todos()
	{
		String tD,linha;
		StringTokenizer seccao;
		int code,v;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				code=Integer.parseInt(seccao.nextToken());
				tD=seccao.nextToken();
				v=Integer.parseInt(seccao.nextToken());
				
				Jogador j=new Jogador(code,tD,v);
				array.add(j);
				
				linha=br.readLine();
			}
			array.trimToSize();
			br.close();
			System.out.println("File Lido com Sucesso !!");
		}
		catch(FileNotFoundException z)
		{
			System.out.println(z.getMessage());
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
	public void ctTD()
	{
		int ctF,ctT,ctC;
		ctF=cal.ct(array,"Futebol");
		ctT=cal.ct(array,"Tenis");
		ctC=cal.ct(array,"Cavalos");
		
		vis.vizct(ctF,ctT,ctC);
	}
	public void ac()
	{
		float acG,acP,ac;
		
		acG=cal.acG(array);
		acP=cal.acP(array);
		vis.acGP(acG,acP);
		
		ac=acG+acP;
		vis.ac(ac);
	}
	public void escreverOBJ()
	{
		esc.escreverO(array);
		array=esc.lerO();
		
	}
	public void ac10()
	{	
		esc.ac10(array);
	}
}








