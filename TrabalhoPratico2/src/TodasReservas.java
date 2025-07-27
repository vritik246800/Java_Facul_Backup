import java.util.*;
import java.io.*;

public class TodasReservas 
{
	private Visualisar vr;
	private Calculos cr;
	private Reserva [] array;
	private int ct;
	public TodasReservas()
	{
		array=new Reserva[100];
		ct=0;
		vr=new Visualisar();
		cr=new Calculos();
	}
	
	public void todas()
	{
		int d=0;
		String linha,numeroT,nomeC,tipoR,dataE,dataS,respPraia,respPisc;
		StringTokenizer seccao;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			linha=br.readLine();
			while(linha!=null)
			{	
				System.out.println("|======================|");
				System.out.println("| Dados do cliente: "+(d+1)+" |");
				
				seccao=new StringTokenizer(linha,";");
				
				numeroT=seccao.nextToken();
				nomeC=seccao.nextToken();
				tipoR=seccao.nextToken();
				dataE=seccao.nextToken();
				dataS=seccao.nextToken();
				respPraia=seccao.nextToken();
				respPisc=seccao.nextToken();				
				
				array[ct] = new Reserva(numeroT,nomeC,tipoR,dataE,dataS,respPraia,respPisc);
				ct++;
				
				d++;
				
				linha=br.readLine();
			}
			System.out.println("|=================================|");
			System.out.println("| Ficheiro lido com sucesso (-O-) |");
			System.out.println("|=================================|");
			
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("|==========================|");
			System.out.println("| Ficheiro nao encontra :( |");
			System.out.println("|==========================|");
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
	public void pesquisarR()
	{
		int x;
		
		Pesquisa p=new Pesquisa();
		
		x=p.pesquisar(ct,array);
		vr.vizP(x,array);
	}
	public void gravarObj()
	{
		GravarObj g=new GravarObj();
		g.gravarObj(array);
	}
	public String toString()
	{
		return vr.toString(ct,array);
	}
	public void vizTabelaValor()
	{
		vr.vizTabelaValor(ct,array);
	}
	public void vizQuantidadeTR()
	{
		int ctE,ctC,ctP,ctG;
		String p="Particular",e="Empresa",c="Casal     ",soma="O total das reservas";
		
		ctE=cr.vizQE(ct,array,e);
		ctC=cr.vizQE(ct,array,c);
		ctP=cr.vizQE(ct,array,p);
		ctG=cr.vizQT(ctE,ctC,ctP);
		
		vr.vizCTR(e,ctE,c,ctC,p,ctP,soma,ctG);
	}
	public void criarFicheiro()
	{
		float acEU,acEM,acCU,acCM,acPU,acPM;
		
		acEU=cr.acEmUSD(ct,array,"Empresa");
		acEM=cr.acEmMTS(ct,array,"Empresa");
		acCU=cr.acEmUSD(ct,array,"Casal     ");
		acCM=cr.acEmMTS(ct,array,"Casal     ");
		acPU=cr.acEmUSD(ct,array,"Particular");
		acPM=cr.acEmMTS(ct,array,"Particular");
		
		CriarFile cr=new CriarFile();
		cr.file(ct,array,acEU,acEM,acCU,acCM,acPU,acPM);
	}
	public void contadorDFeriado()
	{
		int ctF=cr.contadorDFeriado(ct,array);
		vr.vizctF(ctF);	
	}
	public void ordenar()
	{
		Ordenar o=new Ordenar();
		o.ordenar(ct,array);
	}
	public void bonus()
	{	
		Reserva rv=new Reserva();
		
		String numeroT,nomeC,tipoR,dataE,dataS,respPraia,respPisc;
		
        numeroT=rv.getnumeroT();
        nomeC=rv.getnomeC();
		tipoR=rv.gettipoR();
		dataE=rv.getdataE();
		dataS=rv.getdataS();
		respPraia=rv.getrespPraia();
		respPisc=rv.getrespPisc();
		
		CriarFile cr=new CriarFile();
		
		cr.bonus(numeroT,nomeC,tipoR,dataE,dataS,respPraia,respPisc);
	}
}