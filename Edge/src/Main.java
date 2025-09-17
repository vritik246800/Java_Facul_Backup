// --- 4. Classe Main ---
public class Main {
    public static void main(String[] args) {
        String[] cities = {
            "Lichinga", "Nampula", "Tete", "Pemba", "Quelimane", "Beira", "Chimoio"
        };
        Graph graph = new Graph(cities);

        // Adicionar as arestas com os pesos arbitrários
        // (Lichinga, Nampula) - 10
        // (Lichinga, Tete) - 50
        // (Nampula, Pemba) - 15
        // (Nampula, Quelimane) - 20
        // (Pemba, Quelimane) - 45
        // (Quelimane, Tete) - 25
        // (Quelimane, Beira) - 30
        // (Quelimane, Chimoio) - 35
        // (Beira, Chimoio) - 5
        // (Tete, Chimoio) - 40
        graph.addEdge("Lichinga", "Nampula", 10);
        graph.addEdge("Lichinga", "Tete", 50);
        graph.addEdge("Nampula", "Pemba", 15);
        graph.addEdge("Nampula", "Quelimane", 20);
        graph.addEdge("Pemba", "Quelimane", 45);
        graph.addEdge("Quelimane", "Tete", 25);
        graph.addEdge("Quelimane", "Beira", 30);
        graph.addEdge("Quelimane", "Chimoio", 35);
        graph.addEdge("Beira", "Chimoio", 5);
        graph.addEdge("Tete", "Chimoio", 40);

        // d) Imprimir a Matriz de Adjacência
        graph.printAdjacencyMatrix();

        // e) Imprimir as Listas de Adjacência
        graph.printAdjacencyLists();

        // f) Interpretar e implementar os algoritmos de busca em Profundidade
        graph.dfs("Lichinga"); // Pode começar de qualquer cidade

        // g) Interpretar e implementar os algoritmos de busca em Largura
        graph.bfs("Lichinga"); // Pode começar de qualquer cidade

        // h) Algoritmo de PRIM
        graph.primMST("Lichinga"); // Prim pode começar de qualquer cidade

        // i) Algoritmo de Kruskal
        graph.kruskalMST();
    }
}