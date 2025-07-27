import java.util.*;
import java.io.*;

public class TodosB 
{
	private ArrayList a;
	private Viz vis;
	private Cal cal;
	private Pesquisa pes;
	private Validar val;
	
	
	TodosB()
	{
		a=new ArrayList();
		vis=new Viz();
		cal=new Cal();
		pes=new Pesquisa();
		val=new Validar();
		
		
	}
	void todos()
	{
		int code,qtyC,qtyM;
		float valor,km,vP;
		String dataC,dataP,bi,nome,formaP,mt,tipoC,nomeC,tipoM,linha;
		char c;
		StringTokenizer st;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				
				code=Integer.parseInt(st.nextToken());
				valor=Float.parseFloat(st.nextToken());
				bi=st.nextToken();
				dataP=st.nextToken();
				dataC=st.nextToken();
				nome=st.nextToken();
				formaP=st.nextToken();
				c=(st.nextToken()).charAt(0);
				switch(c)
				{
					case 'T': case 't':
						km=Float.parseFloat(st.nextToken());
						c=(st.nextToken()).charAt(0);
						switch(c)
						{
							case 'c': case 'C':
								mt=st.nextToken();
								qtyC=Integer.parseInt(st.nextToken());
								vP=Float.parseFloat(st.nextToken());
								coC(code,valor,bi,dataP,dataC,nome,formaP,km,mt,qtyC,vP);
								break;
							case 'o': case 'O':
								tipoC=st.nextToken();
								coO(code,valor,bi,dataP,dataC,nome,formaP,km,tipoC);
								break;
						}
						break;
					case 'A': case 'a':
						qtyM=Integer.parseInt(st.nextToken());
						nomeC=st.nextToken();
						coA(code,valor,bi,dataP,dataC,nome,formaP,qtyM,nomeC);
						break;
					case 'M': case 'm':
						tipoM=st.nextToken();
						coM(code,valor,bi,dataP,dataC,nome,formaP,tipoM);
						break;
				}
				
				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
		}
		catch(FileNotFoundException a)
		{
			System.out.println("File de txt nao encontra !");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException v)
		{
			System.out.println(v.getMessage());
		}
		System.out.println("file lido com S !!");
	}
	void vizVML()
	{	
		int poz;
		poz=pes.verM(a);
		vis.vizM(poz);
	}
	void changeCODE()
	{
		int poz,code,qtyM;
		
		code=val.validarI("Introduz o code para alterar: ");
		poz=pes.pqC(a,code);
		qtyM=val.validarI("Introduz a quantidade de Milhas: ");
		vis.change(poz,a,qtyM);
	}
	void removeCODE()
	{
		int poz,code;
		
		code=val.validarI("Introduz o code para remover: ");
		poz=pes.pqC(a,code);
		vis.remove(poz,a);
	}
	void pesCODE()
	{
		int poz,code;
		
		code=val.validarI("Introduz o code para pesquisar: ");
		poz=pes.pqC(a,code);
		vis.pqC(poz,a);
	}
	void ac()
	{
		vis.vizac(cal.ac(a));
	}
	void ct()
	{
		System.out.println("A quantidade para cada tipo de bilheite sao:\nTerrestre: "+Terrestre.ctT+"\nAereo: "+Aereo.ctA+"\nMar: "+Mar.ctM);
	}
	void clOBJ()
	{
		File f=new File();
		f.criarObj(a);
		a=f.lerObj();
	}
	public String toString()
	{
		return vis.bilhete(a);
	}
	void coM(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,String tipoM)
	{
		Mar c=new Mar();
		
		c.setcode(code);
		c.setvalor(valor);
		c.setbi(bi);
		c.setdataP(dataP);
		c.setdataC(dataC);
		c.setnome(nome);
		c.setformaP(formaP);
		c.settipo(tipoM);
		
		a.add(c);
	}
	void coA(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,int qtyM,String nomeC)
	{
		Aereo c=new Aereo();
		
		c.setcode(code);
		c.setvalor(valor);
		c.setbi(bi);
		c.setdataP(dataP);
		c.setdataC(dataC);
		c.setnome(nome);
		c.setformaP(formaP);
		c.setqtyM(qtyM);
		c.setnomeC(nomeC);
		
		a.add(c);
	}
	void coO(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,float km,String tipoC)
	{
		Comboio c=new Comboio();
		
		c.setcode(code);
		c.setvalor(valor);
		c.setbi(bi);
		c.setdataP(dataP);
		c.setdataC(dataC);
		c.setnome(nome);
		c.setformaP(formaP);
		c.setkm(km);
		c.settipo(tipoC);
		
		a.add(c);
		
	}
	void coC(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,float km,String mt,int  qtyC,float vP)
	{
		Carro c=new Carro();
		
		c.setcode(code);
		c.setvalor(valor);
		c.setbi(bi);
		c.setdataP(dataP);
		c.setdataC(dataC);
		c.setnome(nome);
		c.setformaP(formaP);
		c.setkm(km);
		c.setmt(mt);
		c.setqtyC(qtyC);
		c.setvP(vP);
		
		a.add(c);
	}
}









