import java.util.*;
import java.util.function.Consumer; // Added for Consumer

/**
 * Implementação de uma árvore binária simples com métodos de inserção, busca e remoção.
 * Esta classe serve como uma estrutura de dados genérica para o sistema de denúncias policiais.
 * @param <E> Tipo de elemento armazenado na árvore (deve implementar Comparable)
 */
public class BinaryTree<E extends Comparable<E>>
{
    private Node<E> root;

    public BinaryTree()
    {
        this.root = null;
    }

    public BinaryTree(Node<E> root)
    {
        this.root = root;
    }

    public Node<E> getRoot()
    {
        return root;
    }

    /**
     * Insere um elemento na árvore de forma ordenada.
     * @param element O elemento a ser inserido
     */
    public void insert(E element)
    {
        root = insertRec(root, element);
    }

    /**
     * Método recursivo auxiliar para inserção.
     */
    private Node<E> insertRec(Node<E> node, E element)
    {
        // Se o nó atual é nulo, cria um novo nó
        if (node == null) {
            return new Node<>(element);
        }

        // Compara o elemento a ser inserido com o elemento do nó atual
        int compareResult = element.compareTo(node.getElement());

        // Se for menor, insere na subárvore esquerda
        if (compareResult < 0) {
            node.setLeft(insertRec(node.getLeft(), element));
        }
        // Se for maior, insere na subárvore direita
        else if (compareResult > 0) {
            node.setRight(insertRec(node.getRight(), element));
        }
        // Se for igual, não insere (evita duplicatas)

        return node;
    }

    /**
     * Busca um elemento na árvore.
     * @param element O elemento a ser buscado
     * @return true se o elemento for encontrado, false caso contrário
     */
    public boolean search(E element)
    {
        return searchRec(root, element);
    }

    /**
     * Método recursivo auxiliar para busca.
     */
    private boolean searchRec(Node<E> node, E element)
    {
        // Se o nó for nulo, o elemento não existe na árvore
        if (node == null) {
            return false;
        }

        int compareResult = element.compareTo(node.getElement());

        // Se encontrou o elemento
        if (compareResult == 0) {
            return true;
        }

        // Se o elemento é menor, busca na subárvore esquerda
        if (compareResult < 0) {
            return searchRec(node.getLeft(), element);
        }

        // Se o elemento é maior, busca na subárvore direita
        return searchRec(node.getRight(), element);
    }

    /**
     * Busca e retorna um nó contendo o elemento especificado.
     * @param element O elemento a ser buscado
     * @return O nó contendo o elemento ou null se não encontrado
     */
    public Node<E> findNode(E element)
    {
        return findNodeRec(root, element);
    }

    /**
     * Método recursivo auxiliar para encontrar um nó.
     */
    private Node<E> findNodeRec(Node<E> node, E element)
    {
        if (node == null) {
            return null;
        }

        int compareResult = element.compareTo(node.getElement());

        if (compareResult == 0) {
            return node;
        }

        if (compareResult < 0) {
            return findNodeRec(node.getLeft(), element);
        }

        return findNodeRec(node.getRight(), element);
    }

    /**
     * Remove um elemento da árvore.
     * @param element O elemento a ser removido
     */
    public void remove(E element)
    {
        root = removeRec(root, element);
    }

    /**
     * Método recursivo auxiliar para remoção.
     */
    private Node<E> removeRec(Node<E> node, E element)
    {
        // Se o nó for nulo, não há nada para remover
        if (node == null) {
            return null;
        }

        int compareResult = element.compareTo(node.getElement());

        // Se o elemento é menor, continua a busca na subárvore esquerda
        if (compareResult < 0) {
            node.setLeft(removeRec(node.getLeft(), element));
        }
        // Se o elemento é maior, continua a busca na subárvore direita
        else if (compareResult > 0) {
            node.setRight(removeRec(node.getRight(), element));
        }
        // Se encontrou o elemento a ser removido
        else {
            // Caso 1: Nó sem filhos (folha)
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            else if (node.getLeft() == null) {
                return node.getRight();
            }
            else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Caso 3: Nó com dois filhos
            // Encontra o sucessor in-order (menor elemento da subárvore direita)
            E sucessor = findMin(node.getRight());
            node.setElement(sucessor);

            // Remove o sucessor
            node.setRight(removeRec(node.getRight(), sucessor));
        }

        return node;
    }

    /**
     * Encontra o menor elemento em uma subárvore.
     */
    private E findMin(Node<E> node)
    {
        E minValue = node.getElement();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getElement();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * Realiza uma travessia in-order na árvore e aplica uma função em cada elemento.
     * @param consumer A função a ser aplicada em cada elemento
     */
    public void inOrderTraversal(Consumer<E> consumer)
    {
        inOrderTraversal(root, consumer);
    }

    /**
     * Método recursivo auxiliar para travessia in-order.
     */
    private void inOrderTraversal(Node<E> node, Consumer<E> consumer)
    {
        if (node != null) {
            inOrderTraversal(node.getLeft(), consumer);
            consumer.accept(node.getElement());
            inOrderTraversal(node.getRight(), consumer);
        }
    }

    /**
     * Obtém todos os elementos da árvore em uma lista ordenada (in-order).
     * @return Lista contendo todos os elementos da árvore
     */
    public List<E> toList()
    {
        List<E> result = new ArrayList<>();
        inOrderTraversal(result::add);
        return result;
    }

    // Método para imprimir os pais de cada nó
    public void printParents(Node<E> node, Node<E> parent)
    {
        if (node == null) return;

        if (parent == null)
        {
            System.out.println(node.getElement().toString() + " -> Root"); // Use toString() for better output
        }
        else
        {
            System.out.println(node.getElement().toString() + " -> " + parent.getElement().toString()); // Use toString()
        }

        printParents(node.getLeft(), node);
        printParents(node.getRight(), node);
    }

    // Método para imprimir os filhos de cada nó (BFS)
    public void printChildren(Node<E> root)
    {
        if (root == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node<E> node = queue.poll();
            System.out.print(node.getElement().toString() + " -> "); // Use toString()

            if (node.getLeft() != null)
            {
                System.out.print(node.getLeft().getElement().toString() + " "); // Use toString()
                queue.add(node.getLeft());
            }
            if (node.getRight() != null)
            {
                System.out.print(node.getRight().getElement().toString() + " "); // Use toString()
                queue.add(node.getRight());
            }

            System.out.println();
        }
    }

    // Método para imprimir os nós folha
    public void printLeafNodes(Node<E> node)
    {
        if (node == null) return;

        if (node.isLeaf())
        {
            System.out.print(node.getElement().toString() + " "); // Use toString()
        }

        printLeafNodes(node.getLeft());
        printLeafNodes(node.getRight());
    }

    // Método para imprimir os graus (número de filhos)
    public void printDegrees(Node<E> node)
    {
        if (node == null) return;

        int degree = 0;
        if (node.getLeft() != null) degree++;
        if (node.getRight() != null) degree++;

        System.out.println(node.getElement().toString() + ": " + degree); // Use toString()

        printDegrees(node.getLeft());
        printDegrees(node.getRight());
    }

    /**
     * Verifica se a árvore está vazia.
     * @return true se a árvore estiver vazia, false caso contrário
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Retorna a altura da árvore.
     * @return A altura da árvore
     */
    public int height()
    {
        return height(root);
    }

    /**
     * Método recursivo auxiliar para calcular a altura.
     */
    private int height(Node<E> node)
    {
        if (node == null) {
            return -1; // Height of an empty tree is -1, height of a single node tree is 0
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Limpa a árvore, removendo todos os elementos.
     */
    public void clear()
    {
        root = null;
    }
}