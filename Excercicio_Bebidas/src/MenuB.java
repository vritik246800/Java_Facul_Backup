
public class MenuB 
{
	private TodasBebidas t;
	private ValidacaoB v;
	public MenuB()
	{
		v=new ValidacaoB();
	}
	public void menu()
	{
		
		byte op;
		boolean pass=false;
		do
		{
			System.out.println("* * * * M E N U * * * *");
			System.out.println("1. Ler file de dados");
			System.out.println("2. Visualizar Bebudas");
			System.out.println("3. Visualizar o valor total de deconto desconto ");
			System.out.println("4. Visualizar a quantidade de cada bebida");
			System.out.println("5. Escrever no file de texto a marca e valor das cervejas");
			System.out.println("6. Escrever o file de objecto");
			System.out.println("7. Ler o file de opjecto");
			System.out.println("8. Nome e Codigo do Programador");
			System.out.println("9. Exit");
			System.out.println("Introduz a opcao entre (1-9):");
			
			op=v.validarByte();
			
			switch(op)
			{
				case 1:
					t=new TodasBebidas();
					t.todos();
					pass=true;
					break;
				case 2:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						System.out.println(t);
					}
					break;
				case 3:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						t.acD();
					}
					break;
				case 4:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						t.ctB();
					}
					break;
				case 5:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						t.criarTXT();
					}
					break;
				case 6:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						t.CriarFObj();
					}
					break;
				case 7:
					if(pass==false)
						System.out.println("Comece da opcao ( 1 ) ! !");
					else
					{
						t.LerFObj();
					}
					break;
				case 8:
					System.out.println("Nome: Vritik Valabdas\nCodigo: 20190025");
					break;
				case 9:
					System.out.println("Obrigado por usar o meu Programa ! l;)");
					break;
				default:
					System.out.println("A opcao e invalida ! ! ");
			}
		}while(op!=9);
	}
}
