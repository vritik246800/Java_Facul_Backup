import java.io.Serializable;

public class Informador extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    // Add any informant-specific fields if necessary
    // For now, it's identical to Pessoa in terms of data fields

    public Informador(String nome, String bi, String contacto, String endereco) {
        super(nome, bi, contacto, endereco);
    }

    
    public String toString() {
        return "Informador: " + super.toString();
    }
    
    // toFileString and fromFileString are inherited if no new fields
    // If new fields, override them.
}