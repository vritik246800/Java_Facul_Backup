public class Individuo implements Comparable<Individuo>
{
	//Indtrumentos usados no acto(Arma branca ou de fogo, tipo)
	private int ctI=0;
	protected String nome, genero, nacionalidade, numeroBI, endereco, numTelefone;
	protected int idade;
	protected int numPessoasEnvolvidas;
	protected String dataOcorrencia, horaOcorrencia;
	public Individuo(String nome, String gen, String nac, String numBI, String end, String numTelefone, int idade, int numPessoasEnvolvidas, String dataOcorrencia, String horaOcorrencia)
	{
		this.endereco = end;
		this.genero = gen;
		this.idade = idade;
		this.nacionalidade=nac;
		this.nome=nome;
		this.numeroBI=numBI;
		this.numTelefone=numTelefone;
		this.numPessoasEnvolvidas = numPessoasEnvolvidas;
		this.dataOcorrencia = dataOcorrencia;
		this.horaOcorrencia = horaOcorrencia;
		ctI++;
	}
	public Individuo()
	{
		this("","","","","","",0,0,"","");
	}
	public String getNome() {return nome;}
	public String getGenero() {return genero;}
	public String getNacionalidade() {return nacionalidade;}
	public String getNumeroBI() {return numeroBI;}
	public String getEndereco() {return endereco;}
	public String getNumTelefone() {return numTelefone;}
	public String getDataOcorrencia() {return dataOcorrencia;}
	public String getHoraOcorrencia() {return horaOcorrencia;}
	public int getIdade() {return idade;} // Added getter for idade, useful for comparison or other logic
	public int getNumPessoasEnvolvidas() {return numPessoasEnvolvidas;}

	public void setNome(String nome) {this.nome = nome;}
	public void setGenero(String genero) {this.genero = genero;}
	public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
	public void setNumeroBI(String numeroBI) {this.numeroBI = numeroBI;}
	public void setEndereco(String endereco) {this.endereco = endereco;}
	public void setNumTelefone(String numTelefone) {this.numTelefone = numTelefone;}
	public void setIdade(int idade) {this.idade = idade;}
	public void setNumPessoasEnvolvidas(int numero) {this.numPessoasEnvolvidas=numero;} // Corrected method name
	public void setHoraOcorrencia(String hora) {this.horaOcorrencia=hora;}
	public void setDataOcorrencia(String data) {this.dataOcorrencia= data;} // Corrected method name to match field

	public String toString()
	{
		return "Nome=" + nome + ", Idade=" + idade + ", BI=" + numeroBI + ", DataOcor=" + dataOcorrencia;
		// Simplified for brevity in tree printouts, can be expanded if needed:
		// return "nome=" + nome + ", genero=" + genero + ", nacionalidade=" + nacionalidade + ", numeroBI="
		//		+ numeroBI + ", endereco=" + endereco + ", numTelefone=" + numTelefone + ", idade=" + idade+ ", Numero de pessoas: "+numPessoasEnvolvidas+", data de ocorrencia: "+dataOcorrencia+", hora de ocorrencia: "+horaOcorrencia;
	}

	@Override
	public int compareTo(Individuo other) {
		// Compare by name, then by numeroBI if names are the same
		// Ensuring nome and numeroBI are not null for comparison
		String thisName = (this.nome == null) ? "" : this.nome;
		String otherName = (other.nome == null) ? "" : other.nome;

		int nameCompare = thisName.compareToIgnoreCase(otherName);
		if (nameCompare != 0) {
			return nameCompare;
		}

		String thisBI = (this.numeroBI == null) ? "" : this.numeroBI;
		String otherBI = (other.numeroBI == null) ? "" : other.numeroBI;
		return thisBI.compareToIgnoreCase(otherBI);
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Individuo individuo = (Individuo) obj;
        // Equality based on the same fields used in compareTo
        String thisName = (this.nome == null) ? "" : this.nome;
		String otherName = (individuo.nome == null) ? "" : individuo.nome;
        String thisBI = (this.numeroBI == null) ? "" : this.numeroBI;
		String otherBI = (individuo.numeroBI == null) ? "" : individuo.numeroBI;

        return thisName.equalsIgnoreCase(otherName) && thisBI.equalsIgnoreCase(otherBI);
    }

    @Override
    public int hashCode() {
        // Hash code based on the same fields used in compareTo and equals
        String thisName = (this.nome == null) ? "" : this.nome;
        String thisBI = (this.numeroBI == null) ? "" : this.numeroBI;
        int result = thisName.toLowerCase().hashCode();
        result = 31 * result + thisBI.toLowerCase().hashCode();
        return result;
    }
}