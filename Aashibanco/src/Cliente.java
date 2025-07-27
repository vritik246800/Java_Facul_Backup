import java.text.DecimalFormat;
import java.io.*;

public class Cliente implements Serializable
{
  private int balanco, nib, conta, pin;
  private String nome;
  private DecimalFormat mt; //formatacao monetaria

  /*
  balanco - valor actual que se encontra na conta bancaria i.e. o saldo
  nib - numero de identificacao bancaria. Considerou-se como um numero de 9 digitos
  conta - numero da conta. Considerou-se como um numero de 8 digitos
  nome - nome completo do cliente
  pin - numero de identificacao pessoal (4 digitos)
  */

  public Cliente(String nome, int nib, int conta, int balanco, int pin)
  {
    this.nome = nome;
    this.nib = nib;
    this.conta = conta;
    this.balanco = balanco;
    this.pin = pin;

    mt = new DecimalFormat("###,###,###.00 MTs");
  }

  //metodo para actualizar o balanco na conta, apos uma transaccao
  public void actualizarBalanco(int a)
  {
    balanco = a;
  }

  //metodos de accesso
  public int getNIB()
  {
    return nib;
  }
  
  public int getPIN()
  {
  	return pin;
  }
  
  public int getConta()
  {
    return conta;
  }

  public String getNome()
  {
    return nome;
  }

  public int getBalanco()
  {
    return balanco;
  }

  //metodo para a tabela de toString
  public String toString()
  {
    String a, b, c;

    a = "+====================================================================================+\n"
    +   "|       Nome         |  Numero da Conta   |          NIB        |       Balanco      |\n"
    +   "--------------------------------------------------------------------------------------\n";
    b = String.format("| %18s | %18d |  %18d | %18s |\n", nome, conta, nib, mt.format(balanco));
    c = "+====================================================================================+\n";

    return (a+b+c);
  }  
}