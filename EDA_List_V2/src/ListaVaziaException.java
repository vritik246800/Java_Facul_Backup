// Classe de exceção personalizada
class ListaVaziaException extends RuntimeException {
    public ListaVaziaException(String message) {
        super(message);
    }
}