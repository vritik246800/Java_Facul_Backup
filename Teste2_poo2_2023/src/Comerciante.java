
public class Comerciante extends Agente
{
	private int codComerciante,valTransacao;
	public static int contC=0;
	
	public Comerciante(int codigo,String nome,float valComisao,char tipoAgente,int codComerciante,int valTransacao)
	{
		super(codigo,nome,valComisao,tipoAgente);
		this.codComerciante=codComerciante;
		this.valTransacao=valTransacao;
		contC++;
		
	}
	public Comerciante()
	{
		this(0,"",0,' ',0,0);
	}
	public void setcodComerciante(int codComerciante) {this.codComerciante=codComerciante;}
	public int getcodComerciante() {return codComerciante;}
	public void setvalTransacao(int valTransacao) {this.valTransacao=valTransacao;}
	public int getvalTransacao() {return valTransacao;}
	

}
