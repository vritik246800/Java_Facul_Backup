public class TesteArvore {
    public static void main(String[] args) {
        ArvoreBinaria<String> arvore = new ArvoreBinaria<>();

        try {
            arvore.inserir("Carlos");
            arvore.inserir("Ana");
            arvore.inserir("João");
            arvore.inserir("Beatriz");
            arvore.inserir("João"); // Duplicado
        } catch (DadoDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Elementos em ordem:");
        arvore.emOrdem();

        try {
            System.out.println("Buscar 'Ana': " + arvore.buscarComErro("Ana"));
            System.out.println("Buscar 'Pedro': " + arvore.buscarComErro("Pedro"));
        } catch (DadoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            arvore.remover("Maria"); // Não existe
        } catch (DadoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        arvore.remover("Beatriz");

        System.out.println("Em ordem após remover 'Beatriz':");
        arvore.emOrdem();

        arvore.trocarLados();
        System.out.println("Em ordem após espelhar:");
        arvore.emOrdem();
    }
}