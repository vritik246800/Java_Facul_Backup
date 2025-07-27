// Implementação com Lista Encadeada
class ListaEncadeada<T> implements Lista<T> 
{
    private class Nodo 
    {
        T elemento;
        Nodo proximo;
        Nodo(T elemento) 
        {
            this.elemento = elemento;
        }
    }

    private Nodo cabeca;  // Representa o início da lista
    private int quantidade;  // Quantidade de elementos na lista

    @Override
    public void createEmptyList() 
    {
        cabeca = null;
        quantidade = 0;
    }

    @Override
    public void add(T elemento) 
    {
        Nodo novoNodo = new Nodo(elemento);  // Cria um novo nodo

        if (cabeca == null) 
        {
            cabeca = novoNodo;  // Se a lista estiver vazia, o novo nodo é o primeiro
        } 
        else 
        {
            Nodo nodoAtual = cabeca;
            while (nodoAtual.proximo != null) nodoAtual = nodoAtual.proximo;  // Vai até o final da lista
            nodoAtual.proximo = novoNodo;  // Adiciona o novo nodo ao final da lista
        }
        quantidade++;
    }

    @Override
    public void add(int posicao, T elemento) 
    {
        if (posicao < 1 || posicao > quantidade + 1) throw new PosicaoInvalidaException("Posição inválida");

        Nodo novoNodo = new Nodo(elemento);  // Cria o novo nodo

        if (posicao == 1) {
            novoNodo.proximo = cabeca;  // Se for a primeira posição, ajusta o ponteiro para a cabeça da lista
            cabeca = novoNodo;  // O novo nodo se torna o primeiro
        } else {
            Nodo nodoAnterior = cabeca;
            for (int i = 1; i < posicao - 1; i++) nodoAnterior = nodoAnterior.proximo;  // Vai até o nodo anterior à posição desejada
            novoNodo.proximo = nodoAnterior.proximo;  // O novo nodo aponta para o nodo da posição seguinte
            nodoAnterior.proximo = novoNodo;  // O nodo anterior aponta para o novo nodo
        }
        quantidade++;
    }

    @Override
    public T get(int posicao)
    {
        if (posicao < 1 || posicao > quantidade) throw new PosicaoInvalidaException("Posição inválida");
        Nodo nodoAtual = cabeca;
        for (int i = 1; i < posicao; i++) nodoAtual = nodoAtual.proximo;  // Vai até o nodo na posição solicitada
        return nodoAtual.elemento;  // Retorna o elemento encontrado
    }

    @Override
    public void remove(int posicao) 
    {
        if (quantidade == 0) throw new ListaVaziaException("Lista vazia");
        if (posicao < 1 || posicao > quantidade) throw new PosicaoInvalidaException("Posição inválida");

        if (posicao == 1) {
            cabeca = cabeca.proximo;  // Se for a primeira posição, a cabeça da lista é alterada para o próximo nodo
        } else {
            Nodo nodoAnterior = cabeca;
            for (int i = 1; i < posicao - 1; i++) nodoAnterior = nodoAnterior.proximo;  // Vai até o nodo anterior ao desejado
            nodoAnterior.proximo = nodoAnterior.proximo.proximo;  // O nodo anterior aponta para o próximo do próximo, removendo o nodo atual
        }
        quantidade--;
    }

    @Override
    public int size() 
    {
        return quantidade;  // Retorna a quantidade de elementos na lista
    }

    @Override
    public void listar()
    {
        Nodo nodoAtual = cabeca;
        int posicao = 1;
        while (nodoAtual != null)
        {
            System.out.println("Posição " + posicao + ": " + nodoAtual.elemento);  // Imprime o elemento e a posição
            nodoAtual = nodoAtual.proximo;  // Vai para o próximo nodo
            posicao++;
        }
    }
}
