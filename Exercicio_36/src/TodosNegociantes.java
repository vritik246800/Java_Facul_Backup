import java.io.*;
import java.util.*;
public class TodosNegociantes 
{
	private Negociante [] array;
	private CalculosNeg cal;
	private VizNeg vn;
	private int ct;
	public TodosNegociantes()
	{
		array=new Negociante[100];
		ct=0;
		cal=new CalculosNeg();
		vn=new VizNeg();
	}
	public void todos()
	{
		StringTokenizer seccao;
		String linha,nome,tipoO;
		int v;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				nome=seccao.nextToken();
				tipoO=seccao.nextToken();
				v=Integer.parseInt(seccao.nextToken());
				
				Negociante n=new Negociante(nome,tipoO,v);
				// para criar a lista em forma de array
				array[ct]=n;
				// para ter a pocibilidade de ter varias linhas na lista
				ct++;
				
				linha=br.readLine();
			}
			System.out.println("File Lido com Sucesso!!");
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de dados nao encontra!!");
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
	public void criarFile()
	{
		CriarFile cf=new CriarFile();
		cf.criarFile(cal.ac(ct,array));
	}
	public void ac10()
	{
		float ac10;
		ac10=cal.ac10(ct, array);
		vn.vizac10(ac10);
	}
	public void contador()
	{
		int v,c;
		v=cal.contar(ct, array,"Venda");
		c=cal.contar(ct,array,"Compra");
		vn.vizV(v);
		vn.vizC(c);
	}
	public String toString()
	{
		return vn.toString(ct,array);
	}
}