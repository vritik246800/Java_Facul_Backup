public class Calculos
{
  public Calculos() {}

  //metodo de adicao para calcular o novo saldo apos um deposito ou recepcao de dinheiro pelo beneficiario
  public int calcularBalancoAposDeposito(Cliente[] array, int posicaoUtilizador, int valorDeposito)
  {
    int novoBalanco;
    novoBalanco = array[posicaoUtilizador].getBalanco();
    novoBalanco += valorDeposito;

    return novoBalanco;
  }

  //metodo de subtracao para calcular o novo saldo apos o levantamento ou transferencia de dinheiro para uma outra conta
  public int calcularBalancoAposLevantamento(Cliente[] array, int posicaoUtilizador, int valorDeposito)
  {
    int novoBalanco;
    novoBalanco = array[posicaoUtilizador].getBalanco();
    novoBalanco -= valorDeposito;

    return novoBalanco;
  }
}
