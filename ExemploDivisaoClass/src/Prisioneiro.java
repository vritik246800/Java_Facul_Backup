import java.text.DecimalFormat;
public class Prisioneiro
{
  private String nome, dataNascimento, duracao, motivo;
  private int valorInicial, valorFianca, valorFinal;
  private DecimalFormat mt;
  
  public Prisioneiro(String nome, String dataNascimento, String duracao, String motivo)
  {
	this.nome = nome;
	this.dataNascimento = dataNascimento;
	this.duracao = duracao;
	this.motivo = motivo;
	valorInicial = 10000;
	valorFianca = calcularFianca();
	valorFinal = calcularFinal();
	mt = new DecimalFormat("###,###.00 MTS");
  }
  
  public String getDataNascimento() { return dataNascimento; }
  public int getValorFinal() { return valorFinal; }
  
  public int calcularFinal()
  {
	return valorInicial + valorFianca;
  }
  
  public int calcularFianca()
  {
	final int FIANCA = 20000;
	int f = 0, d;
	
	
	if(!duracao.equalsIgnoreCase("vitalicio"))
	{
	  d = Integer.parseInt(duracao);

	  if(motivo.equalsIgnoreCase("Assalto") && d<=10)
		f = FIANCA;
	}
	
	return f;
  }
  
  public String toString()
  {
	return "Nome:"+nome+" Data Nascimento:"+dataNascimento+" Duracao:"+duracao+" Motivo:"+motivo+" Valor inicial:"+mt.format(valorInicial)+" Fianca:"+mt.format(valorFianca)+" Valor final:"+mt.format(valorFinal);
  }  
}
  /*
  public int definir()
  {
	final int ENTRADA = 10000;
	return ENTRADA;
  }
  */