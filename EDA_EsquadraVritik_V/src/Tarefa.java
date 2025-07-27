import java.util.List;

public class Tarefa implements Comparable<Tarefa> {
    private String codigo;
    private String descricao;
    private String tipo;
    private String vitima;
    private String suspeito;
    private boolean suspeitoRecorrente;
    private List<Objecto> objectos;

    public Tarefa(String codigo, String descricao, String tipo, String vitima, String suspeito, boolean suspeitoRecorrente, List<Objecto> objectos) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.vitima = vitima;
        this.suspeito = suspeito;
        this.suspeitoRecorrente = suspeitoRecorrente;
        this.objectos = objectos;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Tarefa outra) {
        return this.codigo.compareTo(outra.codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Tipo: " + tipo + ", Vítima: " + vitima + ", Suspeito: " + suspeito +
               (suspeitoRecorrente ? " (Recorrente)" : " (Primário)") + ", Descrição: " + descricao;
    }
}