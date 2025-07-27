public class Pesquisa
{
  public Pesquisa() {}

  public int pesquisar(Cliente[] array, int cont, int conta)
  {
    int posicaoUtilizador = -1; // Initialize to -1 in case the account is not found
    boolean found = false;

    for(int i = 0; i < cont && !found; i++)
    {
      if(array[i].getConta() == conta)
      {
        found = true;
        posicaoUtilizador = i;
        return posicaoUtilizador;
      }
    }
    return -1; //retorna -1 quando o numero da conta (i.e. o cliente) nao existe no banco
  }
}