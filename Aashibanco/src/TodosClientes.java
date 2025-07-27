import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TodosClientes
{
  private Cliente[] array; //array de objectos
  private int cont; //contador

  //classes ligadas
  private Visualizacoes vis;
  private EscreverTexto esc;
  private Validacoes val;
  private Pesquisa pes;
  private Calculos cal;

  private String todasTransaccoes; //acumulador para formar o relatorio de transaccoes
  private DecimalFormat mt; //formatacao monetaria

  public TodosClientes()
  {
    array = new Cliente[100];
    cont = 0;
    vis = new Visualizacoes();
    val = new Validacoes();
    esc = new EscreverTexto();
    pes = new Pesquisa();
    cal = new Calculos();

    todasTransaccoes = "";
    mt = new DecimalFormat("###,###,###.00 MTs");
  }

  public void lerDoFicheiro()
  {
    int balanco, nib, conta, pin;
    String nome, umaLinha;
    StringTokenizer str;

    try
    {
      FileReader fr = new FileReader("Dados.txt");
      BufferedReader br = new BufferedReader(fr);

      umaLinha = br.readLine();

      while (umaLinha != null)
      {
        str = new StringTokenizer(umaLinha, ";");

        balanco = Integer.parseInt(str.nextToken());
        nome = str.nextToken();
        conta = Integer.parseInt(str.nextToken());
        nib = Integer.parseInt(str.nextToken());
        pin = Integer.parseInt(str.nextToken());

        array[cont] = new Cliente(nome, nib, conta, balanco, pin);
        cont++;
        umaLinha = br.readLine();
      }
      br.close();
      System.out.println("Ficheiro de texto foi lido com sucesso!");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Ficheiro nao foi encontrado!");
    }
    catch (NumberFormatException n)
    {
      System.out.println(n.getMessage());
    }
    catch (IOException z)
    {
      System.out.println(z.getMessage());
    }
  }

  //metodo toString
  public void adapConsultarDadosCliente()
  {
    int posicaoCliente = 0, conta, pin;

    conta = val.validarNumeroConta(10000000, 99999999, "Introduza o numero da conta para visualizar o saldo (XXXXXXX):", array, cont);
    posicaoCliente = pes.pesquisar(array, cont, conta);
    pin = val.validarPIN(1000, 9999, array[posicaoCliente].getPIN(), "Introduza o PIN da conta (XXXX): ");

    vis.visualizarDadosDoCliente(array, posicaoCliente);
  }

  //adaptador para efectuar um deposito numa conta
  public void adapDeposito()
  {
    int pin, conta, posicaoUtilizador = 0, valorDeposito, novoBalanco;

    conta = val.validarNumeroConta(10000000, 99999999, "Introduza a conta onde pretende depositar (XXXXXXX):", array, cont);
    posicaoUtilizador = pes.pesquisar(array, cont, conta);
    pin = val.validarPIN(1000, 9999, array[posicaoUtilizador].getPIN(), "Introduza o PIN da conta (XXXX): ");

    valorDeposito = val.validarDep("Introduza o valor a depositar (>0): ");
    novoBalanco = cal.calcularBalancoAposDeposito(array, posicaoUtilizador, valorDeposito);

    //actualizacao do balanco no array de objectos e no ficheiro de texto
    array[posicaoUtilizador].actualizarBalanco(novoBalanco);
    esc.escreverNovoBalanco(array, cont);

    //actualizacao do acumulador todasTransaccoes para formar o relatorio das transaccoes
    acumularTransaccoes(array[posicaoUtilizador].getNome(), "Deposito", array[posicaoUtilizador].getConta() + "", valorDeposito);

    vis.msgSucesso();
  }

  //adaptador para efectuar um levantamento numa conta
  public void adapLevantamento()
  {
    int pin, conta, posicaoUtilizador = 0;

    conta = val.validarNumeroConta(10000000, 99999999, "Introduza a conta onde pretende levantar (XXXXXXX):", array, cont);
    posicaoUtilizador = pes.pesquisar(array, cont, conta);
    pin = val.validarPIN(1000, 9999, array[posicaoUtilizador].getPIN(), "Introduza o PIN da conta (XXXX): ");

    if (array[posicaoUtilizador].getBalanco() == 0) //verificacao se a conta tem balanco para efectuar o levantamento
      System.out.println("Nao foi possivel efectuar o levantamento. A conta tem um balanco de 0 MTs");
    else
    {
      int valorLevantamento, novoBalanco;

      valorLevantamento = val.validarInt(1, array[posicaoUtilizador].getBalanco(), "Introduza o valor a levantar (>0 e <=quantidade maxima na conta): ");

      novoBalanco = cal.calcularBalancoAposLevantamento(array, posicaoUtilizador, valorLevantamento);

      //actualizacao do balanco da conta no array de objectos e no ficheiro de texto
      array[posicaoUtilizador].actualizarBalanco(novoBalanco);
      esc.escreverNovoBalanco(array, cont);

      //actualizacao do acumulador todasTransaccoes para formar o relatorio das transaccoes
      acumularTransaccoes(array[posicaoUtilizador].getNome(), "Levantamento", array[posicaoUtilizador].getConta() + "", valorLevantamento);

      vis.msgSucesso();
    }
  }

  //adaptador para efectuar uma transferencia de uma conta (de transferencia) para uma outra conta (beneficiario) no banco
  public void adapTransferencia()
  {
    int pin, contaTransferencia, posicaoUtilizadorTransferencia = 0;

    contaTransferencia = val.validarNumeroConta(10000000, 99999999, "Introduza a conta que pretende iniciar a transferencia (XXXXXXX):", array, cont);
    posicaoUtilizadorTransferencia = pes.pesquisar(array, cont, contaTransferencia);
    pin = val.validarPIN(1000, 9999, array[posicaoUtilizadorTransferencia].getPIN(), "Introduza o PIN da conta (XXXX): ");

    if (array[posicaoUtilizadorTransferencia].getBalanco() == 0) //verificacao se a conta tem balanco para efectuar o levantamento
      System.out.println("Nao foi possivel efectuar a transferencia. A conta tem um balanco de 0 MTs");
    else
    {
      int contaBeneficiaro, posicaoUtilizadorBeneficiario = 0, valorTransferencia, novoBalancoTransferencia, novoBalancoBeneficiario;

      contaBeneficiaro = val.validarNumeroConta(10000000, 99999999, "Introduza a conta do beneficiario (XXXXXXX):", array, cont);
      posicaoUtilizadorBeneficiario = pes.pesquisar(array, cont, contaBeneficiaro);

      valorTransferencia = val.validarInt(1, array[posicaoUtilizadorTransferencia].getBalanco(), "Introduza o valor a transferir (>0 e <=quantidade maxima na conta): ");

      //actualizacao do balanco da conta da transferencia no array de objectos
      novoBalancoTransferencia = cal.calcularBalancoAposLevantamento(array, posicaoUtilizadorTransferencia, valorTransferencia);
      array[posicaoUtilizadorTransferencia].actualizarBalanco(novoBalancoTransferencia);

      //actualizacao do balanco da conta do beneficiario no array de objectos
      novoBalancoBeneficiario = cal.calcularBalancoAposDeposito(array, posicaoUtilizadorBeneficiario, valorTransferencia);
      array[posicaoUtilizadorBeneficiario].actualizarBalanco(novoBalancoBeneficiario);

      //actualizacao dos balancos no ficheiro de texto
      esc.escreverNovoBalanco(array, cont);

      //actualizacao do acumulador todasTransaccoes para formar o relatorio das transaccoes
      acumularTransaccoes(array[posicaoUtilizadorTransferencia].getNome() + " para " + array[posicaoUtilizadorBeneficiario].getNome(), "Transferencia", array[posicaoUtilizadorTransferencia].getConta() + " para " + array[posicaoUtilizadorBeneficiario].getConta(), valorTransferencia);

      vis.msgSucesso();
    }
  }

  //adaptador para adicionar um novo registo no array de objectos e no ficheiro de texto
  public void adapNovoRegisto()
  {
    Random r = new Random();

    int conta, nib, pin;
    String nome;

    nome = val.validarNome("Introduza o nome completo do cliente: ");
    pin = val.validarInt(1000, 9999, "Introduza o PIN (numero de identificacao pessoal) de 4 digitos que pretende usar para acessar a conta (XXXX): ");
    conta = r.nextInt(10000000, 99999999); //geracao de um interiro aleatorio de 8 digitos
    nib = r.nextInt(100000000, 999999999); //geracao de um inteiro aleatorio de 9 digitos

    esc.escreverNovoRegisto(0, nome, conta, nib, pin);
    array[cont] = new Cliente(nome, nib, conta, 0, pin); //criacao de um novo objecto no array de objectos
    cont++;
  }

  //adaptador para criar um ficheiro de texto do relatorio com todas as transaccoes
  public void adapRelatorio()
  {
    esc.escreverRelatorio(todasTransaccoes);
  }

  //metodo para acumular todas transaccoes para formar o relatorio final
  public void acumularTransaccoes(String nomes, String operacao, String contas, int valor)
  {
    String sep = ";"; //separador de dados i.e. o ";"
    todasTransaccoes += "Operacao:" + operacao + sep + " Nome(s):" + nomes + sep + " Conta(s) afectada(s):" + contas + sep + " Valor:" + mt.format(valor) + "\n";
  }
}
