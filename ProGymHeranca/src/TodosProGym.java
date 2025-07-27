import java.util.*;
import java.io.*;

public class TodosProGym 
{
	private ArrayList a;
	private Visualizacao vis;
	
	public TodosProGym()
	{
		a=new ArrayList();
		vis=new Visualizacao();
		
	}
	public void todo()
	{
		String linha,nome,contacto,nomeE;
		int idade,code,contF;
		float peso;
		char tipo;
		StringTokenizer st;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("Dados.txt"));
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				
				nome=st.nextToken();
				idade=Integer.parseInt(st.nextToken());
				contacto=st.nextToken();
				peso=Float.parseFloat(st.nextToken());
				
				tipo=(st.nextToken()).charAt(0);
				switch(tipo)
				{
					case 'E': case 'e':
						nomeE=st.nextToken();
						code=Integer.parseInt(st.nextToken());
						criarE(nome,idade,contacto,peso,nomeE,code);
						break;
					case 'F': case 'f':
						contF=Integer.parseInt(st.nextToken());
						criarF(nome,idade,contacto,peso,contF);
						break;
				}
				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
			
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
		System.out.println("File de txt lido com Sucesso !");
	}
	public void criarF(String nome,int idade,String contacto,float peso,int contF)
	{
		Familia f=new Familia();
		
		f.setnome(nome);
		f.setidade(idade);
		f.setcontacto(contacto);
		f.setpeso(peso);
		f.setcontF(contF);
		
		a.add(f);
	}
	public void criarE(String nome,int idade,String contacto,float peso,String nomeE,int code)
	{
		Estudante e=new Estudante();
		
		e.setnomeE(nomeE);
		e.setidade(idade);
		e.setcontacto(contacto);
		e.setpeso(peso);
		e.setnomeE(nomeE);
		e.setcode(code);
		
		a.add(e);
	}
	public void ordenar()
	{
		Ordenar org=new Ordenar();
		org.selectionSort(a);
	}
	public void escreverO()
	{
		Escrever esc=new Escrever();
		esc.escreverO(a);
	}
	public void calculo()
	{
		float vf;
		Calculo cal=new Calculo();
		
		vf=cal.acF(a)+cal.acE(a);
		vis.total(vf);
	}
	public void remove()
	{
		int poz;
		String contacto;
		
		Pesquisa pes=new Pesquisa();
		Validar val=new Validar();
		
		contacto=val.contacto("Introduz do teclado o contacto(82|83|84|85|86|87| XXXXXXX): ");
		poz=pes.pesquisa(a,contacto);
		vis.remove(a,poz);
		
	}
	public void ct()
	{
		int ctF,ctPro,ctE;
		
		ctF=Familia.ctFamilia;
		ctE=Estudante.ctEstudante;
		ctPro=a.size();
		
		System.out.println("A quantidade de Familia sao: "+ctF+"\nA quantidade de Estudante sao: "+ctE);
		System.out.println("A quantidade total da ProGym: "+ctPro);
		
	}
	public void listEstudante()
	{
		String s="";
		
		s=vis.listEstudante(a);
		
		System.out.println("LISTAS ESTUDANTE\n"+s);
	}
	public void listFamilia()
	{
		String s="";
		
		s=vis.listFamilia(a);
		
		System.out.println("LISTAS FAMILIA\n"+s);
		
	}
	public void todalista()
	{
		String s;
		
		s=vis.toString(a);
		
		System.out.println("TODAS LISTAS\n"+s);
	}
}






