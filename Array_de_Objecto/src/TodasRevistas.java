import java.util.StringTokenizer; 
import java.io.*;
public class TodasRevistas
{ 
	// no array de objecto temos que criar um contador e por a 1-a class como array e dar como variavel
	private Revista [] array;
	private int ct;
	public TodasRevistas()
	{
		// declaras o array com no minimo de 100 espacos reservados
		array = new Revista[100];
		// e depois de criar o contador faz a iniciar a 0
		ct=0; 
	}
	public void lerFichCriarArray()
	{ 
		// o seccao de StringTokenizer seccao e String linha e pra converter e viz o dos do file
		StringTokenizer seccao;
		String linha=" ", nome;
		int qty; 
		float preco;
		try
		{
			FileReader fr = new FileReader("Dados.txt");
			BufferedReader br = new BufferedReader(fr);
			
			linha = br.readLine();
			
			while (linha != null)
			{ 
				System.out.println(linha);
				
				seccao = new StringTokenizer (linha,";");
				
				nome = seccao.nextToken();
				qty = Integer.parseInt(seccao.nextToken());
				preco = Float.parseFloat(seccao.nextToken());
				
				Revista r = new Revista(nome,qty,preco);
				
				array[ct] = r; 
				//ou lista[cont] = new Revista(nom,qde,pr);
				
				ct++;
				linha = br.readLine();
			}
			br.close();
		}
		catch (FileNotFoundException a)
		{ 
			System.out.println("Ficheiro nao encontrado!"); 
		}
		catch(NumberFormatException b)
		{ 
			System.out.println(b.getMessage()); 
		}
		catch (IOException c) 
		{
			System.out.println(c.getMessage()); 
		}
	}
	public float calcTotGlobal()
	{ 
		float soma = 0;
		for (int i = 0; i < ct; i++)
			soma += array[i].getTotal();
		return soma;
	}
	public void gravar()
	{ 
		try
		{ 
			FileWriter fw = new FileWriter("Out.txt");
			BufferedWriter br = new BufferedWriter(fw);
			for (int i = 0; i < ct; i++)
			{
				br.write(array[i].getNome());
				array[i].getTotal();
				br.newLine();
			}
			br.close();
		} 
		catch (IOException x) 
		{ 
			System.out.println(x.getMessage()); 
		}
		System.out.println ("O ficheiro de saida foi criado com nome ");
	}
	public String toString()
	{ 
		String x = "";
		for (int i = 0; i < ct; i++)
			x += array[i] + "\n"; //.toString() é opcional
		return x;
	}
}