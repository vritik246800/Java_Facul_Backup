import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CriarFile 
{
	private DecimalFormat m;
	private NumberFormat u;
	public CriarFile()
	{
		m=new DecimalFormat("###,###,###.00 Mts");
		u= NumberFormat.getCurrencyInstance(Locale.US);
	}
	public void file(int ct,Reserva [] array,float acEU,float acEM,float acCU,float acCM,float acPU,float acPM)
	{
		try
		{
			FileWriter fr=new FileWriter("OutPut.txt");
			BufferedWriter br=new BufferedWriter(fr);
			br.write("|===========================================|");
			br.newLine();
			br.write("|   O valor total em cada tipo de reserva   | ");
			br.newLine();
			br.write("|===========================================|");
			br.newLine();
			br.write("|                   Empresa                 |");
			br.newLine();
			br.write("|-------------------------------------------|");
			br.newLine();
			br.write("|    USD   |  "+u.format(acEU));
			br.newLine();
			br.write("| Meticais |  "+m.format(acEM));
			br.newLine();
			br.write("|===========================================|");
			br.newLine();
			br.write("|                    Casal                  |");
			br.newLine();
			br.write("|-------------------------------------------|");
			br.newLine();
			br.write("|    USD   |  "+u.format(acCU));
			br.newLine();
			br.write("| Meticais |  "+m.format(acCM));
			br.newLine();
			br.write("|===========================================|");
			br.newLine();
			br.write("|                  Particular               |");
			br.newLine();
			br.write("|-------------------------------------------|");
			br.newLine();
			br.write("|    USD   |  "+u.format(acPU));
			br.newLine();
			br.write("| Meticais |  "+m.format(acPM));
			br.newLine();
			br.write("|===========================================|");
			br.newLine();
			br.write(";)");
			br.close();
		}
		catch(NumberFormatException z)
		{
			System.out.println(z.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("|============================================|");
		System.out.println("| Ficheiro de texto escrito com sucesso ! ;} |");
		System.out.println("|============================================|");
	}
	public void bonus(String numeroT,String nomeC,String tipoR,String dataE,String dataS,String respPraia,String respPisc)
	{	
		String linha;
		boolean n=false;
	    try
	    {
	        FileReader fr=new FileReader("Dados.txt");
	        BufferedReader br=new BufferedReader(fr);
	        
	        linha=br.readLine();
	        
	        while(n==false)
	        {
	        	if(linha==null)
		        {
	        		FileWriter fw=new FileWriter("Dados.txt",true);
	    	        BufferedWriter bw=new BufferedWriter(fw);
			        bw.write(numeroT+";"+nomeC+";"+tipoR+";"+dataE+";"+dataS+";"+respPraia+";"+respPisc);
			        bw.newLine();
			        bw.close();
			        n=true;
		        }
	        	linha=br.readLine();
	        }
	        br.close();
	    }
	    catch(FileNotFoundException z)
	    {
	    	System.out.println(z.getMessage());
	    }
	    catch(IOException x)
	    {
	    	System.out.println(x.getMessage());
	    }
	    System.out.println("|===========================================|");
	    System.out.println("| Novo registo de Ficheiro de texto feito ! |");
	    System.out.println("|===========================================|");
	}
}