public class Menu
{ 
	private TodosEstudantes te;
	private Validacoes val;
	public Menu() 
	{ 
		te = new TodosEstudantes();
		val = new Validacoes();
	}
	public void apresentarMenu()
	{
		byte op = 0;
		do
		{
			System.out.println("***GESTAO-TURMA-MENU***");
			System.out.println("1. Adicionar estudante");
			System.out.println("2. Visualizar lista de estudantes");
			System.out.println("3. Ordenar estudantes");
			System.out.println("4. Sair do programa");
			
			op = val.validarByte(1,4,"Escolha uma opcao (1-4)");
			
			switch(op) 
			{ 
				case 1: 
					te.inserirEstudante(); 
					break;
				case 2: 
					System.out.println(te); 
					break;
				case 3: 
					te.Ordenar(); 
					break;
				case 4: 
					System.out.println("Obrigado!");
				default:
					System.out.println("Opcao invalido !");
			}
		}while(op != 4);
	}
} //FIM DA CLASSE MENU 