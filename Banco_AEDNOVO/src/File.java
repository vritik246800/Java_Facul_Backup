import java.io.*;

public class File 
{

	
	public File()
	{
		
	}
	public void historia(Cliente [] a, int cont, float novoBalanco,int poz)
	{
		try
		{
			FileWriter fw = new FileWriter("Dados.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
	    
			for(int i = 0; i<cont; i++)
			{
				bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+novoBalanco);
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException i)
		{
			System.out.println(i.getMessage());
		}
	}
	public void escreverR(String historia)
	{
		try
		{
			FileWriter fw=new FileWriter("historia.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write(historia);
			bw.newLine();
			bw.close();
			
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
	}
	public void actualizarPIN(Cliente [] array,int ct,int poz,int pin)
	{
		try
		{
			FileWriter fw = new FileWriter("Dados.txt");
		    BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0;i<ct;i++)
			{
				if(poz==i)
				{
					bw.write(array[i].getnome()+";"+array[i].getsex()+";"+array[i].getidade()+";"+array[i].getnumeroC()+";"+pin+";"+array[i].getvalorD());
					bw.newLine();
				}
				else
				{
					bw.write(array[i].getnome()+";"+array[i].getsex()+";"+array[i].getidade()+";"+array[i].getnumeroC()+";"+array[i].getpin()+";"+array[i].getvalorD());
					bw.newLine();
				}
			}
			bw.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		System.out.println("|==========================|");
		System.out.println("| PIN trocado com sucesso !|");
		System.out.println("|==========================|\n");
	}
	public void actualizarFile(Cliente [] a, int cont, float novoBalanco,int poz)
	{
	  try
	  {
	    FileWriter fw = new FileWriter("Dados.txt");
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    for(int i = 0; i<cont; i++)
	    {
	    	if(poz==i)
	    	{
	    		bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+a[i].getpin()+";"+novoBalanco);
	    		bw.newLine();
	    	}
	    	else
	    	{
	    		bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+a[i].getpin()+";"+a[i].getvalorD());
	    		bw.newLine();
	    	}
	    }
	    bw.close();
	  }
	  catch(IOException i)
	  {
		System.out.println(i.getMessage());
	  }
	}
	public void actualizarFileT(Cliente [] a, int cont,int poz,int poz1,float valorN)
	{
		float vn=0,vn1=0;
		vn=a[poz1].getvalorD()+valorN;
		vn1=a[poz].getvalorD()-valorN;
		try
		  {
				FileWriter fw = new FileWriter("Dados.txt");
				BufferedWriter bw = new BufferedWriter(fw);
		    
				for(int i = 0; i<cont; i++)
				{	
					if(poz1==i)
					{
						bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+a[i].getpin()+";"+vn);
						bw.newLine();
					}
					else if(poz==i)
					{
						bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+a[i].getpin()+";"+vn1);
						bw.newLine();
					}
					else
					{
						bw.write(a[i].getnome()+";"+a[i].getsex()+";"+a[i].getidade()+";"+a[i].getnumeroC()+";"+a[i].getpin()+";"+a[i].getvalorD());
						bw.newLine();
					}
				}
				bw.close();
		  }
		  catch(IOException i)
		  {
			System.out.println(i.getMessage());
		  }
	}
	
	public void novoR(String nome,String sex,int idade,int numeroC,int pin,float valorD)
	{
		try
		{
			FileWriter fw=new FileWriter("Dados.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write(nome+";"+sex+";"+idade+";"+numeroC+";"+pin+";"+valorD);
			bw.newLine();
			bw.close();
		}
		catch(IOException z)
		{
			System.out.println(z.getMessage());
		}
		
	}
	public void valorA(int poz,Cliente [] array,float va)
	{	
		String linha;
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter("Dados.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			linha=br.readLine();
			while(linha!=null)
			{
				if(!linha.equals(array[poz].getnome()+";"+array[poz].getsex()+";"+array[poz].getidade()+";"+array[poz].getnumeroC()+";"+array[poz].getvalorD()))
				{
					//linha=br.readLine().bw.write(.....);
					bw.write(array[poz].getnome()+";"+array[poz].getsex()+";"+array[poz].getidade()+";"+array[poz].getnumeroC()+";"+va);
					bw.newLine();
					bw.close();
				}
				linha=br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("O file de txt nao encontra !");
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
	}
}
