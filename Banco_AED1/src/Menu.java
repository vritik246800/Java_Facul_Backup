
public class Menu 
{
	
	public Menu()
	{
		
	}
	public void menu()
	{
		byte op;
		
		Validar val=new Validar();
		TodosCliente tc=new TodosCliente();
		
		do
		{
			System.out.println("|===========================|");
			System.out.println("|            MENU           |");
			System.out.println("|---------------------------|");
			System.out.println("|1. Iniciar o Programa      |");
			System.out.println("|---------------------------|");
			System.out.println("|2. Nomes dos Programadores |");
			System.out.println("|---------------------------|");
			System.out.println("|3. Exit                    |");
			System.out.println("|===========================|\n");
			
			op=val.opcao();
			
			switch(op)
			{
				case 1:
					tc.todos();
					do
					{
						System.out.println("|===============================|");
						System.out.println("|1. Lista dos Clientes do Banco |");
						System.out.println("|-------------------------------|");
						System.out.println("|2. Consulta de Cliente         |");
						System.out.println("|-------------------------------|");
						System.out.println("|3. Deposito de Valor           |");
						System.out.println("|-------------------------------|");
						System.out.println("|4. Registo de cliente          |");
						System.out.println("|-------------------------------|");
						System.out.println("|5. Levantamento de dinheiro    |");
						System.out.println("|-------------------------------|");
						System.out.println("|6. Tranferencia de dinheiro    |");
						System.out.println("|-------------------------------|");
						System.out.println("|7. Return para menu !          |");
						System.out.println("|===============================|\n");
						
						op=val.opcao();
						switch(op)
						{
							case 1:
								System.out.println(tc);
								break;
							case 2:
								do
								{
									System.out.println("|================================|");
									System.out.println("|1. Gostaria de consultar saldo  |");
									System.out.println("|--------------------------------|");
									System.out.println("|2. Gostaria de trocar o seu PIN |");
									System.out.println("|--------------------------------|");
									System.out.println("|3. Return para opcao anterior   |");
									System.out.println("|================================|\n");
									
									op=val.opcao();
									switch(op)
									{
										case 1:
											tc.cosulta();
											break;
										case 2:
											tc.trocaPIN();
											break;
										case 3:
											break;
										default:
											System.out.println("|================|");
											System.out.println("|Opcao Invalida !|");
											System.out.println("|================|");
									}
								}while(op!=3);	
								break;
							case 3:
								tc.depositos();
								break;
							case 4:
								tc.registo();
								break;
							case 5:
								tc.levantamento();
								break;
							case 6:
								tc.transferencia();
								break;
							case 7:
								tc.records();
								tc.elOBJ();
								break;
							default:
								System.out.println("|================|");
								System.out.println("|Opcao Invalida !|");
								System.out.println("|================|");
						}
						
					}while(op!=7);
					break;
				case 2:
					System.out.println("|==============================================================|");
					System.out.println("|			Nomes dos Programadores		       |");
					System.out.println("|----------------|-----------------|-------------|-------------|");
					System.out.println("| Vritik Valabdas| Vicente Macuacua| Yasin Magno | Aashir Omar |");
					System.out.println("|----------------|-----------------|-------------|-------------|");
					System.out.println("|			Codico de Estudante	               |");
					System.out.println("|----------------|-----------------|-------------|-------------|");
					System.out.println("| 	20190025 |	 20240208  | 20240260 	 |    20240143 |");
					System.out.println("|==============================================================|");
					break;
				case 3:
					System.out.println("|=================================|");
					System.out.println("|===========    ===     ==========|");
					System.out.println("|==========      =       =========|");
					System.out.println("|==========              =========|");
					System.out.println("|===========           ===========|");
					System.out.println("|=============       =============|");
					System.out.println("|===   =========   ========   ====|");
					System.out.println("|==== =========== ========== =====|");
					System.out.println("|=================================|");
					System.out.println("|   \\ Obrigado por usar o ATM /   |");
					System.out.println("|=================================|");
					System.out.println("|===========    ===     ==========|");
					System.out.println("|==========      =       =========|");
					System.out.println("|==========              =========|");
					System.out.println("|===========           ===========|");
					System.out.println("|=============       =============|");
					System.out.println("|===   =========   ========   ====|");
					System.out.println("|==== =========== ========== =====|");
					System.out.println("|=================================|");
					break;
				default:
					System.out.println("|================|");
					System.out.println("|Opcao Invalida !|");
					System.out.println("|================|");
			}
		}while(op!=3);
	}
}
