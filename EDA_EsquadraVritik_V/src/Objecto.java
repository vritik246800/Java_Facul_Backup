public class Objecto
{
    private String nome;
    private String tipo;
    private double valorEstimado;

    public Objecto(String nome, String tipo, double valorEstimado) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorEstimado = valorEstimado;
    }

    @Override
    public String toString() {
        return nome + " (" + tipo + "), Valor: " + valorEstimado;
    }
}