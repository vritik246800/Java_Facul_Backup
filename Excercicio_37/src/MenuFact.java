import java.io.*;
public class MenuFact 
{
	private TodasFacturas tf;
	public MenuFact()
	{
		
	}
	public void menu()
	{
		String nome="Vritik Valabdas";
		int code=20190025;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char op=' ';
		boolean pass=false;
		do
		{
			System.out.println("|===========================================================================|");
			System.out.println("|                             *** M E N U ***                               |");
			System.out.println("|========|==================================================================|");
			System.out.println("|  (a|A) | Iniciar o processo da Factura                                    |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (b|B) | Visualizar dos dados das facturas                                |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (c|C) | Visualizar as quantidade de Cliente particular do bairro Central |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (d|D) | Visualizar o valor total de Imposto                              |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (e|E) | Escrever o fichero de texto o valor total da FIPAG SEM imposto   |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (f|F) | Pesquisar a factura usando CODE                                  |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (g|G) | Nome e Codigo do Programador                                     |");
			System.out.println("|--------|------------------------------------------------------------------|");
			System.out.println("|  (h|H) | Sair do programa                                                 |");
			System.out.println("|========|==================================================================|");
			System.out.println("|                Introduz a opcao de (a-f)                                  |");
			System.out.println("|===========================================================================|");
			try
			{
				op=br.readLine().charAt(0);
			}
			catch(NumberFormatException z)
			{
				System.out.println(z.getMessage());
			}
			catch(IOException x)
			{
				System.out.println(x.getMessage());
			}
			switch(op)
			{
				case 'a': case 'A':
					tf=new TodasFacturas();// pra validar o N
					tf.todos();// pra comecar a contar
					pass=true;
					break;
				case 'b': case 'B':
					if(pass==false)
					{
						System.out.println("|===================================|");
						System.out.println("| Opcao bloqueada comece de (A-a)!  |");
						System.out.println("|===================================|");
					}
					else
						System.out.println(tf);
					break;
				case 'c': case 'C':
					if(pass==false)
					{
						System.out.println("|===================================|");
						System.out.println("| Opcao bloqueada comece de (A-a)!  |");
						System.out.println("|===================================|");
					}
					else
						tf.ctP();
					break;
				case 'd': case 'D':
					if(pass==false)
					{
						System.out.println("|===================================|");
						System.out.println("| Opcao bloqueada comece de (A-a)!  |");
						System.out.println("|===================================|");
					}
					else
						tf.acCI();
					break;
				case 'e': case 'E':
					if(pass==false)
					{
						System.out.println("|===================================|");
						System.out.println("| Opcao bloqueada comece de (A-a)!  |");
						System.out.println("|===================================|");
					}
					else
						tf.criarFile();
					break;
				case 'f': case 'F':
					if(pass==false)
					{
						System.out.println("|===================================|");
						System.out.println("| Opcao bloqueada comece de (A-a)!  |");
						System.out.println("|===================================|");
					}
					else
						tf.selectFac();
					break;
				case 'g': case 'G':
					System.out.println("|===============================================|");
					System.out.println("|	Do Programador	|	Code		|");
					System.out.println("|===============================================|");
					System.out.printf("|%20s   |%15d        |\n",nome,code);
					System.out.println("|===============================================|");
					break;
				case 'h': case 'H':
					System.out.println("|=================================================|");
					System.out.println("| (Obrigado || Obrigada )por usar o meu Progarama |");
					System.out.println("|=================================================|");
					//System.exit(0);
					break;
				default:
					System.out.println("|==================|");
					System.out.println("| Opcao Invalida!! |");
					System.out.println("|==================|");
			}
		}while(op!='h' && op!='H');
	}
}