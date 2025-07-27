// Classe Empregado
class Empregado {
    private int id;
    private String nome;
    private String cargo;
    private double salario;

    public Empregado(int id, String nome, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Cargo: " + cargo + ", Salário: MZN " + salario;
    }
}
