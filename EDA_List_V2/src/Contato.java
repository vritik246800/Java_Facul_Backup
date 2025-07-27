// Classe Contato
public class Contato 
{
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) 
    {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() 
    {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
} 