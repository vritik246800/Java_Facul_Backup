
public class Menu
{
	public Menu()
	{
		
	}
	public void menu()
	{
		byte op;
		
		TodosBarco t=new TodosBarco();
		Validacao val=new Validacao();
		
		do
		{
			System.out.println("           | MENU |");
			System.out.println("1. Inciar o programa");
			System.out.println("2. Nome do Programador");
			System.out.println("3. Exit");
			op=val.validarByte("Escolhe a opcao acima(1-3): ");
			switch(op)
			{
				case 1:
					t.todos();
					do
					{
						System.out.println("\n1. Visualizar as quantidade por cada Barco");
						System.out.println("2. Visualizar a lista por cada BarcoS");
						System.out.println("3. Alterar e Visualizar quantidade de Passageiro do Cruseiro");
						System.out.println("4. Visualizar os valor a pagar pelos Barcos");
						System.out.println("5. Back para main menu");
						op=val.validarByte("Escolhe a opcao acima(1-5): ");
						switch(op)
						{
							case 1:
								t.ctT();
								break;
							case 2:
								t.vizarraypesca();
								t.vizarraycarga();
								t.vizarraycruz();
								break;
							case 3:
								t.alterarQPass();
								break;
							case 4:
								t.vp();
								break;
							case 5:
								System.out.println("<-");
								break;
							default:
								System.out.println("A opcao invalida!");
						}
					}while(op!=5);
					break;
				case 2:
					System.out.println("Nome: Vritik Valabdas\nCode: 20190025");
					break;
				case 3:
					System.out.println("Obrigado por usar o programa !");
					break;
				default:
					System.out.println("Opcao Invalida !");
			}
		}while(op!=3);
		
	}
}
