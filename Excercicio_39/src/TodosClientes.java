import java.io.*;
import java.util.*;

public class TodosClientes 
{
	private Cliente [] array;
	private int ct;
	private Visualizar vis;
	private Calculo cal;
	public TodosClientes()
	{
		array= new Cliente[100];
		ct=0;
		vis=new Visualizar();
		cal=new Calculo();
		
	}
	public void todos()
	{
		String linha,tipoC,tipoS,nome;
		int v,code;
		StringTokenizer seccao;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				code=Integer.parseInt(seccao.nextToken());
				nome=seccao.nextToken();
				tipoS=seccao.nextToken();
				v=Integer.parseInt(seccao.nextToken());
				tipoC=seccao.nextToken();
				linha=br.readLine();
				array[ct]=new Cliente(code,nome,tipoS,v,tipoC);
				ct++;
			}
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de dados nao encontra!");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("File de dados lido com sucesso!");
	}
	public void acD()
	{
		vis.acD(cal.acD(ct,array));
	}
	public String toString()
	{
		return vis.toString(ct,array);
	}
	public void escrever()
	{
		float a=cal.acG(ct,array);
		Escrever e=new Escrever();
		e.escrever(a);
	}
	public void pesquisa()
	{
		Pesquisa p=new Pesquisa();
		int a=p.pesquisar(ct,array);
		vis.vizpesq(a,array);
	}
	public void ctTC()
	{
		int ctN=0,ctE=0;
		ctN=cal.ct(ct,array,"Normal");
		ctE=cal.ct(ct,array,"Estudante");
		vis.ctTC(ctN,ctE);
	}
	public void ctTS()
	{
		int ctC=0,ctE=0,ctP=0;
		ctC=cal.ct(ct,array,"Cortar");
		ctE=cal.ct(ct,array,"Esticar");
		ctP=cal.ct(ct,array,"Pintar");
		vis.vizM(ctC,ctE,ctP);
	}
	public void gravarObj()
	{
		CriarO g=new CriarO();
		g.gravarObj(array);
	}
	public void ordenar()
	{
		Ordenar o=new Ordenar();
		o.ordenar(ct,array);
		System.out.println("Ordenado com Sucesso!");
	}
}
