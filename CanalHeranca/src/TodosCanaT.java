import java.util.*;
import java.io.*;

public class TodosCanaT 
{
	private ArrayList a;
	private Calculo cal;
	private Visualizacao vis;
	
	public TodosCanaT()
	{
		a=new ArrayList();
		cal=new Calculo();
		vis=new Visualizacao();	
	}
	public void todo()
	{
		String linha,titulo,paiO,apresentador,chefe,nDi,tProg;
		StringTokenizer st;
		float duracao,periodo;
		char tipo;
		int anoL,nCap,nTempo,nCapPT,dExib;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("Dados.txt"));
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				
				titulo=st.nextToken();
				duracao=Float.parseFloat(st.nextToken());
				periodo=Float.parseFloat(st.nextToken());
				
				tipo=(st.nextToken()).charAt(0);
				
				switch(tipo)
				{
					case 'L': case 'l':
						anoL=Integer.parseInt(st.nextToken());
						paiO=st.nextToken();
						tipo=(st.nextToken()).charAt(0);
						switch(tipo)
						{
							case 'S': case 's':
								nTempo=Integer.parseInt(st.nextToken());
								nCapPT=Integer.parseInt(st.nextToken());
								dExib=Integer.parseInt(st.nextToken());
								criarS(titulo,duracao,periodo,anoL,paiO,nTempo,nCapPT,dExib);
								break;
							case 'N': case 'n':
								nCap=Integer.parseInt(st.nextToken());
								criarN(titulo,duracao,periodo,anoL,paiO,nCap);
								break;
						}
						break;
					case 'I': case 'i':
						apresentador=st.nextToken();
						tipo=(st.nextToken()).charAt(0);
						switch(tipo)
						{
							case 'P': case 'p':
								nDi=st.nextToken();
								tProg=st.nextToken();
								criarP(titulo,duracao,periodo,nDi,tProg);
								break;
							case 'J': case 'j':
								chefe=st.nextToken();
								criarJ(titulo,duracao,periodo,apresentador,chefe);
								break;
						}
						break;
				}
				/*
				if(tipo =='L' || tipo == 'l')
				{
					
					tipo=(st.nextToken()).charAt(0);
					
					if(tipo=='s' || tipo=='S')
					{
						
					}
					else
					{
						if(tipo=='N' || tipo=='n')
						{
							
						}
					}
				}
				else
				{
					if(tipo=='i' || tipo=='I')
					{
						
						
						tipo=(st.nextToken()).charAt(0);
						
						if(tipo=='p' || tipo=='P')
						{
							
						}
						else
						{
							if(tipo=='J' || tipo=='j')
							{
								
							}
						}		
					}
				}*/
				
				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
			System.out.println("File de texto lido com sucesso !");
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de txt nao encontra !");
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
	
	public void remover()
	{
		int poz;
		Pesquisa pes=new Pesquisa();
		
		poz=pes.pesq(a);
		if(poz!=-1)
		{
			a.remove(poz);
			a.trimToSize();
		}
		else
			System.out.println("Dado nao existe !");
	}
	public void mediaDur()
	{
		float media;
		
		media=cal.media(a);
		
		System.out.println("A media de duracao sao: "+media);
		
	}
	public void list()
	{
		String s;
		
		s=vis.toString(a);
		
		System.out.println(s);
		
	}
	public void ctDI()
	{
		int ctI;
		
		ctI=Informativo.ctInformativo;
		
		System.out.println("O contador de Informativo: "+ctI);
	}
	public void salvarO()
	{
		CriarFO fo=new CriarFO();
		fo.saveO(a);
	}
	public void criarJ(String titulo,float duracao,float periodo,String apresentador,String chefe)
	{
		Jornal j=new Jornal();
		
		j.settitulo(titulo);
		j.setduracao(duracao);
		j.setperiodo(periodo);
		j.setapresentador(apresentador);
		j.setchefe(chefe);
		
		a.add(j);
	}
	public void criarN(String titulo,float duracao,float periodo,int anoL,String paiO,int nCap)
	{
		Novela n=new Novela();
		
		n.settitulo(titulo);
		n.setduracao(duracao);
		n.setperiodo(periodo);
		n.setanoL(anoL);
		n.setpaiO(paiO);
		n.setnCap(nCap);
		
		a.add(n);
	}
	public void criarP(String titulo,float duracao,float periodo,String nDi,String tProg)
	{
		Programa p=new Programa();
		
		p.settitulo(titulo);
		p.setduracao(duracao);
		p.setperiodo(periodo);
		p.setnDi(nDi);
		p.settProg(tProg);
		
		a.add(p);
	}
	public void criarS(String titulo,float duracao,float periodo,int anoL,String paiO,int nTempo,int nCapPT,int dExib)
	{
		Serie s=new Serie();
		
		s.settitulo(titulo);
		s.setduracao(duracao);
		s.setperiodo(periodo);
		s.setnTempo(nTempo);
		s.setnCapPT(nCapPT);
		s.setdExib(dExib);
		
		a.add(s);
	}
}
