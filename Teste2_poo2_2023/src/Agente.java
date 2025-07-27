
public class Agente 
{
	protected int codigo;
	protected String nome;
	protected float valComisao;
	protected char tipoAgente;
	
	public Agente(int codigo,String nome,float valComisao,char tipoAgente)
	{
		this.codigo=codigo;
		this.nome=nome;
		this.valComisao=valComisao;
		this.tipoAgente=tipoAgente;
		
	}
	public Agente()
	{
		this(0,"",0,' ');
	}
	public int getcodigo() {return codigo;}
	public void setcodigo(int codigo) {this.codigo=codigo;}
	public String getnome() {return nome;}
	public void setnome(String nome) {this.nome=nome;}
	public float getvalComisao() {return valComisao;}
	public void setvalComisao(float valComisao) {this.valComisao=valComisao;}
	public char gettipoAgente() {return tipoAgente;}
	public void settipoAgente(char tipoAgente) {this.tipoAgente=tipoAgente;}	

}
