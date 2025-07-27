
public class Menu 
{
	public Menu()
	{
		
	}
	public void menu()
	{
		TodosCliente t=new TodosCliente();
		Validacao val=new Validacao();
		
		byte op;
		
		do
		{
			System.out.println("|-------------------------------|");
			System.out.println("|*-*-*-* BeForward Mz -*-*-*-*-*|");
			System.out.println("|-------------------------------|\n");
			System.out.println("|--------------------------|");
			System.out.println("|*-*-*-* M E N U -*-*-*-*-*|");
			System.out.println("|--------------------------|");
			System.out.println("|1. Iniciar o programa     |");
			System.out.println("|--------------------------|");
			System.out.println("|2. Nome dos Programadores |");
			System.out.println("|--------------------------|");
			System.out.println("|3. Sair do Programa       |");
			op=val.validarOpcao("|  Introduz a Opcao (1-3)  |","|--------------------------|");
			switch(op)
			{
				case 1:
					t.todos();
					do
					{
						System.out.println("|---------------------------------------------------------|");
						System.out.println("|*-*-*-*-*-*-*-*-*-*-*- S U B - M E N U *-*-*-*-*-*-*-*-*-|");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 1. Visualizar a quantidade de tido de cliente           |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 2. Visualizar todos clientes da BeForward MZ            |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 3. Visualizar o valor total                             |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 4. Escrever e ler ficheito de Objecto                   |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 5. Pesquisar por nome e codigo do cliente               |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 6. Ver compras efectuadas no dia da Mulher Mocambicanas |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 7. A situacao da empresa BeForward Mz                   |");
						System.out.println("|---------------------------------------------------------|");
						System.out.println("| 8. Retorna para o menu                                  |");
						op=val.validarOpcao("|                Introduz a Opcao (1-8)                   |","|---------------------------------------------------------|");
						
						switch(op)
						{
							case 1:
								t.CT_de_cada_cliente();
								break;
							case 2:
								do
								{
									System.out.println("|----------------------------------|");
									System.out.println("|*-*-*-*-*- S U B - M E N U *-*-*-*|");
									System.out.println("|----------------------------------|");
									System.out.println("| 1. Visualiza todos os Clientes   |");
									System.out.println("|----------------------------------|");
									System.out.println("| 2. Visualiza todos Doutorados    |");
									System.out.println("|----------------------------------|");
									System.out.println("| 3. Visualiza todos Normal        |");
									System.out.println("|----------------------------------|");
									System.out.println("| 4. Visualiza todos Revendedor    |");
									System.out.println("|----------------------------------|");
									System.out.println("| 5. Visualiza todos Estado        |");
									System.out.println("|----------------------------------|");
									System.out.println("| 6. Retornar para o menu anterior |");
									System.out.println("|----------------------------------|");
									op=val.validarOpcao("|     Introduz a Opcao (1-6)       |","|----------------------------------|");
									
									switch(op)
									{
										case 1:
											t.visualizar_todos();
											break;
										case 2:
											t.visualizar_Doutorado();
											break;
										case 3:
											t.visualizar_Normal();
											break;
										case 4:
											t.visualizar_Revendedor();
											break;
										case 5:
											t.visualizar_Estado();
											break;
										case 6:
											System.out.println("|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|");
											break;
										default:
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
									}
									
								}while(op!=6);
								
								break;
							case 3:
								do
								{
									System.out.println("|-----------------------------------------------|");
									System.out.println("|*-*-*-*-*-*-*-*- S U B - M E N U *-*-*-*-*-*-*-|");
									System.out.println("|-----------------------------------------------|");
									System.out.println("| 1. Visualizar o valor total ganho pela empresa|");
									System.out.println("|-----------------------------------------------|");
									System.out.println("| 2. Visualizar o valor total pago em direitos  |");
									System.out.println("|-----------------------------------------------|");
									System.out.println("| 3. Retornar para o menu                       |");
									System.out.println("|-----------------------------------------------|");
									op=val.validarOpcao("|            Introduz a Opcao (1-3)             |","|-----------------------------------------------|");
									
									switch(op)
									{
										case 1:
											t.acumulador_com_todosIT();
											break;
										case 2:
											t.acumulador_direitos_adoaneiro();
											break;
										case 3:
											System.out.println("|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|");
											break;
										default:
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
									}
								}while(op!=3);
								break;
							case 4:
								do
								{
									System.out.println("|-----------------------------------|");
									System.out.println("|*-*-*-*-*-* S U B - M E N U *-*-*-*|");
									System.out.println("|-----------------------------------|");
									System.out.println("| 1. Escrever o ficheiro de objecto |");
									System.out.println("|-----------------------------------|");
									System.out.println("| 2. Ler ficheiro de objecto        |");
									System.out.println("|-----------------------------------|");
									System.out.println("| 3. Retornar para o menu           |");
									System.out.println("|-----------------------------------|");
									op=val.validarOpcao("|      Introduz a Opcao (1-3)       |","|-----------------------------------|");
									
									switch(op)
									{
										case 1:
											t.escrever_Objecto();
											break;
										case 2:
											t.ler_Objecto();
											break;
										case 3:
											System.out.println("|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|");
											break;
										default:
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
									}
								}while(op!=3);
								break;
							case 5:
								t.pesquisa_nome_codigo();
								break;
							case 6:
								t.visualizar_Compra_MulherMoz();
								break;
							case 7:
								t.situcao_Empreza(); 
								break;
							case 8:
								System.out.println("|--------|");
								System.out.println("| <<--<< |");
								System.out.println("|--------|");
								break;
							default:
								System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
								System.out.println("| A opcao invalida tente novamente! |");
								System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
						}
					}while(op!=8);
					break;
				case 2:
					System.out.println("|================================================|");
					System.out.println("|		Nomes dos Programadores		 |");
					System.out.println("|----------------|-----------------|-------------|");
					System.out.println("| Vritik Valabdas| Vicente Macuacua| Yasin Magno |");
					System.out.println("|----------------|-----------------|-------------|");
					System.out.println("|		Codico de Estudante		 |");
					System.out.println("|----------------|-----------------|-------------|");
					System.out.println("| 	20190025 |	 20240208  | 20240260 	 |");
					System.out.println("|================================================|");
					break;
				case 3:
					System.out.println("|======================================|");
					System.out.println("|==============    ===     ============|");
					System.out.println("|=============      =       ===========|");
					System.out.println("|=============              ===========|");
					System.out.println("|==============           =============|");
					System.out.println("|================       ===============|");
					System.out.println("|======   =========   ========   ======|");
					System.out.println("|======= =========== ========== =======|");
					System.out.println("|======================================|");
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
					System.out.println("| Obrigado por usar o nosso programa ! |");
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
					System.out.println("|======================================|");
					System.out.println("|==============    ===     ============|");
					System.out.println("|=============      =       ===========|");
					System.out.println("|=============              ===========|");
					System.out.println("|==============           =============|");
					System.out.println("|================       ===============|");
					System.out.println("|======   =========   ========   ======|");
					System.out.println("|======= =========== ========== =======|");
					System.out.println("|======================================|");
					break;
				default:
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
					System.out.println("| A opcao invalida tente novamente! |");
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
			}
		}while(op!=3);
	}
}
