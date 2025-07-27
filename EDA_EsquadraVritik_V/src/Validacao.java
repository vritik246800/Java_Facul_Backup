public class Validacao {
    public static void validarCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código da ocorrência inválido.");
        }
    }

    public static void validarPessoa(String nome) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome inválido.");
        }
    }

    // Adicione outras validações conforme necessário
}