
public class Menu 
{
	private Validacao val;
	private TodosJogadores t;
	public Menu()
	{
		val=new Validacao();
		t=new TodosJogadores();
	}
	public void menu()
	{
		char op=' ';
		boolean p=false;
		
		do
		{
			System.out.println("                         |===========================|");
			System.out.println("                         | * * * * M E N U * * * * * |");
			System.out.println("|========================-----------------------------=======================|");
			System.out.println("| a/A | Ler os dados do ficheiro de texto                                    |");
			System.out.println("| b/B | Visualizar a quantidade de jogadores que apostam para cada desporto  |");
			System.out.println("| c/C | Visualizar o valor total ganho pelos jogadores                       |");
			System.out.println("| d/D | Visualizar o valor total perdido pelos jogadores                     |");
			System.out.println("| e/E | Visualizar o balanço da casa de apostas                              |");
			System.out.println("| f/F | Escrever no ficheiro de texto o valor do imposto e o code do jogador |");
			System.out.println("| g/G | Pesquisar um jogador pelo código                                     |");
			System.out.println("| h/H | Escrever os dados de um ficheiro de objectos                         |");
			System.out.println("| i/I | Ler os dados de um ficheiro de objectos                              |");
			System.out.println("| j/J | Ordenar os jogadores na ordem decrescente do valor                   |");
			System.out.println("| k/K | Nome do Programador                                                  |");
			System.out.println("| m/M | Sair do programa                                                     |");
			System.out.println("|============================================================================|");
			System.out.println("| Escolhe a opcao (a/A - i/I):                                               |");
			System.out.println("|============================================================================|");
			
			op=val.op();
			
			switch(op)
			{
				case 'a': case 'A':
					t.todos();
					System.out.println(t);
					p=true;
					break;
				case 'b': case 'B':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.ct();
					}
					break;
				case 'c': case 'C':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.acP();
					}
					break;
				case 'd': case 'D':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.acN();
					}
					break;
				case 'e': case 'E':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.balanco();
					}
					break;
				case 'f': case 'F':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.escrever();
					}
					break;
				case 'g': case 'G':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.pesquisa();
					}
					break;
				case 'h': case 'H':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.EscververOBJ();
					}
					break;
				case 'i': case 'I':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.LerOBJ();
					}
					break;
				case 'j': case 'J':
					if(p==false)
						System.out.println("A opcao bloquada tens que comecar da opca (A/a) ;) ");
					else
					{
						t.Ordenacao();
						System.out.println(t);
					}
					break;
				case 'k': case 'K':
					System.out.println("|=======================|\n| Nome: Vritik Valabdas |\n| Codigo: 20190025      |\n|=======================| \n;)");
					break;
				case 'm': case 'M':
					System.out.println("Obrigado por usar o Programa ! O ! ");
					break;
				default:
					System.out.println("O opcao Introduzida Invalida ! ! ");
					
			}
			
		}while(op!='m' && op!='M');
	}
}