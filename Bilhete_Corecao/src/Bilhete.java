import java.io.Serializable;

public class Bilhete implements Serializable
{
	protected String codigo, nome, bi, dataPartida, dataChegada, formaPagamento;
	protected int valorBilhete;
	
	public Bilhete(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete) {
		this.codigo = codigo;
		this.nome = nome;
		this.bi = bi;
		this.dataPartida = dataPartida;
		this.dataChegada = dataChegada;
		this.formaPagamento = formaPagamento;
		this.valorBilhete = valorBilhete;
	}
	
	public Bilhete() {this("", "", "", "", "", "", 0);}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public void setDataPartida(String dataPartida) {
		this.dataPartida = dataPartida;
	}

	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getValorBilhete() {
		return valorBilhete;
	}

	public void setValorBilhete(int valorBilhete) {
		this.valorBilhete = valorBilhete;
	}

	public String toString() 
	{
		return "codigo=" + codigo + ", nome=" + nome + ", bi=" + bi + ", dataPartida=" + dataPartida
				+ ", dataChegada=" + dataChegada + ", formaPagamento=" + formaPagamento + ", valorBilhete="
				+ valorBilhete+", ";
	}
}
