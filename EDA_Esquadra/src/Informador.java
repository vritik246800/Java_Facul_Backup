public class Informador {
    private String idInformador;
    private String nome;
    private String contato;
    private String observacoes;
    private static int proximoId = 1;

    public Informador(String nome, String contato, String observacoes) {
        this.idInformador = "INF-" + String.format("%03d", proximoId++);
        this.nome = nome;
        this.contato = contato;
        this.observacoes = observacoes;
    }

    // Getters
    public String getIdInformador() { return idInformador; }
    public String getNome() { return nome; }
    public String getContato() { return contato; }
    public String getObservacoes() { return observacoes; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setContato(String contato) { this.contato = contato; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    
    public static void setProximoId(int id) { // For loading data if needed
        proximoId = id;
    }

    @Override
    public String toString() {
        return "--- Informador ID: " + idInformador + " ---\n" +
               "Nome: " + nome + "\n" +
               "Contato: " + contato + "\n" +
               "Observações: " + observacoes + "\n";
    }
}