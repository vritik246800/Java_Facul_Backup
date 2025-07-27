import java.text.DecimalFormat;
public class Revista
{ 
	private String nome;
	private int quant;
	private float preco;
	private float total;
	private DecimalFormat moeda;
	
	//Construtor da classe, promove a inicialização dos atributos
	public Revista(String no, int qu, float pr)
	{ 
		nome = no;
		quant = qu;
		preco = pr;
		total = calcTotal();
		moeda = new DecimalFormat ("###,###.00 Mt");
	}
	private float calcTotal()
	{ 
		return quant*preco; 
	}
	public float getTotal() 
	{ 
		return total; 
	}
	public String getNome() 
	{ 
		return nome; 
	}
	public String toString()
	{
		return nome+"\t|"+quant+" de preco "+moeda.format(preco)+"\t|total="+moeda.format(total);
	}
}