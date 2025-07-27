import java.util.*;
import java.io.*;

public class Tarefas 
{
	private ArrayList array;
	
	public Tarefas()
	{
		array=new ArrayList();
		
		
	}
	public void lerFichTxt()
	{
		String linha,nome,email;
		StringTokenizer seccao;
		char genero,criterio;
		byte idade,niv,htrab;
		float media;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader ("Info.txt"));
			linha=br.readLine();
			
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				nome=seccao.nextToken();
				email=seccao.nextToken();
				idade=Byte.parseByte(seccao.nextToken());
				genero=(seccao.nextToken()).charAt(0);
				criterio=(seccao.nextToken()).charAt(0);
				
				if(criterio == 'a' || criterio=='A')
				{
					niv=Byte.parseByte(seccao.nextToken());
					media=Float.parseFloat(seccao.nextToken());
					criarObjAluno(nome,email,idade,genero,niv,media);
				}
				else
				{
					if(criterio=='p' || criterio=='P')
					{
						htrab=Byte.parseByte(seccao.nextToken());
						criarObjProf(nome,email,idade,genero,htrab);
					}
				}
				
				linha=br.readLine();
			}
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
		System.out.println("ler file com S");
		
	}
	public void criarObjAluno(String n,String e,byte i,char g,byte ni,float m)
	{
		Aluno a=new Aluno();
		
		a.setNome(n);
		a.setEmail(e);
		a.setIdade(i);
		a.setGenero(g);
		a.setClasse(ni);
		a.setMedia(m);
		
		array.add(a);
		
	}
	public void criarObjProf(String n,String e,byte i,char g,byte h)
	{
		Professor p=new Professor();
		
		p.setNome(n);
		p.setEmail(e);
		p.setIdade(i);
		p.setGenero(g);
		p.setNumHora(h);
		
		array.add(p);
		
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<array.size();i++)
		{
			s+=array.get(i);
		}
		return s;
	}
	public String listaProf()
	{
		String ver="";
		
		UmIndividuo pai;
		Professor p;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(UmIndividuo)array.get(i);
			if(pai instanceof Professor)
			{
				p=(Professor) pai;
				ver+=p.toString();
			}
		}
		return ver;
	}
	public String listaAluno()
	{
		String s="";
		UmIndividuo x;
		Aluno a;
		
		for(int i=0;i<array.size();i++)
		{
			x=(UmIndividuo) array.get(i);
			if(x instanceof Aluno)
			{
				a=(Aluno) x;
				s+=a;
			}
		}
		return s;
	}
	public float calcMediaHoras()
	{
		float media=0;
		
		UmIndividuo pai;
		Professor prof;
		
		for(int i=0;i<array.size();i++)
		{
			pai=(UmIndividuo)array.get(i);
			if(pai instanceof Professor)
			{
				prof=(Professor)pai;
				media+=prof.getNumHora();
			}
		}
		return media/Professor.contProfessor;
	}
	
}





