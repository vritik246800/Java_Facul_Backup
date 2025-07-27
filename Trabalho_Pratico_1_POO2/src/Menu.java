
public class Menu 
{
	public Menu()
	{
		
	}
	public static final String AMA = "\u001B[33m";
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String VER = "\u001B[32m";
	public static final String AZ = "\u001B[36m";
	public static final String ROSE = "\u001B[35m";
	
	public void menu()
	{
		TodosCliente t=new TodosCliente();
		Validacao val=new Validacao();
		
		byte op;
		
		do
		{
			System.out.println(ROSE+"|-------------------------------|"+RESET);
			System.out.println(AMA+"|*-*-*-* BeForward Mz -*-*-*-*-*|"+RESET);
			System.out.println(ROSE+"|-------------------------------|\n"+RESET);
			System.out.println(AZ+"|--------------------------|");
			System.out.println("|*-*-*-*"+VER+" M E N U "+AZ+"-*-*-*-*-*|");
			System.out.println("|--------------------------|");
			System.out.println("|1. Iniciar o programa     |");
			System.out.println("|--------------------------|");
			System.out.println("|2. Nome dos Programadores |");
			System.out.println("|--------------------------|");
			System.out.println("|3."+RED+" Sair do Programa       "+AZ+"|");
			op=val.validarOpcao(AZ+"|  "+AMA+"Introduz a Opcao (1-3)"+AZ+"  |",AZ+"|--------------------------|"+RESET);
			switch(op)
			{
				case 1:
					t.todos();
					do
					{
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(AZ+"|*-*-*-*-*-*-*-*-*-*-"+RESET+" S U B - M E N U "+AZ+"*-*-*-*-*-*-*-*-*-*-|");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 1. Visualizar a quantidade de tido de cliente           |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 2. Visualizar todos clientes da BeForward MZ            |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 3. Visualizar o valor total                             |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 4. Escrever e ler ficheito de Objecto                   |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 5. Pesquisar por nome e codigo do cliente               |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 6. Ver compras efectuadas no dia da Mulher Mocambicanas |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 7. A situacao da empresa BeForward Mz                   |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(ROSE+"| 8. Remover cliente( B O N U S )                         |");
						System.out.println(AMA+"|---------------------------------------------------------|"+RESET);
						System.out.println(RED+"| 9. Retorna para o menu                                  |");
						op=val.validarOpcao(ROSE+"|                Introduz a Opcao (1-9)                   |",AMA+"|---------------------------------------------------------|"+RESET);
						
						switch(op)
						{
							case 1:
								t.CT_de_cada_cliente();
								break;
							case 2:
								do
								{
									System.out.println(AMA+"|----------------------------------|"+RESET);
									System.out.println(AZ+"|*-*-*-*-*- S U B - M E N U *-*-*-*|");
									System.out.println(AMA+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 1. Visualiza todos os Clientes   |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 2. Visualiza todos Doutorados    |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 3. Visualiza todos Normal        |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 4. Visualiza todos Revendedor    |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 5. Visualiza todos Estado        |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									System.out.println(VER+"| 6. Retornar para o menu anterior |");
									System.out.println(AZ+"|----------------------------------|"+RESET);
									op=val.validarOpcao(VER+"|     Introduz a Opcao (1-6)       |","|----------------------------------|"+RESET);
									
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
											System.out.println(RED+"|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|"+RESET);
											break;
										default:
											System.out.println(RED+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|"+RESET);
									}
									
								}while(op!=6);
								
								break;
							case 3:
								do
								{
									System.out.println(ROSE+"|-----------------------------------------------|");
									System.out.println(AMA+"|*-*-*-*-*-*-*-*- S U B - M E N U *-*-*-*-*-*-*-|");
									System.out.println(ROSE+"|-----------------------------------------------|");
									System.out.println(AMA+"| 1. Visualizar o valor total ganho pela empresa|");
									System.out.println(ROSE+"|-----------------------------------------------|");
									System.out.println(AMA+"| 2. Visualizar o valor total pago em direitos  |");
									System.out.println(ROSE+"|-----------------------------------------------|");
									System.out.println(RED+"| 3. Retornar para o menu                       |");
									System.out.println(ROSE+"|-----------------------------------------------|"+RESET);
									op=val.validarOpcao("|            Introduz a Opcao (1-3)             |",ROSE+"|-----------------------------------------------|"+RESET);
									
									switch(op)
									{
										case 1:
											t.acumulador_com_todosIT();
											break;
										case 2:
											t.acumulador_direitos_adoaneiro();
											break;
										case 3:
											System.out.println(RED+"|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|"+RESET);
											break;
										default:
											System.out.println(RED+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|"+RESET);
									}
								}while(op!=3);
								break;
							case 4:
								do
								{
									System.out.println(ROSE+"|-----------------------------------|");
									System.out.println(AMA+"|*-*-*-*-*-* S U B - M E N U *-*-*-*|");
									System.out.println(ROSE+"|-----------------------------------|");
									System.out.println(AMA+"| 1. Escrever o ficheiro de objecto |");
									System.out.println(ROSE+"|-----------------------------------|");
									System.out.println(AMA+"| 2. Ler ficheiro de objecto        |");
									System.out.println(ROSE+"|-----------------------------------|");
									System.out.println(AMA+"| 3. Retornar para o menu           |");
									System.out.println(ROSE+"|-----------------------------------|"+RESET);
									op=val.validarOpcao(RED+"|      Introduz a Opcao (1-3)       |",ROSE+"|-----------------------------------|"+RESET);
									
									switch(op)
									{
										case 1:
											t.escrever_Objecto();
											break;
										case 2:
											t.ler_Objecto();
											break;
										case 3:
											System.out.println(RED+"|--------|");
											System.out.println("| <<--<< |");
											System.out.println("|--------|"+RESET);
											break;
										default:
											System.out.println(RED+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
											System.out.println("| A opcao invalida tente novamente! |");
											System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|"+RESET);
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
								t.remover_cliente_entregue();
								break;
							case 9:
								System.out.println(RED+"|--------|");
								System.out.println("| <<--<< |");
								System.out.println("|--------|"+RESET);
								break;
							default:
								System.out.println(RED+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
								System.out.println("| A opcao invalida tente novamente! |");
								System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|"+RESET);
						}
					}while(op!=9);
					break;
				case 2:
					System.out.println(ROSE+"|================================================|");
					System.out.println("|		Nomes dos Programadores		 |");
					System.out.println("|----------------|-----------------|-------------|");
					System.out.println(AMA+"| Vritik Valabdas| Vicente Macuacua| Yasin Magno |");
					System.out.println(ROSE+"|----------------|-----------------|-------------|");
					System.out.println("|		Codico de Estudante		 |");
					System.out.println("|----------------|-----------------|-------------|");
					System.out.println(AMA+"| 	20190025 |	 20240208  | 20240260 	 |");
					System.out.println(ROSE+"|================================================|"+RESET);
					break;
				case 3:
					System.out.println(RED+"|======================================|");
					System.out.println("|==============    ===     ============|");
					System.out.println("|=============      =       ===========|");
					System.out.println("|=============              ===========|");
					System.out.println("|==============           =============|");
					System.out.println("|================       ===============|");
					System.out.println("|======   =========   ========   ======|");
					System.out.println("|======= =========== ========== =======|");
					System.out.println("|======================================|"+RESET);
					System.out.println(AMA+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
					System.out.println("| Obrigado por usar o nosso programa ! |");
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|"+RESET);
					System.out.println(RED+"|======================================|");
					System.out.println("|==============    ===     ============|");
					System.out.println("|=============      =       ===========|");
					System.out.println("|=============              ===========|");
					System.out.println("|==============           =============|");
					System.out.println("|================       ===============|");
					System.out.println("|======   =========   ========   ======|");
					System.out.println("|======= =========== ========== =======|");
					System.out.println("|======================================|"+RESET);
					break;
				default:
					System.out.println(RED+"|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|");
					System.out.println("| A opcao invalida tente novamente! |");
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|"+RESET);
			}
		}while(op!=3);
	}
}
