import java.io.Serializable;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String nome;
    protected String bi; // Documento de Identificação
    protected String contacto;
    protected String endereco;

    public Pessoa(String nome, String bi, String contacto, String endereco) {
        this.nome = nome;
        this.bi = bi;
        this.contacto = contacto;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() { return nome; }
    public String getBi() { return bi; }
    public String getContacto() { return contacto; }
    public String getEndereco() { return endereco; }

    // Setters (if needed for editing)
    public void setNome(String nome) { this.nome = nome; }
    public void setBi(String bi) { this.bi = bi; }
    public void setContacto(String contacto) { this.contacto = contacto; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", BI: " + bi + ", Contacto: " + contacto + ", Endereço: " + endereco;
    }

    public String toFileString() {
        return nome + ";" + bi + ";" + contacto + ";" + endereco;
    }

    public static Pessoa fromFileString(String[] parts, int startIndex) {
        if (parts.length < startIndex + 4 || "NA".equals(parts[startIndex])) return null;
        return new Pessoa(parts[startIndex], parts[startIndex+1], parts[startIndex+2], parts[startIndex+3]);
    }
}