// Ficheiro: DSU.java
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

// Estrutura de dados Disjoint Set Union (ou Union-Find)
// Usada no algoritmo de Kruskal para detetar ciclos eficientemente.
public class DSU {
    private Map<String, String> pai = new HashMap<>();

    // Construtor: Inicialmente, cada vértice é o seu próprio pai.
    public DSU(Set<String> vertices) {
        for (String vertice : vertices) {
            pai.put(vertice, vertice);
        }
    }

    // Encontra o representante (raiz) do conjunto ao qual o vértice 'i' pertence.
    public String find(String i) {
        if (pai.get(i).equals(i)) {
            return i;
        }
        // Otimização: Compressão de caminho
        String raiz = find(pai.get(i));
        pai.put(i, raiz);
        return raiz;
    }

    // Une os conjuntos que contêm os vértices 'x' e 'y'.
    public void union(String x, String y) {
        String raizX = find(x);
        String raizY = find(y);
        if (!raizX.equals(raizY)) {
            pai.put(raizX, raizY);
        }
    }
}