import java.io.*;
public class Menu
{
  public Menu() {}
  
  public void menu()
  {
	byte op = 0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	TodosPrisioneiros t = new TodosPrisioneiros();
	boolean passou = false;
	
	do
	{
	  System.out.println("   *** MENU *** ");
	  System.out.println("1. Ler do ficheiro");
	  System.out.println("2. Visualizar todos dados");
	  System.out.println("3. Valor total ");
	  System.out.println("4. Escrever ficheiro");
	  System.out.println("5. Sair do programa");
	  
	  try
	  {
	    op = Byte.parseByte(br.readLine());
	  }
	  catch(NumberFormatException n)
	  {
		System.out.println(n.getMessage());
	  }
	  catch(IOException e)
	  {
		System.out.println(e.getMessage());
	  }
	  
	  switch(op)
	  {
		case 1:
			t.lerDoFicheiro(); 
			passou = true;
			break;
		case 2:
			if(passou==false)
			  System.out.println("Executa a opcao 1 primeiro!");
		    else
			  System.out.println(t); break;
		case 3:
			if(passou==false)
				System.out.println("Executa a opcao 1 primeiro!");
			else
				t.adaptadorCalcularTotal(); break;
		case 4:
			if(passou==false)
				System.out.println("Executa a opcao 1 primeiro!");
			else
				t.adaptadorEscrever(); break;
		default: System.out.println("Erro!");
	  } 
	} while(op!=5);
  }
}