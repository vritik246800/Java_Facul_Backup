import java.io.Serializable;

public class NoArvore implements Serializable {
    private static final long serialVersionUID = 1L;
    Ocorrencia ocorrencia;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
        this.esquerda = null;
        this.direita = null;
    }
}