import java.io.*;
import java.util.ArrayList; // For casting in construirArvore

public class Main {
    private static TodosIndividuos sistema;
    private static BinaryTree<Individuo> arvorePrincipal; // Changed to BinaryTree<Individuo>

    public static void main(String[] args) throws IOException
    {
    	sistema = new TodosIndividuos();
    	arvorePrincipal = new BinaryTree<>(); // Initialize the main tree
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcao=0;

        do {
            System.out.println("\n|==================== MENU DE DENÚNCIAS ==================|");
            System.out.println("| 1. Ler dados do arquivo                                 |");
            System.out.println("| 2. Nova denúncia                                        |");
            System.out.println("| 3. Ver todos os dados (da lista)                        |");
            System.out.println("| 4. Construir/Reconstruir árvore com dados carregados    |");
            System.out.println("| 5. Ver pais dos nós (da árvore principal)               |");
            System.out.println("| 6. Ver filhos dos nós (da árvore principal)             |");
            System.out.println("| 7. Ver folhas da árvore (da árvore principal)           |");
            System.out.println("| 8. Ver graus dos nós (da árvore principal)              |");
            System.out.println("| 9. Ver dados da árvore (In-Order Traversal)             |");
            System.out.println("| 10. Sair                                                |");
            System.out.println("| Escolha uma opção:                                      |");
            System.out.println("|=========================================================|");
            try
            {
                opcao = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    sistema.lerDados(); // This now also populates sistema.arvoreIndividuos
                                        // To reflect this in arvorePrincipal, call construirArvore or copy:
                                        // arvorePrincipal = sistema.getArvoreIndividuos(); // if shared instance is okay
                                        // OR rebuild arvorePrincipal:
                    construirArvoreComDadosCarregados(); // Automatically build/rebuild arvorePrincipal
                    break;
                case 2:
                    sistema.novaDenucia(); // This also populates sistema.arvoreIndividuos
                                           // To reflect this in arvorePrincipal:
                    construirArvoreComDadosCarregados(); // Rebuild arvorePrincipal to include new data
                    break;
                case 3:
                    sistema.adaptarVerTodosDados();
                    break;
                case 4:
                    construirArvoreComDadosCarregados();
                    break;
                case 5:
                    if (!arvorePrincipal.isEmpty()) {
                        System.out.println("Pais dos nós (Árvore Principal):");
                        arvorePrincipal.printParents(arvorePrincipal.getRoot(), null);
                    } else {
                        System.out.println("Árvore principal está vazia. Carregue dados e construa a árvore (Opção 1 ou 4).");
                    }
                    break;
                case 6:
                    if (!arvorePrincipal.isEmpty()) {
                        System.out.println("Filhos dos nós (Árvore Principal):");
                        arvorePrincipal.printChildren(arvorePrincipal.getRoot());
                    } else {
                        System.out.println("Árvore principal está vazia.");
                    }
                    break;
                case 7:
                    if (!arvorePrincipal.isEmpty()) {
                        System.out.println("Nós folha (Árvore Principal):");
                        arvorePrincipal.printLeafNodes(arvorePrincipal.getRoot());
                        System.out.println();
                    } else {
                        System.out.println("Árvore principal está vazia.");
                    }
                    break;
                case 8:
                    if (!arvorePrincipal.isEmpty()) {
                        System.out.println("Grau dos nós (Árvore Principal):");
                        arvorePrincipal.printDegrees(arvorePrincipal.getRoot());
                    } else {
                        System.out.println("Árvore principal está vazia.");
                    }
                    break;
                case 9:
                    if(!arvorePrincipal.isEmpty()){
                        System.out.println("Dados da Árvore Principal (In-Order):");
                        arvorePrincipal.inOrderTraversal(individuo -> System.out.println(individuo.toString()));
                    } else {
                        System.out.println("Árvore principal está vazia.");
                    }
                    // Original case 9 was a placeholder for "Teste de implementacao"
                	// sistema.editarocorrencia(); // This method doesn't exist
                	break;
                case 10:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao!=10);
    }

    /**
     * Constrói ou reconstrói a arvorePrincipal usando os Individuo objetos
     * da lista em TodosIndividuos.
     */
    public static void construirArvoreComDadosCarregados()
    {
        if (sistema == null || sistema.getLista() == null || sistema.getLista().isEmpty()) {
            System.out.println("Não há dados carregados no sistema para construir a árvore.");
            arvorePrincipal = new BinaryTree<>(); // Reset to empty tree
            return;
        }

        arvorePrincipal = new BinaryTree<>(); // Start with a fresh tree
        ArrayList<Individuo> individuos = sistema.getLista();
        for (Individuo ind : individuos) {
            if (ind != null) { // Ensure individual object is not null
                 arvorePrincipal.insert(ind);
            }
        }

        if (!arvorePrincipal.isEmpty()) {
            System.out.println("Árvore principal construída/reconstruída com base nos dados carregados.");
        } else {
            System.out.println("Árvore principal foi reinicializada, mas está vazia (nenhum Individuo válido na lista do sistema?).");
        }
    }
}