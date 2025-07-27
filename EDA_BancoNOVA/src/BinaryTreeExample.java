public class BinaryTreeExample {

    // Classe interna para representar um nó da árvore
    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Classe da árvore binária
    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        // Percurso em pré-ordem: raiz, esquerda, direita
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        // Percurso em em-ordem: esquerda, raiz, direita
        void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.value + " ");
                inOrder(node.right);
            }
        }

        // Percurso em pós-ordem: esquerda, direita, raiz
        void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.value + " ");
            }
        }
    }

    // Método principal para execução
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Construindo a árvore:
        //         A
        //       /   \
        //      B     C
        //     / \   / \
        //    D   E F   G

        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        tree.root.right.right = new Node("G");

        // Exibindo os percursos
        System.out.print("Pré-ordem: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("Em-ordem: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.print("Pós-ordem: ");
        tree.postOrder(tree.root);
        System.out.println();
    }
}