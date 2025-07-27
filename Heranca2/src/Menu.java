
public class Menu 
{
	Validacao val;
	
	public Menu()
	{
		val=new Validacao();
		
	}
	public void menu()
	{
		Tarefas t=new Tarefas();
		byte op;
		do
		{
			System.out.println("          MENU");
			System.out.println("1. Inicia o programa");
			System.out.println("2. Nome do programador");
			System.out.println("3. Exit");
			op=val.validarByte("Instroz a opcao opcao acima !");
			switch(op)
			{
				case 1:
					t.lerFichTxt();
					t.toString();
					t.listaProf();
					t.listaAluno();
					t.calcMediaHoras();
					
					break;
				case 2:
					System.out.println("Nome: Vritik Valabdas \nCode: 20190025");
					break;
				case 3:
					System.out.println("Obrigado ");
					break;
				default:
					System.out.println("A opcao e invalida !!");
			}
			
			
		}while(op!=3);
		
	}
}
