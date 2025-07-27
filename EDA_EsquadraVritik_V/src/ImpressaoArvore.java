public class ImpressaoArvore 
{
    public static <T extends Comparable<T>> void imprimir(No<T> raiz, String prefixo, boolean ehEsquerda) {
        if (raiz != null) {
            System.out.println(prefixo + (ehEsquerda ? "├── " : "└── ") + raiz.valor);
            imprimir(raiz.esquerda, prefixo + (ehEsquerda ? "│   " : "    "), true);
            imprimir(raiz.direita, prefixo + (ehEsquerda ? "│   " : "    "), false);
        }
    }
}