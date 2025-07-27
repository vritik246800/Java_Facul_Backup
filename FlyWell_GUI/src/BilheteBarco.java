
public final class BilheteBarco extends Bilhete 
{
	private String nome,tipo;
	private int lotacao;
	public static int ctB=0;
	
	public BilheteBarco(String destino,String passaport,int valor,String nome,String tipo,int lotacao)
	{
		super(destino,passaport,valor);
		this.nome=nome;
		this.tipo=tipo;
		this.lotacao=lotacao;
		ctB++;
		
	}
	public BilheteBarco()
	{
		this("","",0,"","",0);
	}
	public String getnome() {return nome;}
	public String gettipo() {return tipo;}
	public int getlotacao() {return lotacao;}
	
	public void setlotacao(int lotacao) {this.lotacao=lotacao;}
	public void settipo(String tipo) {this.tipo=tipo;}
	public void setnome(String nome) {this.nome=nome;}
	
}
