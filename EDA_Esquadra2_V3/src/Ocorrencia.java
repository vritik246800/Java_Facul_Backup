import java.io.Serializable;

public class Ocorrencia implements Comparable<Ocorrencia>, Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo; // Chave da árvore
    private String tipoOcorrencia;
    private Pessoa vitima;
    private Suspeito suspeito; // Pode ser null
    private String descricao;
    private String dataHora; // Formato "dd/MM/yyyy HH:mm"
    private String local;
    private String status; // "Aberta", "Fechada", "Anulada"
    private int numeroPessoasEnvolvidas;
    private String meiosInstrumentosUsados;
    private String prejuizoMaterial;
    private String prejuizoMoral;


    public Ocorrencia(int codigo, String tipoOcorrencia, Pessoa vitima, Suspeito suspeito,
                      String descricao, String dataHora, String local, String status,
                      int numeroPessoasEnvolvidas, String meiosInstrumentosUsados,
                      String prejuizoMaterial, String prejuizoMoral) {
        this.codigo = codigo;
        this.tipoOcorrencia = tipoOcorrencia;
        this.vitima = vitima;
        this.suspeito = suspeito;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.status = status;
        this.numeroPessoasEnvolvidas = numeroPessoasEnvolvidas;
        this.meiosInstrumentosUsados = meiosInstrumentosUsados;
        this.prejuizoMaterial = prejuizoMaterial;
        this.prejuizoMoral = prejuizoMoral;
    }

    // Getters
    public int getCodigo() { return codigo; }
    public String getTipoOcorrencia() { return tipoOcorrencia; }
    public Pessoa getVitima() { return vitima; }
    public Suspeito getSuspeito() { return suspeito; }
    public String getDescricao() { return descricao; }
    public String getDataHora() { return dataHora; }
    public String getLocal() { return local; }
    public String getStatus() { return status; }
    public int getNumeroPessoasEnvolvidas() { return numeroPessoasEnvolvidas; }
    public String getMeiosInstrumentosUsados() { return meiosInstrumentosUsados; }
    public String getPrejuizoMaterial() { return prejuizoMaterial; }
    public String getPrejuizoMoral() { return prejuizoMoral; }

    // Setters for editing
    public void setTipoOcorrencia(String tipoOcorrencia) { this.tipoOcorrencia = tipoOcorrencia; }
    public void setVitima(Pessoa vitima) { this.vitima = vitima; }
    public void setSuspeito(Suspeito suspeito) { this.suspeito = suspeito; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }
    public void setLocal(String local) { this.local = local; }
    public void setStatus(String status) { this.status = status; }
    public void setNumeroPessoasEnvolvidas(int n) { this.numeroPessoasEnvolvidas = n; }
    public void setMeiosInstrumentosUsados(String m) { this.meiosInstrumentosUsados = m; }
    public void setPrejuizoMaterial(String p) { this.prejuizoMaterial = p; }
    public void setPrejuizoMoral(String p) { this.prejuizoMoral = p; }


    @Override
    public int compareTo(Ocorrencia outra) {
        return Integer.compare(this.codigo, outra.codigo);
    }

    @Override
    public String toString() {
        return "Ocorrência Cód: " + codigo +
               "\n  Tipo: " + tipoOcorrencia +
               "\n  Status: " + status +
               "\n  Data/Hora: " + dataHora + ", Local: " + local +
               "\n  Descrição: " + descricao +
               "\n  Pessoas Envolvidas: " + numeroPessoasEnvolvidas +
               "\n  Meios/Instrumentos: " + meiosInstrumentosUsados +
               "\n  Prejuízo Material: " + prejuizoMaterial +
               "\n  Prejuízo Moral: " + prejuizoMoral +
               "\n  Vítima: " + (vitima != null ? vitima.toString() : "N/A") +
               "\n  Suspeito: " + (suspeito != null ? suspeito.toString() : "Desconhecido") +
               "\n------------------------------------";
    }

    // For saving to file
    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(";")
          .append(tipoOcorrencia).append(";")
          .append(status).append(";")
          .append(dataHora).append(";")
          .append(local).append(";")
          .append(descricao).append(";")
          .append(numeroPessoasEnvolvidas).append(";")
          .append(meiosInstrumentosUsados).append(";")
          .append(prejuizoMaterial).append(";")
          .append(prejuizoMoral).append(";");

        if (vitima != null) {
            sb.append(vitima.toFileString());
        } else {
            sb.append("NA;NA;NA;NA"); // Placeholder for no victim
        }
        sb.append(";");

        if (suspeito != null) {
            sb.append(suspeito.toFileString());
        } else {
            sb.append("NA;NA;NA;NA;false"); // Placeholder for no suspect
        }
        return sb.toString();
    }

    // For loading from file
    public static Ocorrencia fromFileString(String line) {
        String[] parts = line.split(";", -1); // -1 to keep trailing empty strings
        if (parts.length < 16) return null; // Basic check for enough parts

        int codigo = Integer.parseInt(parts[0]);
        String tipo = parts[1];
        String status = parts[2];
        String dataHora = parts[3];
        String local = parts[4];
        String descricao = parts[5];
        int numPessoas = Integer.parseInt(parts[6]);
        String meios = parts[7];
        String prejMaterial = parts[8];
        String prejMoral = parts[9];

        Pessoa vitima = Pessoa.fromFileString(parts, 10); // Nome, BI, Contacto, Endereco
        Suspeito suspeito = Suspeito.fromFileString(parts, 14); // Nome, BI, Contacto, Endereco, Recorrente

        return new Ocorrencia(codigo, tipo, vitima, suspeito, descricao, dataHora, local, status, numPessoas, meios, prejMaterial, prejMoral);
    }
}