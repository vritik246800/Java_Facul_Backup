
public class Menu 
{
	private Validacoes val;
	private TodosIndividuos todos;
	public Menu()
	{
		val = new Validacoes();
		todos = new TodosIndividuos();
	}
	public void menu()
	{
		byte opcao, opcao1, opcao2;
		boolean chave=false; //chave das opcoes
		do
		{
			System.out.println("||=======================|MENU|=======================||");
			System.out.println("|1. Ver Estatisticas e dados dos Autos                 |");
			System.out.println("|------------------------------------------------------|");
			System.out.println("|2. Introduzir Novo Auto de Ocorrencia                 |");
			System.out.println("|------------------------------------------------------|");
			System.out.println("|3. Sair do Sistema                                    |");
			System.out.println("|------------------------------------------------------|");
			opcao = val.validarOpcao("| Seleciona a opcao acima |\n|------------------------------------------------------|", (byte) 1,(byte) 3);
			
			switch(opcao)
			{
				case 1:
					do
					{
						System.out.println("||=======================|SUB-MENU|=======================||");
						System.out.println("1. Ler o ficheiro de texto");
						System.out.println("2. Ver todos os dados");
						System.out.println("3. Sair do sistema");
						opcao1 = val.validarOpcao("| Seleciona a opcao acima |", (byte) 1, (byte)3);
						switch(opcao1)
						{
							case 1:
								chave = true;
								todos.lerDados();
								break;
							case 2:
								if(chave)
									todos.adaptarVerTodosDados();
								else
									System.out.println("Leia o ficheiro de texto Primeiro ou Insere novos dados");
								break;
						}
					}while(opcao1!=3);//Ainda nao e definitivo
					break;
				case 2:
					chave = true;
					todos.novaDenucia();
					break;
					
			}
		}
		while(opcao!=3);
	}

}
