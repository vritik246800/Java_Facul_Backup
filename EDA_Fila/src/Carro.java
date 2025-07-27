/*
	 Descricao do objeto:
	 BeForwad, uma empresa que se dedica na venda de carros pretende organizar melhor as suas vendas.
	 Para isso, contrata um enginheiro para desenvolver o sistema de gerenciamento, se colocou como 
	 requisito principal o uso da estrutura fila emplementada em um vector.
	 Sendo que cada carro possue matricula, marca, cor, ano de lancamento, e preco.
	 Pretende-se ler os dados de um ficheiro de texto
	 
	 */
public class Carro 
{
	private String matricula;
	private String marca;
	private String cor;
	private int valor;
	public static int CONT_CARROS=0;
	
	public Carro(String marca, String matricula, String cor, int valor)
	{
		this.cor=cor;
		this.marca = marca;
		this.matricula=matricula;
		this.valor=valor;
		CONT_CARROS++;
	}
	public int getValor() {return valor;}
	public String getMarca() {return marca;}
	public String getCor() {return cor;}
	public String getMatricula() {return matricula;}
	
	public void setValor(int valor) {this.valor=valor;}
	public void setMarca(String marca) {this.marca = marca;}
	public void setMatricula(String matricula) {this.matricula=matricula;}
	public void setCor(String cor) {this.cor=cor;}
	
	
	public String toString() 
	{
		return "Carro [matricula=" + matricula + ", marca=" + marca + ", cor=" + cor + ", valor=" + valor + "]";
	}
}
