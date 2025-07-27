import java.io.*;

public class Validacoes 
{
  private BufferedReader br;
  
  public Validacoes()
  {
	br = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public int validarInt(String msg)
  {
	int z=0;
	
	do
	{
      System.out.println(msg);
      try
      {
    	z = Integer.parseInt(br.readLine());
      }
      catch(NumberFormatException n)
      {
    	System.out.println(n.getMessage());
      }
      catch(IOException e)
      {
    	System.out.println(e.getMessage());
      }
      
      if(z<0)
        System.out.println("Erro!");
	} while(z<0);
	return z;
  }
  
  public String validarString(String a, String b, String msg)
  {
	String n="";

		
	do
	{
      System.out.println(msg);
	  try
	  {
	    n = br.readLine();
	  }
	  catch(IOException e)
	  {
	    System.out.println(e.getMessage());
	  }
	  if(!n.equalsIgnoreCase(a) && !n.equalsIgnoreCase(b))
	    System.out.println("Invalido!");
    } while(!n.equalsIgnoreCase(a) && !n.equalsIgnoreCase(b));
	return n;  
  }
  
  public int validarInt2(String msg)
  {
	int z=0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	do
	{
      System.out.println(msg);
      try
      {
    	z = Integer.parseInt(br.readLine());
      }
      catch(NumberFormatException n)
      {
    	System.out.println(n.getMessage());
      }
      catch(IOException e)
      {
    	System.out.println(e.getMessage());
      }
      
      if(z<=0)
        System.out.println("Erro!");
	} while(z<=0);
	return z;
  }
  
  public String validarString(String msg)
  {
	String n="";

	
	do
	{
      System.out.println(msg);
      try
      {
    	n = br.readLine();
      }
      catch(IOException e)
      {
    	System.out.println(e.getMessage());
      }
      if(n.length()<2)
    	System.out.println("Nome Invalido!");
	} while(n.length()<2);
	return n;
  }
  
  public int validarInt(int min, int max, String msg)
  {
	int z=0;

	
	do
	{
      System.out.println(msg);
      try
      {
    	z = Integer.parseInt(br.readLine());
      }
      catch(NumberFormatException n)
      {
    	System.out.println(n.getMessage());
      }
      catch(IOException e)
      {
    	System.out.println(e.getMessage());
      }
      
      if(z<min || z>max)
    	System.out.println("Erro!");
	} while(z<min || z>max);
	return z;
  }
}
