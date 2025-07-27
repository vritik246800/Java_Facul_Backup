public class ArvoreBinaria<T extends Comparable<T>> {
    private No<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(T valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No<T> inserirRec(No<T> raiz, T valor) {
        if (raiz == null) return new No<>(valor);

        int comp = valor.compareTo(raiz.valor);
        if (comp < 0) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (comp > 0) {
            raiz.direita = inserirRec(raiz.direita, valor);
        } else {
            throw new DadoDuplicadoException("Valor duplicado: " + valor);
        }
        return raiz;
    }

    public boolean buscar(T valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No<T> raiz, T valor) {
        if (raiz == null) return false;

        int comp = valor.compareTo(raiz.valor);
        if (comp == 0) return true;
        return comp < 0 ? buscarRec(raiz.esquerda, valor) : buscarRec(raiz.direita, valor);
    }

    public T buscarComErro(T valor) {
        No<T> atual = raiz;
        while (atual != null) {
            int comp = valor.compareTo(atual.valor);
            if (comp == 0) return atual.valor;
            atual = comp < 0 ? atual.esquerda : atual.direita;
        }
        throw new DadoNaoEncontradoException("Valor não encontrado: " + valor);
    }

    public void remover(T valor) {
        if (!buscar(valor))
            throw new DadoNaoEncontradoException("Valor não encontrado para remoção: " + valor);
        raiz = removerRec(raiz, valor);
    }

    private No<T> removerRec(No<T> raiz, T valor) {
        if (raiz == null) return null;

        int comp = valor.compareTo(raiz.valor);
        if (comp < 0) {
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        } else if (comp > 0) {
            raiz.direita = removerRec(raiz.direita, valor);
        } else {
            if (raiz.esquerda == null) return raiz.direita;
            if (raiz.direita == null) return raiz.esquerda;

            No<T> sucessor = encontrarMenor(raiz.direita);
            raiz.valor = sucessor.valor;
            raiz.direita = removerRec(raiz.direita, sucessor.valor);
        }
        return raiz;
    }

    private No<T> encontrarMenor(No<T> no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No<T> no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    public void trocarLados() {
        trocarLadosRec(raiz);
    }

    private void trocarLadosRec(No<T> no) {
        if (no != null) {
            No<T> temp = no.esquerda;
            no.esquerda = no.direita;
            no.direita = temp;

            trocarLadosRec(no.esquerda);
            trocarLadosRec(no.direita);
        }
    }
}