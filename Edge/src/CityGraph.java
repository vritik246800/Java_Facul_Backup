import java.util.*;

public class CityGraph {

    // Constants for graph representation
    private static final int INF = Integer.MAX_VALUE; // Represents no connection in adjacency matrix

    // Data structures for the graph
    private String[] cities; // Array to map integer indices to city names
    private int numCities;   // Total number of cities (vertices)

    // a) & b) Adjacency Matrix representation
    private int[][] adjMatrix;

    // c) Adjacency List representation
    private List<List<Edge>> adjList;

    /**
     * Helper class to represent an edge for Adjacency List and Prim's PriorityQueue.
     * Contains destination vertex and weight.
     */
    private static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        // For debugging/printing
        @Override
        public String toString() {
            return "(" + destination + ", " + weight + ")";
        }
    }

    /**
     * Helper class to represent an edge specifically for Kruskal's algorithm.
     * Includes source, destination, and weight, and implements Comparable for sorting.
     */
    private static class EdgeKruskal implements Comparable<EdgeKruskal> {
        int source;
        int destination;
        int weight;

        public EdgeKruskal(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(EdgeKruskal other) {
            return this.weight - other.weight; // Sort by weight in ascending order
        }
    }

    /**
     * Helper class for Kruskal's Algorithm: Union-Find (Disjoint Set Union) data structure.
     * Used to detect cycles efficiently.
     */
    private static class UnionFind {
        private int[] parent; // parent[i] stores the parent of element i
        private int[] rank;   // rank[i] stores the rank (or size) of the tree rooted at i

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Each element is initially its own parent
                rank[i] = 0;   // Initial rank is 0
            }
        }

        // Finds the representative (root) of the set containing element i
        // with path compression
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Path compression
        }

        // Unites the sets containing elements i and j
        // Returns true if a union occurred, false if they were already in the same set (cycle detected)
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) { // If they are in different sets
                // Union by rank (or size) to keep trees balanced
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else { // Ranks are equal, choose one as root and increment its rank
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                return true; // Union successful
            }
            return false; // Already in the same set, adding this edge would create a cycle
        }
    }

    /**
     * Constructor for the CityGraph.
     * Initializes the graph with city names and sets up empty adjacency structures.
     * @param cityNames An array of city names, where index corresponds to vertex ID.
     */
    public CityGraph(String[] cityNames) {
        this.cities = cityNames;
        this.numCities = cityNames.length;

        // Initialize Adjacency Matrix
        adjMatrix = new int[numCities][numCities];
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0; // Distance to self is 0
                } else {
                    adjMatrix[i][j] = INF; // No direct connection initially
                }
            }
        }

        // Initialize Adjacency List
        adjList = new ArrayList<>(numCities);
        for (int i = 0; i < numCities; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an undirected, weighted edge between two cities (vertices).
     * Updates both the Adjacency Matrix and Adjacency Lists.
     * @param src Source city index.
     * @param dest Destination city index.
     * @param weight Weight (distance/cost) of the edge.
     */
    public void addEdge(int src, int dest, int weight) {
        // Update Adjacency Matrix (undirected graph)
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;

        // Update Adjacency List (undirected graph)
        // Check for existing edge to avoid duplicates (though for initial setup this is less critical)
        // For a simple graph, we assume unique edges between pairs.
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight));
    }

    /**
     * d) Imprime a Matriz de Adjacência em formato matricial natural.
     */
    public void printAdjMatrix() {
        System.out.println("\n--- Matriz de Adjacências ---");
        // Print header row (city names)
        System.out.print("       "); // Spacer for column headers
        for (String city : cities) {
            // Truncate city names for better alignment if they are long
            System.out.printf("%-10s", city.substring(0, Math.min(city.length(), 8)));
        }
        System.out.println();

        // Print matrix rows
        for (int i = 0; i < numCities; i++) {
            // Print row header (city name)
            System.out.printf("%-7s", cities[i].substring(0, Math.min(cities[i].length(), 7)));
            for (int j = 0; j < numCities; j++) {
                if (adjMatrix[i][j] == INF) {
                    System.out.printf("%-10s", "INF"); // "INF" for no direct connection
                } else {
                    System.out.printf("%-10d", adjMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * e) Imprime as Listas de Adjacências.
     */
    public void printAdjList() {
        System.out.println("\n--- Listas de Adjacências ---");
        for (int i = 0; i < numCities; i++) {
            System.out.print(cities[i] + ": ");
            if (adjList.get(i).isEmpty()) {
                System.out.print("Nenhum vizinho");
            } else {
                for (Edge edge : adjList.get(i)) {
                    System.out.print(cities[edge.destination] + "(" + edge.weight + ") ");
                }
            }
            System.out.println();
        }
    }

    /**
     * f) Implementa o algoritmo de busca em Profundidade (DFS - Depth-First Search).
     * @param startNode O índice do vértice de partida.
     */
    public void dfs(int startNode) {
        System.out.println("\n--- Busca em Profundidade (DFS) a partir de " + cities[startNode] + " ---");
        boolean[] visited = new boolean[numCities]; // To keep track of visited vertices
        dfsUtil(startNode, visited);
        System.out.println();
    }

    // Recursive utility function for DFS
    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true; // Mark current node as visited
        System.out.print(cities[node] + " -> "); // Process/print the node

        // Recur for all adjacent vertices
        for (Edge edge : adjList.get(node)) {
            if (!visited[edge.destination]) {
                dfsUtil(edge.destination, visited);
            }
        }
    }

    /**
     * g) Implementa o algoritmo de busca em Largura (BFS - Breadth-First Search).
     * @param startNode O índice do vértice de partida.
     */
    public void bfs(int startNode) {
        System.out.println("\n--- Busca em Largura (BFS) a partir de " + cities[startNode] + " ---");
        boolean[] visited = new boolean[numCities];   // To keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        visited[startNode] = true; // Mark start node as visited
        queue.offer(startNode);    // Add start node to queue

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // Dequeue a vertex
            System.out.print(cities[currentNode] + " -> "); // Process/print the node

            // Get all adjacent vertices of the dequeued vertex
            for (Edge edge : adjList.get(currentNode)) {
                if (!visited[edge.destination]) { // If an adjacent vertex has not been visited
                    visited[edge.destination] = true; // Mark it as visited
                    queue.offer(edge.destination);     // Enqueue it
                }
            }
        }
        System.out.println();
    }

    /**
     * h) Implementa o algoritmo de PRIM para encontrar a Árvore Geradora Mínima (MST).
     * Assume um grafo conectado.
     */
    public void primMST() {
        System.out.println("\n--- Algoritmo de Prim para MST ---");

        // Min-priority queue to store edges (weight, destination_vertex).
        // It stores potential edges to add to the MST, prioritized by weight.
        // The 'destination' field here means the vertex to be added, and 'weight' is the cost
        // of the edge that connects it to the current MST.
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

        boolean[] inMST = new boolean[numCities]; // Tracks vertices already included in MST
        int[] key = new int[numCities];           // key[i] = minimum weight to connect vertex i to the MST
        int[] parent = new int[numCities];        // parent[i] = parent of vertex i in the MST

        // Initialize all keys to infinity, and no parent
        for (int i = 0; i < numCities; i++) {
            key[i] = INF;
            parent[i] = -1; // -1 indicates no parent (or not yet connected)
        }

        // Start Prim's from vertex 0 (can be any arbitrary vertex)
        key[0] = 0; // Cost to connect source to itself is 0
        pq.add(new Edge(0, 0)); // Add (vertex, weight) to PQ. (0,0) represents starting point.

        int mstTotalWeight = 0;
        List<String> mstEdges = new ArrayList<>();
        int edgesCount = 0; // Counter for edges in the MST (should be numCities - 1)

        // Loop until PQ is empty or MST is formed (V-1 edges)
        while (!pq.isEmpty() && edgesCount < numCities - 1) {
            Edge current = pq.poll(); // Extract the vertex with the minimum key value
            int u = current.destination; // This is the vertex to add to MST
            int weightToU = current.weight; // This is the weight of the edge that added 'u'

            if (inMST[u]) {
                continue; // If 'u' is already in MST, skip
            }

            inMST[u] = true; // Add vertex 'u' to MST
            mstTotalWeight += weightToU; // Add the weight of the edge that brought 'u' into MST

            // If 'u' is not the starting vertex (has a parent in MST)
            if (parent[u] != -1) {
                mstEdges.add(cities[parent[u]] + " - " + cities[u] + " (Peso: " + weightToU + ")");
                edgesCount++;
            }

            // Iterate over all neighbors of 'u'
            for (Edge neighborEdge : adjList.get(u)) {
                int v = neighborEdge.destination;
                int edgeWeight = neighborEdge.weight;

                // If 'v' is not in MST AND the edge (u,v) is cheaper than current key[v]
                if (!inMST[v] && edgeWeight < key[v]) {
                    key[v] = edgeWeight; // Update key[v]
                    parent[v] = u;       // Set 'u' as the parent of 'v'
                    pq.add(new Edge(v, edgeWeight)); // Add 'v' to PQ with its new key
                }
            }
        }

        if (edgesCount < numCities - 1) {
            System.out.println("O grafo pode não ser conexo ou ocorreram erros. MST não formada completamente.");
        } else {
            System.out.println("Arestas da MST:");
            for (String edgeStr : mstEdges) {
                System.out.println(edgeStr);
            }
            System.out.println("Peso Total da MST: " + mstTotalWeight);
        }
    }

    /**
     * i) Implementa o algoritmo de Kruskal para encontrar a Árvore Geradora Mínima (MST).
     * Assume um grafo conectado.
     */
    public void kruskalMST() {
        System.out.println("\n--- Algoritmo de Kruskal para MST ---");

        // 1. Collect all edges from the graph
        List<EdgeKruskal> allEdges = new ArrayList<>();
        // Use a set to store unique edge identifiers (e.g., "min(u,v)-max(u,v)")
        // to avoid adding undirected edges twice (e.g., 0-1 and 1-0)
        Set<String> addedEdgeKeys = new HashSet<>();

        for (int i = 0; i < numCities; i++) {
            for (Edge edge : adjList.get(i)) {
                int u = i;
                int v = edge.destination;
                int weight = edge.weight;

                // Create a canonical key for the undirected edge (smaller_vertex-larger_vertex)
                String edgeKey = Math.min(u, v) + "-" + Math.max(u, v);

                if (!addedEdgeKeys.contains(edgeKey)) {
                    allEdges.add(new EdgeKruskal(u, v, weight));
                    addedEdgeKeys.add(edgeKey);
                }
            }
        }

        // 2. Sort all edges by weight in ascending order
        Collections.sort(allEdges);

        // 3. Initialize Union-Find data structure
        UnionFind uf = new UnionFind(numCities);

        List<String> mstEdges = new ArrayList<>();
        int mstTotalWeight = 0;
        int edgesCount = 0; // Number of edges added to MST (should be numCities - 1)

        // 4. Iterate through sorted edges
        for (EdgeKruskal edge : allEdges) {
            // If MST is already formed (V-1 edges), we can stop
            if (edgesCount == numCities - 1) {
                break;
            }

            // Check if adding this edge creates a cycle (i.e., if source and destination are already in the same set)
            if (uf.find(edge.source) != uf.find(edge.destination)) {
                uf.union(edge.source, edge.destination); // If not, unite the sets
                mstEdges.add(cities[edge.source] + " - " + cities[edge.destination] + " (Peso: " + edge.weight + ")");
                mstTotalWeight += edge.weight;
                edgesCount++;
            }
        }

        // Check if the graph was connected and MST was fully formed
        if (edgesCount < numCities - 1) {
            System.out.println("O grafo não é conexo. MST não pode ser formada completamente.");
        } else {
            System.out.println("Arestas da MST:");
            for (String edgeStr : mstEdges) {
                System.out.println(edgeStr);
            }
            System.out.println("Peso Total da MST: " + mstTotalWeight);
        }
    }

    public static void main(String[] args) {
        // Define city names. The index of the city in this array will be its ID.
        String[] cities = {
            "Lichinga",    // 0
            "Nampula",     // 1
            "Tete",        // 2
            "Pemba",       // 3
            "Quelimane",   // 4
            "Beira",       // 5
            "Chimoio"      // 6
        };

        CityGraph graph = new CityGraph(cities);

        // Add edges based on the provided map, with arbitrary weights.
        // You can change these weights. Lower weights are generally preferred for MST.
        graph.addEdge(0, 1, 10); // Lichinga - Nampula
        graph.addEdge(0, 2, 15); // Lichinga - Tete
        graph.addEdge(1, 3, 20); // Nampula - Pemba
        graph.addEdge(1, 4, 25); // Nampula - Quelimane
        graph.addEdge(2, 4, 12); // Tete - Quelimane
        graph.addEdge(2, 6, 18); // Tete - Chimoio
        graph.addEdge(3, 4, 30); // Pemba - Quelimane
        graph.addEdge(4, 5, 8);  // Quelimane - Beira
        graph.addEdge(6, 5, 5);  // Chimoio - Beira (Smallest weight, likely in MST)

        // d) Imprimir a Matriz de Adjacência
        graph.printAdjMatrix();

        // e) Imprimir as Listas de Adjacências
        graph.printAdjList();

        // f) e g) Implementar algoritmos de busca (Profundidade e Largura)
        // Let's start DFS and BFS from Lichinga (index 0)
        graph.dfs(0);
        graph.bfs(0);

        // h) e i) Implementar Algoritmos de Árvore Geradora Mínima (PRIM e KRUSKAL)
        graph.primMST();
        graph.kruskalMST();
    }
}