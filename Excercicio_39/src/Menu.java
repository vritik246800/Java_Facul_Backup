
public class Menu 
{
	private Validacao val;
	private TodosClientes t;
	public Menu()
	{
		val=new Validacao();
		t=new TodosClientes();
	}
	public void menu()
	{
		char op;
		boolean p=false;
		do
		{
			System.out.println("* * * * M E N U * * * *");
			System.out.println("a. Visualizar todos os dados no ecrã");
			System.out.println("b. Visualiar o valor total obtido e escrever num ficheiro de texto");
			System.out.println("c. Visualizar o valor total de desconto");
			System.out.println("d. Pesquisar um determinado cliente pelo código recebido pelo teclado");
			System.out.println("e. Visualizar quantos clientes existem de cada tipo");
			System.out.println("f. Visualizar qual tipo de corte rendeu mais ao salão");
			System.out.println("g. Escrever os dados no Ficheiro de Objectos");
			System.out.println("h. Ordenar o array de objectos pelo codigo na ordem crescente ");
			System.out.println("i. Exit");
			System.out.println("Introduz a opcao(a-i)");
			
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
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.escrever();
					}
					break;
				case 'c': case 'C':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.acD();
					}
					break;
				case 'd': case 'D':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.pesquisa();
					}
					break;
				case 'e': case 'E':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.ctTC();
					}
					break;
				case 'f': case 'F':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.ctTS();
					}
					break;
				case 'g': case 'G':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.gravarObj();
					}
					break;
				case 'h': case 'H':
					if(p==false)
						System.out.println("OPCAO BLOCK comece de (a || A) !");
					else
					{
						t.ordenar();
						System.out.println(t);
					}
					break;
				case 'i': case 'I':
					System.out.println("Obrigado por usar o programa!");
					break;
				default:
						System.out.println("Opcao Invalida!");
			}
			
		}while(op!='i' && op!='I');
	}
}
