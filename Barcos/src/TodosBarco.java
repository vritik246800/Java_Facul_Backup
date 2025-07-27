import java.io.*;
import java.util.*;


public class TodosBarco 
{
	private ArrayList array;
	private Visualizacao vis;
	private Validacao val;
	private Calculo cal;
	private Pesquisa pes;
	private Escrever esc;
	
	public TodosBarco()
	{
		array=new ArrayList();
		vis=new Visualizacao();
		val=new Validacao();
		cal=new Calculo();
		pes=new Pesquisa();
		esc=new Escrever();
		
	}
	public void todos()
	{
		String matricula,marca,linha;
		float peso;
		int qtyMarisco,nPescador,nContetor,qtyPassageiro;
		char tipo;
		StringTokenizer x;
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("Dados.txt"));
			linha=br.readLine();
			while(linha!=null)
			{
				x=new StringTokenizer(linha,";");
				matricula=x.nextToken();
				marca=x.nextToken();
				peso=Float.parseFloat(x.nextToken());
				tipo=(x.nextToken()).charAt(0);
				switch(tipo)
				{
					case 'P': case 'p':
						qtyMarisco=Integer.parseInt(x.nextToken());
						nPescador=Integer.parseInt(x.nextToken());
						criarOP(matricula,marca,peso,qtyMarisco,nPescador);
						break;
					case 'C': case 'c':
						nContetor=Integer.parseInt(x.nextToken());
						criarOC(matricula,marca,peso,nContetor);
						break;
					case 'R': case 'r':
						qtyPassageiro=Integer.parseInt(x.nextToken());
						criarOR(matricula,marca,peso,qtyPassageiro);
						break;	
				}
				linha=br.readLine();
			}
			br.close();
			
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de txt nao encontra !");
		}
		catch(NumberFormatException c)
		{
			System.out.println(c.getMessage());
		}
		catch(IOException v)
		{
			System.out.println(v.getMessage());
		}
		System.out.println("File lido com S !!");
	}
	public void criarOP(String matri,String marca,float peso,int qtyM,int nP)
	{
		Pesca b=new Pesca();
		
		b.setmatricula(matri);
		b.setmarca(marca);
		b.setpeso(peso);
		b.setqtyMarisco(qtyM);
		b.setnPescador(nP);
		
		array.add(b);
		
	}
	public void criarOC(String matricula,String marca,float peso,int nContetor)
	{
		Carga c=new Carga();
		
		c.setmatricula(matricula);
		c.setmarca(marca);
		c.setpeso(peso);
		c.setnContador(nContetor);
		
		array.add(c);
	}
	public void criarOR(String matricula,String marca,float peso,int nPassageiro)
	{
		Cruseiro c=new Cruseiro();
		
		c.setmatricula(matricula);
		c.setmarca(marca);
		c.setpeso(peso);
		c.setqtyPassageiro(nPassageiro);
		
		array.add(c);
		
	}
	public void ctT()
	{
		cal.ct(array);
	}
	public void vizarraypesca()
	{
		System.out.println(vis.arraypesca(array));
	}
	public void vizarraycarga()
	{
		System.out.println(vis.arraycarga(array));
	}
	public void vizarraycruz()
	{
		System.out.println(vis.arraycruz(array));
	}
	public void alterarQPass()
	{
		int pessoa,poz;
		String matricula;
		Barco pai;
		Cruseiro r;
		
		matricula=val.validarString("Introduz a Matricula(III-CCC): ","Marticula Invalida !! ");
		poz=pes.pesquisa(matricula,array);
		
		
		if(poz==-1)
			System.out.println("Nao existe o Barco !");
		else
		{
			pai=(Barco)array.get(poz);
			r=(Cruseiro)pai;
			pessoa=val.validarInt("Introduz numero Inteiro para quantidade de pessoa(>0): ","A quantidade de Invalida !!");
			r.setqtyPassageiro(pessoa);
			System.out.println("A quantide de pessoa para foi alterada com sucesso!\nCom numero de: "+pessoa+"\nCom a matricula: "+matricula);
			esc.alterarF(array,pessoa,poz);
		}
	}
	public void vp()
	{
		cal.vp(array);
	}
}









