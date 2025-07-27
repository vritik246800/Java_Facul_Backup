import java.util.*;
import java.io.*;
//NAO TERMINOU
public class TodasConta 
{
	private ArrayList a;
	private Calcular cal;
	private Visualizar vis;
	private File f;
	
	
	public TodasConta()
	{
		a=new ArrayList();
		cal=new Calcular();
		vis=new Visualizar();
		f=new File();
		
	}
	public void todos()
	{
		String nConta,dataA,nCartao,dataV,linha,nE;
		float saldo,vdf,vj,vs,vp;
		int nM;
		char c,tipo;
		StringTokenizer st;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				saldo=Float.parseFloat(st.nextToken());
				nConta=st.nextToken();
				dataA=st.nextToken();
				c=(st.nextToken()).charAt(0);
				switch(c)
				{
					case 'd': case 'D':
						tipo=(st.nextToken()).charAt(0);
						switch(tipo)
						{
							case 'c': case 'C':
								nCartao=st.nextToken();
								dataV=st.nextToken();
								cO(saldo,nConta,dataA,nCartao,dataV);
								break;
							case 'P': case 'p':
								vdf=Float.parseFloat(st.nextToken());
								vj=Float.parseFloat(st.nextToken());
								nM=Integer.parseInt(st.nextToken());
								pO(saldo,nConta,dataA,vdf,vj,nM);
								break;
						}
						break;
					case 's': case 'S':
						nE=st.nextToken();
						vs=Float.parseFloat(st.nextToken());
						vp=Float.parseFloat(st.nextToken());
						sO(saldo,nConta,dataA,nE,vs,vp);
						break;
				}	
			}
			a.trimToSize();
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println(" file de dados nao encontra");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException cc)
		{
			System.out.println(cc.getMessage());
		}
		System.out.println("File lido com sucesso !");
	}
	// NAO TERMINOU
	public void wct()
	{
		f.ct();
	}
	public void vizcada()
	{
		vis.vC(a);
		vis.vP(a);
		vis.vS(a);
	}
	public void wo()
	{
		f.wo(a);
	}
	public void acG()
	{
		float ac;
		ac=cal.acG(a);
		vis.acG(ac);
	}
	public void pO(float saldo,String nConta,String dataA,float vdf,float vj,int nM)
	{
		Poupanca p=new Poupanca();
		
		p.setsaldo(saldo);
		p.setnConta(nConta);
		p.setdataA(dataA);
		p.setvdf(vdf);
		p.setvj(vj);
		p.setnM(nM);
		
		a.add(p);
	}
	public void sO(float saldo,String nConta,String dataA,String nE,float vs,float vp)
	{
		Salario p=new Salario();
		
		p.setsaldo(saldo);
		p.setnConta(nConta);
		p.setdataA(dataA);
		p.setnE(nE);
		p.setvs(vs);
		p.setvp(vp);
		
		a.add(p);
	}
	public void cO(float saldo,String nConta,String dataA,String nCartao,String dataV)
	{
		Corrente p=new Corrente();
		
		p.setsaldo(saldo);
		p.setnConta(nConta);
		p.setdataA(dataA);
		p.setnCartao(nCartao);
		p.setdataV(dataV);
		
		a.add(p);
	}
	
}
