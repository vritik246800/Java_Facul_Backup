import java.util.*;

// --- 1. Classe Edge ---
class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "(" + source + "->" + destination + ", W:" + weight + ")";
    }
}

// --- 2. Classe DisjointSetUnion (para Kruskal) ---
class DisjointSetUnion {
    int[] parent;
    int[] rank; // Used for optimization (union by rank)

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element is its own parent initially
            rank[i] = 0;   // All ranks are 0 initially
        }
    }

    // Find operation with path compression
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    // Union operation by rank
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++; // Increment rank if roots have same rank
            }
        }
    }
}


// --- 3. Classe Graph ---
class Graph {
    private int numVertices;
    private String[] cities;
    private int[][] adjMatrix;
    private List<List<Edge>> adjLists;
    private List<Edge> allEdges; // For Kruskal's algorithm

    public Graph(String[] cities) {
        this.cities = cities;
        this.numVertices = cities.length;
        adjMatrix = new int[numVertices][numVertices]; // Initialized to 0 by default
        adjLists = new ArrayList<>(numVertices);
        allEdges = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjLists.add(new ArrayList<>());
        }
    }

    public void addEdge(String sourceCity, String destCity, int weight) {
        int sourceIndex = getCityIndex(sourceCity);
        int destIndex = getCityIndex(destCity);

        if (sourceIndex == -1 || destIndex == -1) {
            System.err.println("Cidade inválida: " + sourceCity + " ou " + destCity);
            return;
        }

        // For Adjacency Matrix (undirected)
        adjMatrix[sourceIndex][destIndex] = weight;
        adjMatrix[destIndex][sourceIndex] = weight;

        // For Adjacency Lists (undirected)
        adjLists.get(sourceIndex).add(new Edge(sourceIndex, destIndex, weight));
        adjLists.get(destIndex).add(new Edge(destIndex, sourceIndex, weight));

        // For Kruskal's (add only one direction for edges to avoid duplicates in allEdges list)
        // Kruskal works with a list of unique edges, sorted by weight.
        // We ensure source < destination to avoid adding (A,B) and (B,A) as distinct edges.
        if (sourceIndex < destIndex) {
            allEdges.add(new Edge(sourceIndex, destIndex, weight));
        } else {
             allEdges.add(new Edge(destIndex, sourceIndex, weight));
        }

    }

    private int getCityIndex(String cityName) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equalsIgnoreCase(cityName)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public String getCityName(int index) {
        if (index >= 0 && index < numVertices) {
            return cities[index];
        }
        return "Inválido";
    }

    // --- d) Imprimir a Matriz de Adjacência ---
    public void printAdjacencyMatrix() {
        System.out.println("\n--- Matriz de Adjacência ---");
        // Print header row
        System.out.print("    ");
        for (String city : cities) {
            System.out.printf("%-10s", city.substring(0, Math.min(city.length(), 8))); // Abbreviate for display
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%-4s", cities[i].substring(0, Math.min(cities[i].length(), 4))); // Abbreviate for display
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%-10s", adjMatrix[i][j] == 0 ? "-" : adjMatrix[i][j]); // Use '-' for no connection
            }
            System.out.println();
        }
    }

    // --- e) Imprimir as Listas de Adjacência ---
    public void printAdjacencyLists() {
        System.out.println("\n--- Listas de Adjacência ---");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(cities[i] + ": ");
            for (Edge edge : adjLists.get(i)) {
                System.out.print("(" + cities[edge.destination] + ", W:" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // --- f) Algoritmo de Busca em Profundidade (DFS) ---
    public void dfs(String startCityName) {
        System.out.println("\n--- Busca em Profundidade (DFS) a partir de " + startCityName + " ---");
        int startIndex = getCityIndex(startCityName);
        if (startIndex == -1) {
            System.out.println("Cidade inicial inválida.");
            return;
        }

        boolean[] visited = new boolean[numVertices];
        List<String> path = new ArrayList<>();
        dfsRecursive(startIndex, visited, path);
        System.out.println("Caminho DFS: " + String.join(" -> ", path));
    }

    private void dfsRecursive(int vertex, boolean[] visited, List<String> path) {
        visited[vertex] = true;
        path.add(getCityName(vertex));

        for (Edge edge : adjLists.get(vertex)) {
            if (!visited[edge.destination]) {
                dfsRecursive(edge.destination, visited, path);
            }
        }
    }

    // --- g) Algoritmo de Busca em Largura (BFS) ---
    public void bfs(String startCityName) {
        System.out.println("\n--- Busca em Largura (BFS) a partir de " + startCityName + " ---");
        int startIndex = getCityIndex(startCityName);
        if (startIndex == -1) {
            System.out.println("Cidade inicial inválida.");
            return;
        }

        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            path.add(getCityName(currentVertex));

            for (Edge edge : adjLists.get(currentVertex)) {
                if (!visited[edge.destination]) {
                    visited[edge.destination] = true;
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println("Caminho BFS: " + String.join(" -> ", path));
    }

    // --- h) Algoritmo de Prim ---
    // Finds the Minimum Spanning Tree (MST)
    public void primMST(String startCityName) {
        System.out.println("\n--- Algoritmo de Prim (MST) a partir de " + startCityName + " ---");
        int startIndex = getCityIndex(startCityName);
        if (startIndex == -1) {
            System.out.println("Cidade inicial inválida.");
            return;
        }

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[numVertices];
        // To store constructed MST
        int[] parent = new int[numVertices];
        // To represent set of vertices already included in MST
        boolean[] inMST = new boolean[numVertices];

        // Initialize all keys as INFINITE and inMST as false
        for (int i = 0; i < numVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        // Always include first vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex.
        key[startIndex] = 0;
        parent[startIndex] = -1; // First node is always root of MST

        List<String> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        // The MST will have V vertices
        for (int count = 0; count < numVertices; count++) {
            // Pick the minimum key vertex from the set of vertices
            // not yet included in MST
            int u = -1;
            int minKey = Integer.MAX_VALUE;
            for (int v = 0; v < numVertices; v++) {
                if (!inMST[v] && key[v] < minKey) {
                    minKey = key[v];
                    u = v;
                }
            }

            if (u == -1) { // Should not happen in a connected graph
                System.out.println("Grafo desconexo ou erro em Prim.");
                break;
            }

            inMST[u] = true;

            // Add edge to MST if it's not the start node itself
            if (parent[u] != -1) {
                String edgeString = String.format("%s --(%d)--> %s",
                                                getCityName(parent[u]), adjMatrix[u][parent[u]], getCityName(u));
                mstEdges.add(edgeString);
                totalWeight += adjMatrix[u][parent[u]];
            }

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < numVertices; v++) {
                // adjMatrix[u][v] is non zero only for adjacent vertices of u
                // inMST[v] is false for vertices not yet included in MST
                // Update the key only if adjMatrix[u][v] is smaller than key[v]
                if (adjMatrix[u][v] != 0 && !inMST[v] && adjMatrix[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adjMatrix[u][v];
                }
            }
        }

        System.out.println("Arestas na Árvore Geradora Mínima (MST):");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Custo Total da MST (Prim): " + totalWeight);
    }

    // --- i) Algoritmo de Kruskal ---
    // Finds the Minimum Spanning Tree (MST)
    public void kruskalMST() {
        System.out.println("\n--- Algoritmo de Kruskal (MST) ---");

        // 1. Create a list of all edges and sort them by weight
        List<Edge> sortedEdges = new ArrayList<>(allEdges);
        Collections.sort(sortedEdges); // Uses the compareTo method in Edge

        // 2. Initialize Disjoint Set Union for all vertices
        DisjointSetUnion dsu = new DisjointSetUnion(numVertices);

        List<String> mstEdges = new ArrayList<>();
        int totalWeight = 0;
        int edgesCount = 0;

        // 3. Iterate through sorted edges
        for (Edge edge : sortedEdges) {
            // Check if adding this edge forms a cycle
            if (dsu.find(edge.source) != dsu.find(edge.destination)) {
                // If not, add it to MST
                mstEdges.add(String.format("%s --(%d)--> %s",
                                            getCityName(edge.source), edge.weight, getCityName(edge.destination)));
                totalWeight += edge.weight;
                dsu.union(edge.source, edge.destination); // Union the two sets
                edgesCount++;

                // Stop if we have V-1 edges (a connected graph's MST has V-1 edges)
                if (edgesCount == numVertices - 1) {
                    break;
                }
            }
        }

        if (edgesCount < numVertices - 1) {
            System.out.println("O grafo não é conexo e uma MST não pode ser formada para todos os vértices.");
        }

        System.out.println("Arestas na Árvore Geradora Mínima (MST):");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Custo Total da MST (Kruskal): " + totalWeight);
    }
}

