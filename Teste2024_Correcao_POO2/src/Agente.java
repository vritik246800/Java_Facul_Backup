import java.io.Serializable;
public class Agente implements Serializable
{
	protected int codigo;
	protected String nome;
	protected char tipoAgente;
	protected float valorComissao;
	
	public Agente(int codigo, String nomeCliente, char tipoCliente, float valor) 
	{
		this.codigo = codigo;
		this.nome = nomeCliente;
		this.tipoAgente = tipoCliente;
		this.valorComissao = valor;
	}
	
	public Agente() 
	{
		this(0,"",' ',0);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getTipoAgente() {
		return tipoAgente;
	}

	public void setTipoAgente(char tipoAgente) {
		this.tipoAgente = tipoAgente;
	}
	
	public float getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(float valorComissao) {
		this.valorComissao = valorComissao;
	}

	public String toString() {
		return "Agente [codigo=" + codigo + ", nomeCliente=" + nome + ", tipoCliente="
				+ tipoAgente + ", valor=" + valorComissao + "]";
	}
}
