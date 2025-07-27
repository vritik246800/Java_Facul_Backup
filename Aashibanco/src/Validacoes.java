import java.io.*;

public class Validacoes
{
  private BufferedReader x;

  public Validacoes() //metodo construtor da classe Validacoes
  {
    x = new BufferedReader(new InputStreamReader(System.in));
  }

  //metodo para validar o nome do cliente
  public String validarNome(String msg)
  {
    String nome = "";
    do
    {
      System.out.print(msg);
      try
      {
        nome = x.readLine();
      }
      catch(IOException i)
      {
        System.out.println(i.getMessage());
      }
      System.out.println(nome);

      if(nome.length() < 2)
        System.out.println("Erro! Nome invalido!");

    } while(nome.length() < 2);
    return nome;
  }

  //metodo para validar o valor do deposito
  public int validarDep(String msg)
  {
    int numeroInteiro = 0;
    do
    {
      System.out.print(msg);
      try
      {
        numeroInteiro = Integer.parseInt(x.readLine());
      }
      catch(NumberFormatException n)
      {
        System.out.println(n.getMessage());
      }
      catch(IOException i)
      {
        System.out.println(i.getMessage());
      }
      System.out.println(numeroInteiro);

      if(numeroInteiro <= 0)
        System.out.println("Erro! Entrada invalida!");
    } while(numeroInteiro <= 0);

    return numeroInteiro; 
  }

  //metodo para validar o valor de um levantamento ou transferencia
  public int validarInt(int a, int b, String msg)
  {
    int numeroInteiro = 0;
    do
    {
      System.out.print(msg);
      try
      {
        numeroInteiro = Integer.parseInt(x.readLine());
      }
      catch(NumberFormatException n)
      {
        System.out.println(n.getMessage());
      }
      catch(IOException i)
      {
        System.out.println(i.getMessage());
      }
      System.out.println(numeroInteiro);

      if(numeroInteiro < a || numeroInteiro > b)
        System.out.println("Erro! Entrada invalida!");
    } while(numeroInteiro < a || numeroInteiro > b);
    return numeroInteiro; 
  }

  //metodo para validar o numero da conta
  public int validarNumeroConta(int a, int b, String msg, Cliente[] array, int cont)
  {
    int numeroInteiro = 0;
    int posicaoUtilizador = 0;
    Pesquisa pes = new Pesquisa();
    
    do
    {
      System.out.print(msg);
      try
      {
        numeroInteiro = Integer.parseInt(x.readLine());
      }
      catch(NumberFormatException n)
      {
        System.out.println(n.getMessage());
      }
      catch(IOException i)
      {
        System.out.println(i.getMessage());
      }

      System.out.println(numeroInteiro);
      posicaoUtilizador = pes.pesquisar(array, cont, numeroInteiro); //verificacao da existencia do cliente no banco.

      if(numeroInteiro < a || numeroInteiro > b || posicaoUtilizador == -1)
        System.out.println("Erro! Entrada invalida!"); //erro ocorre se o numero da conta e diferente de 8 digitos ou se a conta nao existe
    } while(numeroInteiro < a || numeroInteiro > b || posicaoUtilizador == -1);
    return numeroInteiro; 
  }
  
  //metodo para validar o PIN de um Cliente que esta cadastrado no banco
  public int validarPIN(int a, int b, int pinUtilizador, String msg)
  {
    int numeroInteiro = 0;
    do
    {
      System.out.print(msg);
      try
      {
        numeroInteiro = Integer.parseInt(x.readLine());
      }
      catch(NumberFormatException n)
      {
        System.out.println(n.getMessage());
      }
      catch(IOException i)
      {
        System.out.println(i.getMessage());
      }
      System.out.println(numeroInteiro);

      if(numeroInteiro < a || numeroInteiro > b || pinUtilizador != numeroInteiro)
        System.out.println("Erro! Entrada invalida ou PIN invalido!");
    } while(numeroInteiro < a || numeroInteiro > b || pinUtilizador != numeroInteiro);
    return numeroInteiro; 
  }
} //fim da classe
