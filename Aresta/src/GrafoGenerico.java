// Ficheiro: GrafoGenerico.java
import java.util.*;
import java.util.function.Function;

public class GrafoGenerico<T> {

    // Estrutura para a lista de adjacências
    private static class Vizinho<T> {
        T objeto;
        int peso;

        Vizinho(T objeto, int peso) {
            this.objeto = objeto;
            this.peso = peso;
        }
        public String toString() {
            return String.format("%s(%d)", objeto.toString(), peso);
        }
    }

    private final Map<T, Integer> objetoParaIndice = new HashMap<>();
    private final List<T> indiceParaObjeto = new ArrayList<>();
    private final int numVertices;

    // Representações do Grafo
    private final int[][] matrizAdjacencia;
    private final Map<T, List<Vizinho<T>>> listaAdjacencia = new HashMap<>();
    private final List<ArestaGenerica<T>> todasArestas = new ArrayList<>();

    // Função para converter objetos em strings para display
    private final Function<T, String> displayFunction;

    // Construtor principal
    public GrafoGenerico(List<T> objetos, Function<T, String> displayFunction) {
        this.numVertices = objetos.size();
        this.matrizAdjacencia = new int[numVertices][numVertices];
        this.displayFunction = displayFunction != null ? displayFunction : T::toString;

        for (int i = 0; i < numVertices; i++) {
            T objeto = objetos.get(i);
            objetoParaIndice.put(objeto, i);
            indiceParaObjeto.add(objeto);
            listaAdjacencia.put(objeto, new LinkedList<>());
        }
    }

    // Construtor simplificado (usa toString() por padrão)
    public GrafoGenerico(List<T> objetos) {
        this(objetos, null);
    }

    // Adicionar vértice dinamicamente
    public void adicionarVertice(T objeto) {
        if (objetoParaIndice.containsKey(objeto)) {
            System.err.println("Erro: O objeto já existe no grafo.");
            return;
        }
        
        objetoParaIndice.put(objeto, indiceParaObjeto.size());
        indiceParaObjeto.add(objeto);
        listaAdjacencia.put(objeto, new LinkedList<>());
        
        // Expandir matriz de adjacência
        expandirMatrizAdjacencia();
    }

    // Remover vértice
    public void removerVertice(T objeto) {
        if (!objetoParaIndice.containsKey(objeto)) {
            System.err.println("Erro: O objeto não existe no grafo.");
            return;
        }

        // Remover todas as arestas conectadas a este vértice
        List<T> vizinhos = new ArrayList<>();
        for (Vizinho<T> vizinho : listaAdjacencia.get(objeto)) {
            vizinhos.add(vizinho.objeto);
        }
        
        for (T vizinho : vizinhos) {
            removerAresta(objeto, vizinho);
        }

        // Remover o vértice das estruturas
        int indiceRemovido = objetoParaIndice.get(objeto);
        objetoParaIndice.remove(objeto);
        indiceParaObjeto.remove(indiceRemovido);
        listaAdjacencia.remove(objeto);

        // Reindexar os objetos
        reindexarObjetos();
    }

    private void expandirMatrizAdjacencia() {
        int novoTamanho = indiceParaObjeto.size();
        // A matriz já tem o tamanho fixo, seria necessário recriar para expansão dinâmica
        // Por simplicidade, manteremos o tamanho inicial fixo
    }

    private void reindexarObjetos() {
        objetoParaIndice.clear();
        for (int i = 0; i < indiceParaObjeto.size(); i++) {
            objetoParaIndice.put(indiceParaObjeto.get(i), i);
        }
    }

    public void adicionarAresta(T objeto1, T objeto2, int peso) {
        if (!objetoParaIndice.containsKey(objeto1) || !objetoParaIndice.containsKey(objeto2)) {
            System.err.println("Erro: Um ou ambos os objetos não existem no grafo.");
            return;
        }
        
        int idx1 = objetoParaIndice.get(objeto1);
        int idx2 = objetoParaIndice.get(objeto2);

        // Verificar se os índices estão dentro dos limites da matriz
        if (idx1 < numVertices && idx2 < numVertices) {
            // Matriz de Adjacência (grafo não orientado)
            matrizAdjacencia[idx1][idx2] = peso;
            matrizAdjacencia[idx2][idx1] = peso;
        }

        // Lista de Adjacência (grafo não orientado)
        listaAdjacencia.get(objeto1).add(new Vizinho<>(objeto2, peso));
        listaAdjacencia.get(objeto2).add(new Vizinho<>(objeto1, peso));

        // Lista global de arestas (para Kruskal)
        todasArestas.add(new ArestaGenerica<>(objeto1, objeto2, peso));
    }

    public void removerAresta(T objeto1, T objeto2) {
        if (!objetoParaIndice.containsKey(objeto1) || !objetoParaIndice.containsKey(objeto2)) {
            System.err.println("Erro: Um ou ambos os objetos não existem no grafo.");
            return;
        }

        int idx1 = objetoParaIndice.get(objeto1);
        int idx2 = objetoParaIndice.get(objeto2);

        if (idx1 < numVertices && idx2 < numVertices) {
            // Remover da matriz de adjacência
            matrizAdjacencia[idx1][idx2] = 0;
            matrizAdjacencia[idx2][idx1] = 0;
        }

        // Remover da lista de adjacência
        listaAdjacencia.get(objeto1).removeIf(v -> v.objeto.equals(objeto2));
        listaAdjacencia.get(objeto2).removeIf(v -> v.objeto.equals(objeto1));

        // Remover da lista global de arestas
        todasArestas.removeIf(aresta -> 
            (aresta.origem.equals(objeto1) && aresta.destino.equals(objeto2)) ||
            (aresta.origem.equals(objeto2) && aresta.destino.equals(objeto1))
        );
    }

    // Obter objeto por critério
    public T obterObjeto(Function<T, Boolean> criterio) {
        return indiceParaObjeto.stream()
                .filter(criterio::apply)
                .findFirst()
                .orElse(null);
    }

    // Obter todos os objetos que satisfazem um critério
    public List<T> obterObjetos(Function<T, Boolean> criterio) {
        return indiceParaObjeto.stream()
                .filter(criterio::apply)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // Verificar se objeto existe
    public boolean contemObjeto(T objeto) {
        return objetoParaIndice.containsKey(objeto);
    }

    // Obter vizinhos de um objeto
    public List<T> obterVizinhos(T objeto) {
        if (!objetoParaIndice.containsKey(objeto)) {
            return new ArrayList<>();
        }
        
        List<T> vizinhos = new ArrayList<>();
        for (Vizinho<T> vizinho : listaAdjacencia.get(objeto)) {
            vizinhos.add(vizinho.objeto);
        }
        return vizinhos;
    }

    // Obter peso da aresta
    public int obterPesoAresta(T objeto1, T objeto2) {
        if (!objetoParaIndice.containsKey(objeto1) || !objetoParaIndice.containsKey(objeto2)) {
            return -1; // Indica que a aresta não existe
        }
        
        for (Vizinho<T> vizinho : listaAdjacencia.get(objeto1)) {
            if (vizinho.objeto.equals(objeto2)) {
                return vizinho.peso;
            }
        }
        return -1; // Aresta não existe
    }

    // Imprimir a Matriz de Adjacência
    public void imprimirMatrizAdjacencia() {
        System.out.print("        ");
        for (T objeto : indiceParaObjeto) {
            System.out.printf("%-15s", displayFunction.apply(objeto));
        }
        System.out.println("\n" + "-".repeat(15 * (indiceParaObjeto.size() + 1)));

        for (int i = 0; i < Math.min(numVertices, indiceParaObjeto.size()); i++) {
            System.out.printf("%-8s| ", displayFunction.apply(indiceParaObjeto.get(i)));
            for (int j = 0; j < Math.min(numVertices, indiceParaObjeto.size()); j++) {
                System.out.printf("%-15d", matrizAdjacencia[i][j]);
            }
            System.out.println();
        }
    }

    // Imprimir as Listas de Adjacências
    public void imprimirListasAdjacencia() {
        for (T objeto : indiceParaObjeto) {
            System.out.println(displayFunction.apply(objeto) + " -> " + listaAdjacencia.get(objeto));
        }
    }

    // Busca em Profundidade (DFS)
    public void buscaProfundidade(T objetoInicial) {
        Set<T> visitados = new LinkedHashSet<>();
        dfsRecursivo(objetoInicial, visitados);
        System.out.println();
    }

    private void dfsRecursivo(T objeto, Set<T> visitados) {
        visitados.add(objeto);
        System.out.print(displayFunction.apply(objeto) + " -> ");
        for (Vizinho<T> vizinho : listaAdjacencia.get(objeto)) {
            if (!visitados.contains(vizinho.objeto)) {
                dfsRecursivo(vizinho.objeto, visitados);
            }
        }
    }

    // Busca em Largura (BFS)
    public void buscaLargura(T objetoInicial) {
        Set<T> visitados = new LinkedHashSet<>();
        Queue<T> fila = new LinkedList<>();

        visitados.add(objetoInicial);
        fila.add(objetoInicial);

        while (!fila.isEmpty()) {
            T objeto = fila.poll();
            System.out.print(displayFunction.apply(objeto) + " -> ");

            for (Vizinho<T> vizinho : listaAdjacencia.get(objeto)) {
                if (!visitados.contains(vizinho.objeto)) {
                    visitados.add(vizinho.objeto);
                    fila.add(vizinho.objeto);
                }
            }
        }
        System.out.println();
    }

    // Algoritmo de Prim
    public void algoritmoPrim() {
        Map<T, T> arestasAGM = new HashMap<>();
        Map<T, Integer> pesosMinimos = new HashMap<>();
        Set<T> incluidosAGM = new HashSet<>();
        PriorityQueue<Vizinho<T>> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(v -> v.peso));

        // Inicialização
        for (T objeto : objetoParaIndice.keySet()) {
            pesosMinimos.put(objeto, Integer.MAX_VALUE);
        }

        T objetoInicial = indiceParaObjeto.get(0);
        pesosMinimos.put(objetoInicial, 0);
        filaPrioridade.add(new Vizinho<>(objetoInicial, 0));
        arestasAGM.put(objetoInicial, null);

        int custoTotal = 0;
        List<String> resultado = new ArrayList<>();

        while (!filaPrioridade.isEmpty()) {
            T objetoAtual = filaPrioridade.poll().objeto;

            if (incluidosAGM.contains(objetoAtual)) continue;

            incluidosAGM.add(objetoAtual);
            custoTotal += pesosMinimos.get(objetoAtual);
            
            T pai = arestasAGM.get(objetoAtual);
            if (pai != null) {
                resultado.add(String.format("(%s - %s, Peso: %d)", 
                    displayFunction.apply(pai), 
                    displayFunction.apply(objetoAtual), 
                    pesosMinimos.get(objetoAtual)));
            }
            
            for (Vizinho<T> vizinho : listaAdjacencia.get(objetoAtual)) {
                if (!incluidosAGM.contains(vizinho.objeto) && vizinho.peso < pesosMinimos.get(vizinho.objeto)) {
                    pesosMinimos.put(vizinho.objeto, vizinho.peso);
                    arestasAGM.put(vizinho.objeto, objetoAtual);
                    filaPrioridade.add(new Vizinho<>(vizinho.objeto, vizinho.peso));
                }
            }
        }
        
        System.out.println("Arestas na Árvore Geradora Mínima (Prim):");
        resultado.forEach(System.out::println);
        System.out.println("Custo Total da AGM: " + custoTotal);
    }
    
    // Algoritmo de Kruskal
    public void algoritmoKruskal() {
        List<ArestaGenerica<T>> agm = new ArrayList<>();
        Collections.sort(todasArestas);

        DSUGenerico<T> dsu = new DSUGenerico<>(objetoParaIndice.keySet());
        
        int custoTotal = 0;

        for (ArestaGenerica<T> aresta : todasArestas) {
            T raizOrigem = dsu.find(aresta.origem);
            T raizDestino = dsu.find(aresta.destino);

            if (!raizOrigem.equals(raizDestino)) {
                agm.add(aresta);
                dsu.union(aresta.origem, aresta.destino);
                custoTotal += aresta.peso;
            }
        }

        System.out.println("Arestas na Árvore Geradora Mínima (Kruskal):");
        for (ArestaGenerica<T> aresta : agm) {
            System.out.printf("(%s - %s, Peso: %d)%n", 
                displayFunction.apply(aresta.origem), 
                displayFunction.apply(aresta.destino), 
                aresta.peso);
        }
        System.out.println("Custo Total da AGM: " + custoTotal);
    }

    // Getters úteis
    public int getNumVertices() {
        return indiceParaObjeto.size();
    }

    public List<T> getTodosObjetos() {
        return new ArrayList<>(indiceParaObjeto);
    }
}

// Classe para representar arestas genéricas
class ArestaGenerica<T> implements Comparable<ArestaGenerica<T>> {
    T origem;
    T destino;
    int peso;

    public ArestaGenerica(T origem, T destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }


    public int compareTo(ArestaGenerica<T> other) {
        return Integer.compare(this.peso, other.peso);
    }

    public String toString() {
        return String.format("(%s - %s, Peso: %d)", origem, destino, peso);
    }
}

// DSU (Disjoint Set Union) genérico para o algoritmo de Kruskal
class DSUGenerico<T> 
{
    private final Map<T, T> pai = new HashMap<>();
    private final Map<T, Integer> rank = new HashMap<>();

    public DSUGenerico(Set<T> elementos) {
        for (T elemento : elementos) {
            pai.put(elemento, elemento);
            rank.put(elemento, 0);
        }
    }

    public T find(T x) {
        if (!pai.get(x).equals(x)) {
            pai.put(x, find(pai.get(x)));
        }
        return pai.get(x);
    }

    public void union(T x, T y) {
        T raizX = find(x);
        T raizY = find(y);

        if (raizX.equals(raizY)) return;

        if (rank.get(raizX) < rank.get(raizY)) {
            pai.put(raizX, raizY);
        } else if (rank.get(raizX) > rank.get(raizY)) {
            pai.put(raizY, raizX);
        } else {
            pai.put(raizY, raizX);
            rank.put(raizX, rank.get(raizX) + 1);
        }
    }
}