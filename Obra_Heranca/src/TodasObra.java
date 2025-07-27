import java.io.*;
import java.util.*;

public class TodasObra 
{
	private ArrayList a;
	private Visualizacao vis;
	private Calculo cal;
	private Validar val;
	
	TodasObra()
	{
		a=new ArrayList();
		vis=new Visualizacao();
		cal=new Calculo();
		val=new Validar();
		
		
	}
	void todo()
	{
		String linha,nomeEng,morada,piscina;
		float duracao;
		int km,metro2,nAndar;
		char tipo;
		StringTokenizer st;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				
				nomeEng=st.nextToken();
				duracao=Float.parseFloat(st.nextToken());
				tipo=(st.nextToken()).charAt(0);
				switch(tipo)
				{
					case 'H': case 'h':
						morada=st.nextToken();
						metro2=Integer.parseInt(st.nextToken());
						tipo=(st.nextToken()).charAt(0);
						switch(tipo)
						{
							case 'P' : case 'p' :
								nAndar=Integer.parseInt(st.nextToken());
								objP(nomeEng,duracao,morada,metro2,nAndar);
								break;
							case 'V': case 'v':
								piscina=st.nextToken();
								objV(nomeEng,duracao,morada,metro2,piscina);
								break;
						}
						break;
					case 'E': case 'e':
						km=Integer.parseInt(st.nextToken());
						objE(nomeEng,duracao,km);
						break;
				}
				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("Nao Existe File.txt");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("File lido com sucesso !!");
		
	}
	void objE(String nomeEng,float duracao,int km)
	{
		Estrada p=new Estrada();
		
		p.setnomeEng(nomeEng);
		p.setdurcao(duracao);
		p.setkm(km);
		
		a.add(p);
	}
	void objP(String nomeEng,float duracao,String morada,int metro2,int nAndar)
	{
		Predio p=new Predio();
		
		p.setnomeEng(nomeEng);
		p.setdurcao(duracao);
		p.setmorada(morada);
		p.setmetro2(metro2);
		p.setnAndar(nAndar);
		
		a.add(p);
	}
	void objV(String nomeEng,float duracao,String morada,int metro2,String piscina)
	{
		Vivenda p=new Vivenda();
		
		p.setnomeEng(nomeEng);
		p.setdurcao(duracao);
		p.setmorada(morada);
		p.setmetro2(metro2);
		p.setpiscina(piscina);
		
		a.add(p);
	}
	public String toString()
	{
		String s="";
		Obra pai;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Obra)a.get(i);
			s+=pai+"\n";
		}
		return s;
	}
	void pesquisa()
	{
		String nome;
		int poz;
		Pesquisa pes=new Pesquisa();
		nome=val.validarString(a);
		poz=pes.pesquisa(a,nome);
		vis.viznome(poz,a);
	}
	void vizct()
	{
		System.out.println("CT Estrada: "+Estrada.ctEstrada);
		System.out.println("CT Predio: "+Predio.ctPredio);
		System.out.println("CT Viveda: "+Vivenda.ctVivenda);
	}
	void ac()
	{
		float ac;
		ac=cal.ac(a);
		vis.ac(ac);
	}
	void menosT()
	{
		Obra menor;
		Obra ax;
		menor=(Obra)a.get(0);
		for(int i=1;i<a.size();i++)
		{
			ax=(Obra)a.get(i);
			if(menor.getduracao()>ax.getduracao())
				menor=ax;
				
		}
		System.out.println("O Enginheiro com tempo mais cuto e: "+menor.getnomeEng());
	}
	
	
}













