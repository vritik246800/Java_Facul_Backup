import java.io.*;
import java.io.InputStreamReader;

public class SelectFact 
{
	public SelectFact()
	{
		
	}
	public void pesquisar(int code,int ct,Factura [] array)
	{
		boolean find=false;
		for(int i=0;i<ct && find==false ;i++)
		{
			find=true;
			System.out.println(array[i]);
		}
	}
	public int selectF()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int op=0;
		do
		{
			System.out.println("Introduz o Code da Factura(1011-2011): ");
			try
			{
				op=Integer.parseInt(br.readLine());
				if(op<1011 || op>2011)
					System.out.println("ERRO!");
			}
			catch(NumberFormatException z)
			{
				System.out.println(z.getMessage());
			}
			catch(IOException x)
			{
				System.out.println(x.getMessage());
			}
		}while(op<1011 || op>2011);
		return op;
	}
}