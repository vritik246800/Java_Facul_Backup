import java.io.*;
import java.util.*;

public class File 
{
	public File()
	{
		
	}
	public void wo(ArrayList a)
	{
		try
		{
			FileOutputStream fi=new FileOutputStream("Conta.dat");
			ObjectOutputStream oo=new ObjectOutputStream(fi);
			
			oo.writeObject(a);
			oo.close();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("O obj grava com S!");
	}
	public void ct()
	{
		try
		{
			FileWriter f=new FileWriter("dadosCT.txt");
			BufferedWriter bw=new BufferedWriter(f);
			
			bw.write("As quantidade sao: ");
			bw.newLine();
			bw.write("Corrente: "+Corrente.ctC);
			bw.newLine();
			bw.write("Poupanca: "+Poupanca.ctP);
			bw.newLine();
			bw.write("Salario: "+Salario.ctS);
			bw.newLine();
			bw.close();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
	}
}
