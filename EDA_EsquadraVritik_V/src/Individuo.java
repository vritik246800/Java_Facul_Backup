
public class Individuo 
{
	protected String nome, genero, nacionalidade, numeroBI, endereco, numTelefone;
	protected int idade;
	public Individuo(String nome, String gen, String nac, String numBI, String end, String numTelefone, int idade)
	{
		this.endereco = end;
		this.genero = gen;
		this.idade = idade;
		this.nacionalidade=nac;
		this.nome=nome;
		this.numeroBI=numBI;
		this.numTelefone=numTelefone;
	}
	public Individuo()
	{
		this("","","","","","",0);
	}
	public String getNome() {return nome;}
	public String getGenero() {return genero;}	
	public String getNacionalidade() {return nacionalidade;}
	public String getNumeroBI() {return numeroBI;}
	public String getEndereco() {return endereco;}
	public String getNumTelefone() {return numTelefone;}
	
	public void setNome(String nome) {this.nome = nome;}
	public void setGenero(String genero) {this.genero = genero;}
	public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
	public void setNumeroBI(String numeroBI) {this.numeroBI = numeroBI;}
	public void setEndereco(String endereco) {this.endereco = endereco;}
	public void setNumTelefone(String numTelefone) {this.numTelefone = numTelefone;}
	public void setIdade(int idade) {this.idade = idade;}
	
	public String toString() 
	{
		return "nome=" + nome + ", genero=" + genero + ", nacionalidade=" + nacionalidade + ", numeroBI="
				+ numeroBI + ", endereco=" + endereco + ", numTelefone=" + numTelefone + ", idade=" + idade;
	}
}
