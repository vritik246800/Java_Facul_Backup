import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ocorrencia implements Comparable<Ocorrencia> {
    private String idOcorrencia;
    private String tipoOcorrencia;
    private String descricao;
    private LocalDateTime dataHoraOcorrencia;
    private String local;
    private String nomeVitima;
    private String contatoVitima;
    private String nomeSuspeito; // Pode ser "Desconhecido"
    private String statusSuspeito; // "Primário", "Recorrente", "N/A"
    private String instrumentosUsados;
    private String prejuizoMaterial;
    private String prejuizoMoral;
    private String statusCaso; // "Aberto", "Em Investigação", "Fechado", "Anulado"
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    private static int proximoId = 1;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Ocorrencia(String tipoOcorrencia, String descricao, LocalDateTime dataHoraOcorrencia,
                      String local, String nomeVitima, String contatoVitima, String nomeSuspeito,
                      String statusSuspeito, String instrumentosUsados, String prejuizoMaterial,
                      String prejuizoMoral) {
        this.idOcorrencia = "OC-" + String.format("%04d", proximoId++);
        this.tipoOcorrencia = tipoOcorrencia;
        this.descricao = descricao;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
        this.local = local;
        this.nomeVitima = nomeVitima;
        this.contatoVitima = contatoVitima;
        this.nomeSuspeito = nomeSuspeito;
        this.statusSuspeito = statusSuspeito;
        this.instrumentosUsados = instrumentosUsados;
        this.prejuizoMaterial = prejuizoMaterial;
        this.prejuizoMoral = prejuizoMoral;
        this.statusCaso = "Aberto"; // Default status
        this.dataAbertura = LocalDateTime.now();
        this.dataFechamento = null;
    }

    // Getters
    public String getIdOcorrencia() { return idOcorrencia; }
    public String getTipoOcorrencia() { return tipoOcorrencia; }
    public String getDescricao() { return descricao; }
    public LocalDateTime getDataHoraOcorrencia() { return dataHoraOcorrencia; }
    public String getLocal() { return local; }
    public String getNomeVitima() { return nomeVitima; }
    public String getContatoVitima() { return contatoVitima; }
    public String getNomeSuspeito() { return nomeSuspeito; }
    public String getStatusSuspeito() { return statusSuspeito; }
    public String getInstrumentosUsados() { return instrumentosUsados; }
    public String getPrejuizoMaterial() { return prejuizoMaterial; }
    public String getPrejuizoMoral() { return prejuizoMoral; }
    public String getStatusCaso() { return statusCaso; }
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public LocalDateTime getDataFechamento() { return dataFechamento; }

    // Setters (for editing)
    public void setTipoOcorrencia(String tipoOcorrencia) { this.tipoOcorrencia = tipoOcorrencia; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setDataHoraOcorrencia(LocalDateTime dataHoraOcorrencia) { this.dataHoraOcorrencia = dataHoraOcorrencia; }
    public void setLocal(String local) { this.local = local; }
    public void setNomeVitima(String nomeVitima) { this.nomeVitima = nomeVitima; }
    public void setContatoVitima(String contatoVitima) { this.contatoVitima = contatoVitima; }
    public void setNomeSuspeito(String nomeSuspeito) { this.nomeSuspeito = nomeSuspeito; }
    public void setStatusSuspeito(String statusSuspeito) { this.statusSuspeito = statusSuspeito; }
    public void setInstrumentosUsados(String instrumentosUsados) { this.instrumentosUsados = instrumentosUsados; }
    public void setPrejuizoMaterial(String prejuizoMaterial) { this.prejuizoMaterial = prejuizoMaterial; }
    public void setPrejuizoMoral(String prejuizoMoral) { this.prejuizoMoral = prejuizoMoral; }
    
    public void setStatusCaso(String statusCaso) {
        this.statusCaso = statusCaso;
        if (statusCaso.equalsIgnoreCase("Fechado") || statusCaso.equalsIgnoreCase("Anulado")) {
            this.dataFechamento = LocalDateTime.now();
        } else {
            this.dataFechamento = null; // Reset if re-opened
        }
    }
    
    public static void setProximoId(int id) { // For loading data if needed
        proximoId = id;
    }

    @Override
    public String toString() {
        return "--- Ocorrência ID: " + idOcorrencia + " ---\n" +
               "Tipo: " + tipoOcorrencia + "\n" +
               "Descrição: " + descricao + "\n" +
               "Data/Hora: " + (dataHoraOcorrencia != null ? dataHoraOcorrencia.format(DTF) : "N/A") + "\n" +
               "Local: " + local + "\n" +
               "Vítima: " + nomeVitima + " (Contato: " + contatoVitima + ")\n" +
               "Suspeito: " + nomeSuspeito + " (Status: " + statusSuspeito + ")\n" +
               "Instrumentos: " + instrumentosUsados + "\n" +
               "Prejuízo Material: " + prejuizoMaterial + "\n" +
               "Prejuízo Moral: " + prejuizoMoral + "\n" +
               "Status do Caso: " + statusCaso + "\n" +
               "Data Abertura: " + (dataAbertura != null ? dataAbertura.format(DTF) : "N/A") + "\n" +
               "Data Fechamento: " + (dataFechamento != null ? dataFechamento.format(DTF) : "N/A") + "\n";
    }

    @Override
    public int compareTo(Ocorrencia outra) {
        return this.idOcorrencia.compareTo(outra.idOcorrencia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ocorrencia that = (Ocorrencia) obj;
        return idOcorrencia.equals(that.idOcorrencia);
    }

    @Override
    public int hashCode() {
        return idOcorrencia.hashCode();
    }
}