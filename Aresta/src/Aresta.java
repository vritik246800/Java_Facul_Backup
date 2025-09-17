// Ficheiro: Aresta.java
// Representa uma aresta ponderada no grafo.
// Implementa Comparable para permitir a ordenação das arestas por peso.
public class Aresta implements Comparable<Aresta> {
    String origem;
    String destino;
    int peso;

    public Aresta(String origem, String destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Aresta outraAresta) {
        return this.peso - outraAresta.peso;
    }

    @Override
    public String toString() {
        return String.format("(%s <--> %s, Peso: %d)", origem, destino, peso);
    }
}