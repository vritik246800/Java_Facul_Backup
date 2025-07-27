import java.io.*;

public class EscreverTexto
{
  private String sep;

  public EscreverTexto()
  {
    sep = ";"; //separador de dados no ficheiro de texto
  }

  public void escreverRelatorio(String relatorio)
  {
    try
    {
      FileWriter fw = new FileWriter("RelatorioTransaccoes.txt");
      BufferedWriter bw = new BufferedWriter(fw);

      bw.write(relatorio);

      bw.close();
      System.out.println("Relatorio de transaccoes criada com sucesso! Verifica o ficheiro RelatorioTransaccoes.txt");
    }
    catch(IOException i)
    {
      System.out.println(i.getMessage());
    }
  }

  public void escreverNovoBalanco(Cliente[] a, int cont)
  {
    try
    {
      FileWriter fw = new FileWriter("Dados.txt");
      BufferedWriter bw = new BufferedWriter(fw);

      for(int i = 0; i < cont; i++)
      {
        bw.write(a[i].getBalanco() + sep + a[i].getNome() + sep + a[i].getConta() + sep + a[i].getNIB() + sep + a[i].getPIN());

        if(i != cont - 1)
          bw.newLine();
      }
      bw.close();
    }
    catch(IOException i)
    {
      System.out.println(i.getMessage());
    }
  }

  public void escreverNovoRegisto(int balanco, String nome, int conta, int nib, int pin)
  {
    try
    {
      FileWriter fw = new FileWriter("Dados.txt", true);
      BufferedWriter bw = new BufferedWriter(fw);

      bw.newLine();
      bw.write(balanco + sep + nome + sep + conta + sep + nib + sep + pin);

      bw.close();
      System.out.println("Novo registo acrescentado no ficheiro de texto com sucesso!");
    }
    catch(IOException i)
    {
      System.out.println(i.getMessage());
    }
  }
}