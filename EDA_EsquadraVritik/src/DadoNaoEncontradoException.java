// Exceção para valor duplicado
class DadoDuplicadoException extends RuntimeException {
    public DadoDuplicadoException(String mensagem) {
        super(mensagem);
    }
}

// Exceção para valor não encontrado
class DadoNaoEncontradoException extends RuntimeException {
    public DadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}