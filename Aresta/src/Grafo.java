// Ficheiro: Grafo.java
import java.util.*;

public class Grafo {

    // Estrutura para a lista de adjacências
    private static class Vizinho {
        String nome;
        int peso;

        Vizinho(String nome, int peso) {
            this.nome = nome;
            this.peso = peso;
        }

        @Override
        public String toString() {
            return String.format("%s(%d)", nome, peso);
        }
    }

    private final Map<String, Integer> cidadeParaIndice = new HashMap<>();
    private final List<String> indiceParaCidade = new ArrayList<>();
    private final int numVertices;

    // Representações do Grafo
    private final int[][] matrizAdjacencia;
    private final Map<String, List<Vizinho>> listaAdjacencia = new HashMap<>();
    private final List<Aresta> todasArestas = new ArrayList<>();

    public Grafo(List<String> cidades) {
        this.numVertices = cidades.size();
        this.matrizAdjacencia = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            String cidade = cidades.get(i);
            cidadeParaIndice.put(cidade, i);
            indiceParaCidade.add(cidade);
            listaAdjacencia.put(cidade, new LinkedList<>());
        }
    }

    public void adicionarAresta(String cidade1, String cidade2, int peso) {
        if (!cidadeParaIndice.containsKey(cidade1) || !cidadeParaIndice.containsKey(cidade2)) {
            System.err.println("Erro: Uma ou ambas as cidades não existem no grafo.");
            return;
        }
        int idx1 = cidadeParaIndice.get(cidade1);
        int idx2 = cidadeParaIndice.get(cidade2);

        // Matriz de Adjacência (grafo não orientado)
        matrizAdjacencia[idx1][idx2] = peso;
        matrizAdjacencia[idx2][idx1] = peso;

        // Lista de Adjacência (grafo não orientado)
        listaAdjacencia.get(cidade1).add(new Vizinho(cidade2, peso));
        listaAdjacencia.get(cidade2).add(new Vizinho(cidade1, peso));

        // Lista global de arestas (para Kruskal)
        todasArestas.add(new Aresta(cidade1, cidade2, peso));
    }

    // d) Imprimir a Matriz de Adjacência
    public void imprimirMatrizAdjacencia() {
        System.out.print("        ");
        for (String cidade : indiceParaCidade) {
            System.out.printf("%-10s", cidade);
        }
        System.out.println("\n-------------------------------------------------------------------------------------");

        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%-8s| ", indiceParaCidade.get(i));
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%-10d", matrizAdjacencia[i][j]);
            }
            System.out.println();
        }
    }

    // e) Imprimir as Listas de Adjacências
    public void imprimirListasAdjacencia() {
        for (String cidade : indiceParaCidade) {
            System.out.println(cidade + " -> " + listaAdjacencia.get(cidade));
        }
    }

    // f) Busca em Profundidade (DFS)
    public void buscaProfundidade(String cidadeInicial) 
    {
        Set<String> visitados = new LinkedHashSet<>();
        dfsRecursivo(cidadeInicial, visitados);
        System.out.println();
    }

    private void dfsRecursivo(String cidade, Set<String> visitados) {
        visitados.add(cidade);
        System.out.print(cidade + " -> ");
        for (Vizinho vizinho : listaAdjacencia.get(cidade)) {
            if (!visitados.contains(vizinho.nome)) {
                dfsRecursivo(vizinho.nome, visitados);
            }
        }
    }

    // g) Busca em Largura (BFS)
    public void buscaLargura(String cidadeInicial) {
        Set<String> visitados = new LinkedHashSet<>();
        Queue<String> fila = new LinkedList<>();

        visitados.add(cidadeInicial);
        fila.add(cidadeInicial);

        while (!fila.isEmpty()) {
            String cidade = fila.poll();
            System.out.print(cidade + " -> ");

            for (Vizinho vizinho : listaAdjacencia.get(cidade)) {
                if (!visitados.contains(vizinho.nome)) {
                    visitados.add(vizinho.nome);
                    fila.add(vizinho.nome);
                }
            }
        }
        System.out.println();
    }

    // h) Algoritmo de Prim
    public void algoritmoPrim() {
        // Armazena a Árvore Geradora Mínima (AGM)
        Map<String, String> arestasAGM = new HashMap<>();
        // Armazena o peso mínimo para alcançar cada vértice
        Map<String, Integer> pesosMinimos = new HashMap<>();
        // Mantém os vértices já incluídos na AGM
        Set<String> incluidosAGM = new HashSet<>();
        // Fila de prioridade para obter a aresta de menor peso
        PriorityQueue<Vizinho> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(v -> v.peso));

        // Inicialização
        for (String cidade : cidadeParaIndice.keySet()) {
            pesosMinimos.put(cidade, Integer.MAX_VALUE);
        }

        String cidadeInicial = indiceParaCidade.get(0);
        pesosMinimos.put(cidadeInicial, 0);
        filaPrioridade.add(new Vizinho(cidadeInicial, 0));
        arestasAGM.put(cidadeInicial, null); // O nó inicial não tem pai

        int custoTotal = 0;
        List<String> resultado = new ArrayList<>();

        while (!filaPrioridade.isEmpty()) {
            String cidadeAtual = filaPrioridade.poll().nome;

            if (incluidosAGM.contains(cidadeAtual)) continue;

            incluidosAGM.add(cidadeAtual);
            custoTotal += pesosMinimos.get(cidadeAtual);
            
            String pai = arestasAGM.get(cidadeAtual);
            if (pai != null) {
                resultado.add(String.format("(%s - %s, Peso: %d)", pai, cidadeAtual, pesosMinimos.get(cidadeAtual)));
            }
            
            for (Vizinho vizinho : listaAdjacencia.get(cidadeAtual)) {
                if (!incluidosAGM.contains(vizinho.nome) && vizinho.peso < pesosMinimos.get(vizinho.nome)) {
                    pesosMinimos.put(vizinho.nome, vizinho.peso);
                    arestasAGM.put(vizinho.nome, cidadeAtual);
                    filaPrioridade.add(new Vizinho(vizinho.nome, vizinho.peso));
                }
            }
        }
        
        System.out.println("Arestas na Árvore Geradora Mínima (Prim):");
        resultado.forEach(System.out::println);
        System.out.println("Custo Total da AGM: " + custoTotal);
    }
    
    // i) Algoritmo de Kruskal
    public void algoritmoKruskal() {
        List<Aresta> agm = new ArrayList<>();
        // Ordena todas as arestas pelo peso em ordem crescente
        Collections.sort(todasArestas);

        DSU dsu = new DSU(cidadeParaIndice.keySet());
        
        int custoTotal = 0;

        for (Aresta aresta : todasArestas) {
            String raizOrigem = dsu.find(aresta.origem);
            String raizDestino = dsu.find(aresta.destino);

            // Se não formam um ciclo, adiciona à AGM
            if (!raizOrigem.equals(raizDestino)) {
                agm.add(aresta);
                dsu.union(aresta.origem, aresta.destino);
                custoTotal += aresta.peso;
            }
        }

        System.out.println("Arestas na Árvore Geradora Mínima (Kruskal):");
        agm.forEach(System.out::println);
        System.out.println("Custo Total da AGM: " + custoTotal);
    }
}