public class Menu
{
  private Validacoes val;
  private Visualizacoes vis;

  public Menu()
  {
    val = new Validacoes();
    vis = new Visualizacoes();
  }

  public void menu()
  {
    byte op = 0;
    boolean passou = false;
    TodosClientes t = new TodosClientes();

    do
    {
      System.out.println("+=============================================================================================+");
      System.out.println("|                          *** BANCO COMERCIAL DE INVESTIMENTOS - MENU ***                    |");
      System.out.println("+=============================================================================================+");
      System.out.println("|1->Ler os dados dos Clientes do Ficheiro de Texto                                            |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|2->Consultar o Saldo de uma Conta Bancaria                                                   |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|3->Deposito                                                                                  |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|4->Levantamento                                                                              |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|5->Transferencia                                                                             |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|6->Adicionar o registo de um novo Cliente a partir do teclado no ficheiro de Texto de input. |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|7->Criar um relatorio de todas transaccoes                                                   |");
      System.out.println("|---------------------------------------------------------------------------------------------|");
      System.out.println("|8->Sair do programa                                                                          |");
      System.out.println("+=============================================================================================+");

      op = (byte) (val.validarInt(1, 8, "Introduza uma opcao(1-8):"));

      switch(op)
      {
        case 1:
          if(passou == false)
          {
            t.lerDoFicheiro();
            passou = true;
          }
          else
            System.out.println("O ficheiro de texto ja foi lido!");
          break;

        case 2: //fix
          if(passou == true)
            t.adapConsultarDadosCliente();
          else
            vis.msgErro();
          break;

        case 3:
          if(passou == true)
            t.adapDeposito();
          else
            vis.msgErro();
          break;

        case 4:
          if(passou == true)
            t.adapLevantamento();
          else
            vis.msgErro();
          break;

        case 5:
          if(passou == true)
            t.adapTransferencia();
          else
            vis.msgErro();
          break;

        case 6:
          if(passou == true)
            t.adapNovoRegisto();
          else
            vis.msgErro();
          break;

        case 7:
          if(passou == true)
            t.adapRelatorio();
          else
            vis.msgErro();
          break;

        case 8:
          System.out.println("+=================================================+");
          System.out.println("|               O programa foi encerrado          |");
          System.out.println("+=================================================+");
          System.exit(0);

        default:
          System.out.println("Opcao Invalida!");
      }
    } while(op != 8);
  }
}
