
public class TabelaOBJ 
{
	private String artigo;
	private float preco;
	private int qty;
	
	public TabelaOBJ(String artigo,float preco,int qty)
	{
		this.artigo=artigo;
		this.preco=preco;
		this.qty=qty;
		
	}
	public TabelaOBJ()
	{
		this("",0,0);
	}
	public String getArtigo() {return artigo;}
	public float getPreco() {return preco;}
	public int getQty() {return qty;}
	
	public void setArtigo(String artigo) {this.artigo = artigo;}
	public void setPreco(float preco) {this.preco = preco;}
	public void setQty(int qty) {this.qty = qty;}
}
