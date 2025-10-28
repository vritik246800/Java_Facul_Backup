import java.io.Serializable;

public class Suspeito extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean recorrente; // Primário ou recorrente

    public Suspeito(String nome, String bi, String contacto, String endereco, boolean recorrente) {
        super(nome, bi, contacto, endereco);
        this.recorrente = recorrente;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    @Override
    public String toString() {
        return super.toString() + ", Recorrente: " + (recorrente ? "Sim" : "Não");
    }

    @Override
    public String toFileString() {
        return super.toFileString() + ";" + recorrente;
    }
    
    public static Suspeito fromFileString(String[] parts, int startIndex) {
        if (parts.length < startIndex + 5 || "NA".equals(parts[startIndex])) return null;
        return new Suspeito(parts[startIndex], parts[startIndex+1], parts[startIndex+2], parts[startIndex+3], Boolean.parseBoolean(parts[startIndex+4]));
    }
}