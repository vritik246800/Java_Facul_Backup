import java.io.*;

public class Menu
{
  private Validacoes val;
  
  public Menu()
  {
	val = new Validacoes();  
  }
  
  public void menu()
  {
	int n,op;
	
	TodasFacturas t = null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	do
	{
	  System.out.println("   *** MENU *** ");
	  System.out.println("1. Receber o N ");
	  System.out.println("2. Receber os dados");
	  System.out.println("3. Visualizar os dados");
	  System.out.println("4. Clientes particulares no bairro central");
	  System.out.println("5. Total de impostos");
	  System.out.println("6. Escrever no ficheiro");
	  System.out.println("7. Pesquisar factura");
	  System.out.println("8. Sair do programa");
	  
	  op =val.validarInt(1, 8, "Introduza a opcao(1-8):");
	  
	  switch(op)
	  {
		case 1:
			n = val.validarInt2("Introduza o numero de clientes(>0):");
			t = new TodasFacturas(n);
			break;
		case 2:
		    t.receberDados();
			break;
		case 3:
		    System.out.println(t);
			break;
		case 4:
		    t.adapPartiCentral();
			break;
		case 5:
		    t.adapTotImp();
			break;
		case 6:
		    t.adapEscreverFicheiro();
		    break;
		case 7:
		    t.adapPesquisa();
			break;
	  }
	} while(op!=8);
  }
}