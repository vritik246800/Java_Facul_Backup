
public class Menu 
{
	private TodasReservas t;
	Validacoes v;
	public Menu()
	{
		v=new Validacoes();
	}
	public void menu()
	{
		byte op=0;
		boolean pass=false;
		do
		{
			System.out.println("                           |===========================|");
			System.out.println("                           | * * * * M E N U * * * * * |");
			System.out.println("|==========================|---------------------------|===========================|");
			System.out.println("|1. | Ler do ficheiro de texto para iniciar o programa                             |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|2. | Visualizar os dados das Reservas e o valor a pagar                           |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|3. | Visualizar as quantidades de reservas totais e em cada tipo                  |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|4. | Visualizar as quantidade de reservas na epoca de feriados                    |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|5. | Escrever no ficheiro de texto o valor total recebido em cada tipo de reserva |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|6. | Escrever no ficheiro de objecto                                              |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|7. | Pesquisar reservas e visualizar                                              |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|8. | Ordenar as reservas decrescente da data de saida                             |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|9. | Introduzir novas reservas (BONUS)                                            |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|10.| Nomes dos Programadores                                                      |");
			System.out.println("|---|==============================================================================|");
			System.out.println("|11.| Sair do programa                                                             |");
			System.out.println("|=======================|--------------------------------|=========================|");
			System.out.println("                        |Introduz introduz a opcao (1-11)|");
			System.out.println("                        |================================|");
			
			op=v.validarOP();
			
			switch(op)
			{
				case 1:
					t=new TodasReservas();
					t.todas();
					pass=true;
					break;
				case 2:
					if(pass==false)
						msgBLOCK();
					else
					{
						System.out.println(t);
						t.vizTabelaValor();
					}
					break;
				case 3:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.vizQuantidadeTR();
					}
					break;
				case 4:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.contadorDFeriado();
					}
					break;
				case 5:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.criarFicheiro();
					}
					break;
				case 6:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.gravarObj();
					}
					break;
				case 7:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.pesquisarR();
					}
					break;
				case 8:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.ordenar();
						System.out.println(t);
					}
					break;
				case 9:
					if(pass==false)
						msgBLOCK();
					else
					{
						t.bonus();
					}
					break;
				case 10:
					vizNome();
					break;
				case 11:
					System.out.println("|======================================|");
					System.out.println("| Obrigado por usar o nosso programa ! |");
					System.out.println("|======================================|");
					break;
				default:
					System.out.println("|==============================|");
					System.out.println("| Opcao introduzida Invalida ! |");
					System.out.println("|==============================|");
			}
		}while(op!=11);
	}
	public static void vizNome()
	{
		System.out.println("|================================================|");
		System.out.println("|		Nomes dos Programadores		 |");
		System.out.println("|----------------|-----------------|-------------|");
		System.out.println("| Vritik Valabdas| Vicente Macuacua| Yasin Magno |");
		System.out.println("|----------------|-----------------|-------------|");
		System.out.println("|		Codico de Estudante		 |");
		System.out.println("|----------------|-----------------|-------------|");
		System.out.println("| 	20190025 |	 20240208  | 20240260 	 |");
		System.out.println("|================================================|");
	}
	public void msgBLOCK()
	{
		System.out.println("|====================================================|");
		System.out.println("| Opcao bloqueada o utilizado tem que iniciar ! [;)] |");
		System.out.println("|====================================================|");
	}
}