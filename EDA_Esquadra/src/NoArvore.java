public class NoArvore {
    Ocorrencia ocorrencia;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
        this.esquerda = null;
        this.direita = null;
    }
}