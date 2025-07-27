public class Visualizacoes
{
  public Visualizacoes() {}

  //metodo para visualizar a mensagem de uma operacao feita com sucesso
  public void msgSucesso()
  {
    System.out.println("Operacao feita com sucesso! Verifique o(s) saldo(s) actualizado(s) na Opcao 2 ou no Dados.txt");
  }

  public void msgErro()
  {
    System.out.println("Erro! Execute a opcao 1 primeiro!");
  }

  //metodo para acumular todos dados do ficheiro de texto i.e. toString
  public void visualizarDadosDoCliente(Cliente [] array, int posicaoCliente)
  {
    System.out.println(array[posicaoCliente]);
    System.out.println();
  }
}