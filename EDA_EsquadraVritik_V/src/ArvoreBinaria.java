/*import java.lang.Comparable;
public class ArvoreBinaria<T extends Comparable<T>> {
    private No<T> raiz;

    public void inserir(T valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No<T> inserirRec(No<T> no, T valor) {
        if (no == null) return new No<>(valor);
        int comp = valor.compareTo(no.valor);
        if (comp < 0) no.esquerda = inserirRec(no.esquerda, valor);
        else if (comp > 0) no.direita = inserirRec(no.direita, valor);
        return no;
    }

    public T buscar(T valor) {
        No<T> atual = raiz;
        while (atual != null) {
            int comp = valor.compareTo(atual.valor);
            if (comp == 0) return atual.valor;
            atual = comp < 0 ? atual.esquerda : atual.direita;
        }
        return null;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No<T> no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.println(no.valor);
            emOrdemRec(no.direita);
        }
    }
}*/
public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Individuo individuo) {
        raiz = inserirRecursivo(raiz, individuo);
    }

    private No inserirRecursivo(No no, Individuo individuo) {
        if (no == null) {
            return new No(individuo);
        }

        if (individuo.getNome().compareTo(no.individuo.getNome()) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, individuo);
        } else if (individuo.getNome().compareTo(no.individuo.getNome()) > 0) {
            no.direita = inserirRecursivo(no.direita, individuo);
        }
        
        return no;
    }

    // Método para exibir dados (Exemplo de visualização)
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(No no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.println(no.individuo);
            imprimirEmOrdemRecursivo(no.direita);
        }
    }

    // Classe interna para representar um nó da árvore
    private class No {
        Individuo individuo;
        No esquerda, direita;

        public No(Individuo individuo) {
            this.individuo = individuo;
            this.esquerda = this.direita = null;
        }
    }
}