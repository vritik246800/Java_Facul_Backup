// Ficheiro: ResolucaoParteII.java
import java.util.Arrays;
import java.util.List;

public class ResolucaoParteII {

    public static void main(String[] args) 
    {
    	byte op;
        System.out.println("=========================================================");
        System.out.println("        RESOLUÇÃO DA PARTE II (AED II) EM JAVA");
        System.out.println("=========================================================");

     
        
        
        // a) Pode esta situação ser representada em forma de grafo?
        System.out.println("\na) Pode esta situação ser representada em forma de grafo?");
        System.out.println("Resposta: Sim. As cidades podem ser representadas como vértices (nós) e as estradas como arestas. Como o movimento pode ser feito em ambos os sentidos, trata-se de um grafo não orientado. As distâncias entre as cidades representam os pesos das arestas, caracterizando um grafo ponderado.\n");

        // --- Configuração do Grafo ---
        List<String> cidades = Arrays.asList(
            "Lichinga", "Nampula", "Tete", "Pemba", "Quelimane", "Beira", "Chimoio"
        );
        Grafo mapa = new Grafo(cidades);

        // Adicionando as estradas (arestas) com pesos (distâncias) arbitrários
        mapa.adicionarAresta("Lichinga", "Nampula", 480);
        mapa.adicionarAresta("Lichinga", "Tete", 600);
        mapa.adicionarAresta("Nampula", "Pemba", 420);
        mapa.adicionarAresta("Nampula", "Quelimane", 550);
        mapa.adicionarAresta("Tete", "Quelimane", 700);
        mapa.adicionarAresta("Tete", "Chimoio", 400);
        mapa.adicionarAresta("Quelimane", "Beira", 620);
        mapa.adicionarAresta("Beira", "Chimoio", 200);
        
        
        // b) Representar e codificar a respectiva Matriz de Adjacências;
        // d) Imprimir a Matriz de Adjacência em b) na forma matricial natural;
        System.out.println("\n--- b) e d) Matriz de Adjacências ---\n");
        mapa.imprimirMatrizAdjacencia();

        // c) Representar e codificar as respectivas Listas de Adjacências;
        // e) Imprimir as Listas de Adjacências em c);
        System.out.println("\n\n--- c) e e) Listas de Adjacências ---\n");
        mapa.imprimirListasAdjacencia();

        // f) Interpretar e implementar os algoritmos de busca em: Profundidade;
        System.out.println("\n\n--- f) Algoritmo de Busca em Profundidade (a partir de 'Lichinga') ---\n");
        System.out.print("Caminho percorrido: ");
        mapa.buscaProfundidade("Lichinga");

        // g) Largura;
        System.out.println("\n\n--- g) Algoritmo de Busca em Largura (a partir de 'Lichinga') ---\n");
        System.out.print("Caminho percorrido: ");
        mapa.buscaLargura("Lichinga");

        // h) Algorítmo de PRIM;
        System.out.println("\n\n--- h) Algoritmo de Prim (Árvore Geradora Mínima) ---\n");
        mapa.algoritmoPrim();

        // i) Algoritmo de Kruskal.
        System.out.println("\n\n--- i) Algoritmo de Kruskal (Árvore Geradora Mínima) ---\n");
        mapa.algoritmoKruskal();
    }
}