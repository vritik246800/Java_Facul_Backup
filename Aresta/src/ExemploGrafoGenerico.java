// Ficheiro: ExemploGrafoGenerico.java
import java.util.*;

// Exemplo de classe personalizada
class Cidade 
{
    private String nome;
    private int populacao;
    private String estado;

    public Cidade(String nome, int populacao, String estado) 
    {
        this.nome = nome;
        this.populacao = populacao;
        this.estado = estado;
    }

    // Getters
    public String getNome() { return nome; }
    public int getPopulacao() { return populacao; }
    public String getEstado() { return estado; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setPopulacao(int populacao) { this.populacao = populacao; }
    public void setEstado(String estado) { this.estado = estado; }

   
    public String toString() 
    {
        return nome;
    }

    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cidade cidade = (Cidade) obj;
        return Objects.equals(nome, cidade.nome);
    }

    public int hashCode() 
    {
        return Objects.hash(nome);
    }
}

public class ExemploGrafoGenerico 
{
    public static void main(String[] args) 
    {
        System.out.println("=== EXEMPLO 1: Grafo com Strings ===");
        exemploComStrings();
        
        System.out.println("\n=== EXEMPLO 2: Grafo com Objetos Personalizados ===");
        exemploComObjetos();
        
        System.out.println("\n=== EXEMPLO 3: Manipulação Dinâmica ===");
        exemploManipulacao();
    }

    private static void exemploComStrings() 
    {
        // Criar grafo com strings
        List<String> cidades = Arrays.asList("Lisboa", "Porto", "Coimbra", "Braga", "Faro");
        GrafoGenerico<String> grafo = new GrafoGenerico<>(cidades);

        // Adicionar arestas
        grafo.adicionarAresta("Lisboa", "Porto", 312);
        grafo.adicionarAresta("Lisboa", "Coimbra", 202);
        grafo.adicionarAresta("Porto", "Braga", 53);
        grafo.adicionarAresta("Coimbra", "Faro", 336);
        grafo.adicionarAresta("Lisboa", "Faro", 278);

        System.out.println("Lista de Adjacências:");
        grafo.imprimirListasAdjacencia();
        
        System.out.println("\nBusca em Profundidade a partir de Lisboa:");
        grafo.buscaProfundidade("Lisboa");
        
        System.out.println("\nAlgoritmo de Prim:");
        grafo.algoritmoPrim();
    }

    private static void exemploComObjetos() 
    {
        // Criar objetos cidade
        List<Cidade> cidades = Arrays.asList(
            new Cidade("Lisboa", 544851, "Lisboa"),
            new Cidade("Porto", 237591, "Porto"),
            new Cidade("Coimbra", 143396, "Coimbra"),
            new Cidade("Braga", 193333, "Braga"),
            new Cidade("Faro", 64560, "Faro")
        );

        // Criar grafo com função personalizada de display
        GrafoGenerico<Cidade> grafo = new GrafoGenerico<>(cidades, 
            cidade -> String.format("%s(%d)", cidade.getNome(), cidade.getPopulacao()));

        // Adicionar arestas
        grafo.adicionarAresta(cidades.get(0), cidades.get(1), 312); // Lisboa-Porto
        grafo.adicionarAresta(cidades.get(0), cidades.get(2), 202); // Lisboa-Coimbra
        grafo.adicionarAresta(cidades.get(1), cidades.get(3), 53);  // Porto-Braga
        grafo.adicionarAresta(cidades.get(2), cidades.get(4), 336); // Coimbra-Faro
        grafo.adicionarAresta(cidades.get(0), cidades.get(4), 278); // Lisboa-Faro

        System.out.println("Lista de Adjacências:");
        grafo.imprimirListasAdjacencia();

        // Buscar cidades por critério
        Cidade cidadeGrande = grafo.obterObjeto(cidade -> cidade.getPopulacao() > 500000);
        if (cidadeGrande != null) 
        {
            System.out.println("\nCidade com mais de 500,000 habitantes: " + cidadeGrande.getNome());
        }

        // Buscar todas as cidades de um estado
        List<Cidade> cidadesPorto = grafo.obterObjetos(cidade -> "Porto".equals(cidade.getEstado()));
        System.out.println("Cidades no estado do Porto: " + 
            cidadesPorto.stream().map(Cidade::getNome).reduce((a, b) -> a + ", " + b).orElse("Nenhuma"));

        System.out.println("\nAlgoritmo de Kruskal:");
        grafo.algoritmoKruskal();
    }

    private static void exemploManipulacao() 
    {
        // Iniciar com algumas cidades
        List<String> cidadesIniciais = Arrays.asList("Lisboa", "Porto", "Coimbra");
        GrafoGenerico<String> grafo = new GrafoGenerico<>(cidadesIniciais);

        // Adicionar algumas arestas
        grafo.adicionarAresta("Lisboa", "Porto", 312);
        grafo.adicionarAresta("Lisboa", "Coimbra", 202);

        System.out.println("Grafo inicial:");
        grafo.imprimirListasAdjacencia();

        // Adicionar novo vértice dinamicamente
        System.out.println("\nAdicionando Braga...");
        grafo.adicionarVertice("Braga");
        grafo.adicionarAresta("Porto", "Braga", 53);
        grafo.imprimirListasAdjacencia();

        // Verificar vizinhos
        System.out.println("\nVizinhos do Porto: " + grafo.obterVizinhos("Porto"));

        // Obter peso de uma aresta
        int peso = grafo.obterPesoAresta("Lisboa", "Porto");
        System.out.println("Peso da aresta Lisboa-Porto: " + peso);

        // Remover uma aresta
        System.out.println("\nRemoção da aresta Lisboa-Coimbra:");
        grafo.removerAresta("Lisboa", "Coimbra");
        grafo.imprimirListasAdjacencia();

        // Tentar buscar objeto que não existe
        System.out.println("\nVerificar se 'Faro' existe: " + grafo.contemObjeto("Faro"));
        System.out.println("Verificar se 'Lisboa' existe: " + grafo.contemObjeto("Lisboa"));

        // Remover um vértice
        System.out.println("\nRemoção do vértice Braga:");
        grafo.removerVertice("Braga");
        grafo.imprimirListasAdjacencia();
        
        System.out.println("\nNúmero total de vértices: " + grafo.getNumVertices());
        System.out.println("Todos os objetos: " + grafo.getTodosObjetos());
    }
}

// Exemplo adicional com números (pode ser usado para grafos matemáticos)
class ExemploGrafoNumeros {
    public static void exemploComNumeros() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        GrafoGenerico<Integer> grafo = new GrafoGenerico<>(numeros, 
            num -> "Nó" + num);

        // Criar grafo baseado em alguma relação matemática
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                int peso = Math.abs(numeros.get(i) - numeros.get(j));
                grafo.adicionarAresta(numeros.get(i), numeros.get(j), peso);
            }
        }

        System.out.println("Grafo de números:");
        grafo.imprimirListasAdjacencia();
        
        grafo.algoritmoPrim();
    }
}