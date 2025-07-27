import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SistemaGestaoOcorrencias {
    private static ArvoreBinariaOcorrencias arvoreOcorrencias = new ArvoreBinariaOcorrencias();
    private static Map<String, Informador> mapaInformadores = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DTF_INPUT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final int LIMITE_ALERTA_OCORRENCIAS_ABERTAS = 10; // Exemplo de limite

    public static void main(String[] args) 
    {
        // Popular com alguns dados de exemplo (opcional)
        popularDadosExemplo();

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // descarta entrada inválida
                System.out.print("Escolha uma opção: ");
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarOcorrencia();
                    break;
                case 2:
                    editarOcorrencia();
                    break;
                case 3:
                    excluirOcorrencia();
                    break;
                case 4:
                    consultarOcorrencia();
                    break;
                case 5:
                    listarTodasOcorrencias();
                    break;
                case 6:
                    gerenciarStatusOcorrencia();
                    break;
                case 7:
                    cadastrarInformador();
                    break;
                case 8:
                    listarInformadores();
                    break;
                case 9:
                    gerarRelatorios();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            verificarAlertas(); // Verificar alertas após cada operação relevante
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Gestão de Ocorrências Policiais ---");
        System.out.println("1. Cadastrar Nova Ocorrência");
        System.out.println("2. Editar Ocorrência Existente");
        System.out.println("3. Excluir Ocorrência");
        System.out.println("4. Consultar Ocorrência por ID");
        System.out.println("5. Listar Todas as Ocorrências (Histórico)");
        System.out.println("6. Gerenciar Status de Ocorrência (Abertura/Fechamento/Anulação)");
        System.out.println("7. Cadastrar Informador");
        System.out.println("8. Listar Informadores");
        System.out.println("9. Gerar Relatórios e Análises");
        System.out.println("0. Sair");
        System.out.println("----------------------------------------------------");
    }

    private static void cadastrarOcorrencia() {
        System.out.println("\n--- Cadastro de Nova Ocorrência ---");
        System.out.print("Tipo da Ocorrência (ex: Roubo, Furto, V. Doméstica): ");
        String tipo = scanner.nextLine();
        System.out.print("Descrição detalhada: ");
        String desc = scanner.nextLine();
        
        LocalDateTime dataHoraOcorrencia = null;
        while (dataHoraOcorrencia == null) {
            System.out.print("Data e Hora da Ocorrência (dd/MM/yyyy HH:mm): ");
            String dataHoraStr = scanner.nextLine();
            try {
                dataHoraOcorrencia = LocalDateTime.parse(dataHoraStr, DTF_INPUT);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data/hora inválido. Use dd/MM/yyyy HH:mm. Tente novamente.");
            }
        }

        System.out.print("Local da Ocorrência: ");
        String local = scanner.nextLine();
        System.out.print("Nome da Vítima/Queixoso: ");
        String nomeVitima = scanner.nextLine();
        System.out.print("Contato da Vítima (Telefone/Email): ");
        String contatoVitima = scanner.nextLine();
        System.out.print("Nome do Suspeito (ou 'Desconhecido'): ");
        String nomeSuspeito = scanner.nextLine();
        String statusSuspeito = "N/A";
        if (!nomeSuspeito.equalsIgnoreCase("Desconhecido")) {
            System.out.print("Status do Suspeito (Primário/Recorrente): ");
            statusSuspeito = scanner.nextLine();
        }
        System.out.print("Meios/Instrumentos usados (ex: Arma branca, Arma de fogo .38): ");
        String instrumentos = scanner.nextLine();
        System.out.print("Prejuízo Material (ex: Bens furtados R$500): ");
        String prejuizoMat = scanner.nextLine();
        System.out.print("Prejuízo Moral (ex: Ameaça, Lesão leve): ");
        String prejuizoMoral = scanner.nextLine();

        Ocorrencia novaOcorrencia = new Ocorrencia(tipo, desc, dataHoraOcorrencia, local, nomeVitima,
                contatoVitima, nomeSuspeito, statusSuspeito, instrumentos, prejuizoMat, prejuizoMoral);
        
        arvoreOcorrencias.inserir(novaOcorrencia);
        System.out.println("Ocorrência cadastrada com sucesso! ID: " + novaOcorrencia.getIdOcorrencia());
    }

    private static void editarOcorrencia() {
        System.out.println("\n--- Editar Ocorrência ---");
        System.out.print("Digite o ID da Ocorrência a ser editada (ex: OC-0001): ");
        String id = scanner.nextLine();
        Ocorrencia ocorrencia = arvoreOcorrencias.buscar(id);

        if (ocorrencia == null) {
            System.out.println("Ocorrência não encontrada.");
            return;
        }

        System.out.println("Dados atuais:\n" + ocorrencia);
        System.out.println("Deixe em branco para não alterar o campo.");

        System.out.print("Novo Tipo (" + ocorrencia.getTipoOcorrencia() + "): ");
        String tipo = scanner.nextLine();
        if (!tipo.isEmpty()) ocorrencia.setTipoOcorrencia(tipo);

        System.out.print("Nova Descrição (" + ocorrencia.getDescricao() + "): ");
        String desc = scanner.nextLine();
        if (!desc.isEmpty()) ocorrencia.setDescricao(desc);
        
        System.out.print("Nova Data/Hora (dd/MM/yyyy HH:mm) (" + (ocorrencia.getDataHoraOcorrencia() != null ? ocorrencia.getDataHoraOcorrencia().format(DTF_INPUT) : "") + "): ");
        String dataHoraStr = scanner.nextLine();
        if (!dataHoraStr.isEmpty()) {
            try {
                ocorrencia.setDataHoraOcorrencia(LocalDateTime.parse(dataHoraStr, DTF_INPUT));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data/hora inválido. Campo não alterado.");
            }
        }
        // ... (Adicionar edição para todos os campos relevantes)
        System.out.print("Novo Local (" + ocorrencia.getLocal() + "): ");
        String local = scanner.nextLine();
        if (!local.isEmpty()) ocorrencia.setLocal(local);
        
        System.out.print("Novo Nome da Vítima (" + ocorrencia.getNomeVitima() + "): ");
        String nomeVitima = scanner.nextLine();
        if (!nomeVitima.isEmpty()) ocorrencia.setNomeVitima(nomeVitima);

        System.out.println("Ocorrência atualizada com sucesso!");
    }

    private static void excluirOcorrencia() {
        System.out.println("\n--- Excluir Ocorrência ---");
        System.out.print("Digite o ID da Ocorrência a ser excluída: ");
        String id = scanner.nextLine();
        Ocorrencia oc = arvoreOcorrencias.buscar(id);
        if(oc == null){
            System.out.println("Ocorrência com ID " + id + " não encontrada.");
            return;
        }

        arvoreOcorrencias.remover(id);
        System.out.println("Ocorrência " + id + " excluída (se existia).");
    }

    private static void consultarOcorrencia() {
        System.out.println("\n--- Consultar Ocorrência ---");
        System.out.print("Digite o ID da Ocorrência: ");
        String id = scanner.nextLine();
        Ocorrencia ocorrencia = arvoreOcorrencias.buscar(id);
        if (ocorrencia != null) {
            System.out.println(ocorrencia);
        } else {
            System.out.println("Ocorrência não encontrada.");
        }
    }

    private static void listarTodasOcorrencias() {
        System.out.println("\n--- Histórico de Todas as Ocorrências ---");
        if (arvoreOcorrencias.contarTotalOcorrencias() == 0) {
            System.out.println("Nenhuma ocorrência registrada.");
            return;
        }
        arvoreOcorrencias.listarEmOrdem();
    }

    private static void gerenciarStatusOcorrencia() {
        System.out.println("\n--- Gerenciar Status da Ocorrência ---");
        System.out.print("Digite o ID da Ocorrência: ");
        String id = scanner.nextLine();
        Ocorrencia ocorrencia = arvoreOcorrencias.buscar(id);

        if (ocorrencia == null) {
            System.out.println("Ocorrência não encontrada.");
            return;
        }

        System.out.println("Status atual: " + ocorrencia.getStatusCaso());
        System.out.print("Novo status (Aberto, Em Investigação, Fechado, Anulado): ");
        String novoStatus = scanner.nextLine();

        // Validação simples do status
        if (novoStatus.equalsIgnoreCase("Aberto") || 
            novoStatus.equalsIgnoreCase("Em Investigação") ||
            novoStatus.equalsIgnoreCase("Fechado") || 
            novoStatus.equalsIgnoreCase("Anulado")) {
            
            String statusAntigo = ocorrencia.getStatusCaso();
            ocorrencia.setStatusCaso(novoStatus);

            // Atualizar contador de abertas para alertas
            boolean eraAbertaOuEmInvestigacao = "Aberto".equalsIgnoreCase(statusAntigo) || "Em Investigação".equalsIgnoreCase(statusAntigo);
            boolean agoraAbertaOuEmInvestigacao = "Aberto".equalsIgnoreCase(novoStatus) || "Em Investigação".equalsIgnoreCase(novoStatus);

            if (eraAbertaOuEmInvestigacao && !agoraAbertaOuEmInvestigacao) {
                arvoreOcorrencias.decrementarAbertas();
            } else if (!eraAbertaOuEmInvestigacao && agoraAbertaOuEmInvestigacao) {
                 arvoreOcorrencias.incrementarAbertas();
            }

            System.out.println("Status da ocorrência " + id + " atualizado para: " + novoStatus);
        } else {
            System.out.println("Status inválido.");
        }
    }

    private static void cadastrarInformador() {
        System.out.println("\n--- Cadastro de Informador ---");
        System.out.print("Nome do Informador: ");
        String nome = scanner.nextLine();
        System.out.print("Contato (Telefone/Email): ");
        String contato = scanner.nextLine();
        System.out.print("Observações: ");
        String obs = scanner.nextLine();

        Informador novoInformador = new Informador(nome, contato, obs);
        mapaInformadores.put(novoInformador.getIdInformador(), novoInformador);
        System.out.println("Informador cadastrado com sucesso! ID: " + novoInformador.getIdInformador());
    }

    private static void listarInformadores() {
        System.out.println("\n--- Lista de Informadores ---");
        if (mapaInformadores.isEmpty()) {
            System.out.println("Nenhum informador cadastrado.");
            return;
        }
        for (Informador inf : mapaInformadores.values()) {
            System.out.println(inf);
        }
    }

    private static void gerarRelatorios() {
        System.out.println("\n--- Relatórios e Análises ---");
        List<Ocorrencia> todas = arvoreOcorrencias.getTodasOcorrencias();
        if (todas.isEmpty()) {
            System.out.println("Nenhuma ocorrência para gerar relatório.");
            return;
        }

        System.out.println("Total de Ocorrências Registradas: " + todas.size());

        long abertas = todas.stream().filter(o -> "Aberto".equalsIgnoreCase(o.getStatusCaso())).count();
        long emInvestigacao = todas.stream().filter(o -> "Em Investigação".equalsIgnoreCase(o.getStatusCaso())).count();
        long fechadas = todas.stream().filter(o -> "Fechado".equalsIgnoreCase(o.getStatusCaso())).count();
        long anuladas = todas.stream().filter(o -> "Anulado".equalsIgnoreCase(o.getStatusCaso())).count();

        System.out.println("Ocorrências Abertas: " + abertas);
        System.out.println("Ocorrências Em Investigação: " + emInvestigacao);
        System.out.println("Ocorrências Fechadas: " + fechadas);
        System.out.println("Ocorrências Anuladas: " + anuladas);
        
        // Exemplo de relatório por tipo de ocorrência
        System.out.println("\nOcorrências por Tipo:");
        Map<String, Long> porTipo = new HashMap<>();
        for(Ocorrencia o : todas){
            porTipo.put(o.getTipoOcorrencia(), porTipo.getOrDefault(o.getTipoOcorrencia(), 0L) + 1);
        }
        porTipo.forEach((tipo, count) -> System.out.println("- " + tipo + ": " + count));
        System.out.println("-----------------------------");
    }

    private static void verificarAlertas() {
        // Atualiza contador antes de verificar
        int abertas = arvoreOcorrencias.getContadorOcorrenciasAbertas(); 
        if (abertas >= LIMITE_ALERTA_OCORRENCIAS_ABERTAS) {
            System.out.println("\n!!! ALERTA: Número de ocorrências abertas/em investigação (" + abertas + 
                               ") atingiu ou excedeu o limite de " + LIMITE_ALERTA_OCORRENCIAS_ABERTAS + " !!!");
        }
    }
    
    private static void popularDadosExemplo() {
        // Reset IDs for consistency if run multiple times in same JVM instance
        Ocorrencia.setProximoId(1);
        Informador.setProximoId(1);

        Ocorrencia oc1 = new Ocorrencia("Furto Qualificado", "Arrombamento de residência", LocalDateTime.of(2023, 10, 1, 2, 30),
                "Rua das Palmeiras, 123", "João Silva", "9999-8888", "Desconhecido", "N/A",
                "Ferramenta de arrombamento", "TV 50 polegadas, Notebook", "Sensação de insegurança");
        arvoreOcorrencias.inserir(oc1);

        Ocorrencia oc2 = new Ocorrencia("Violência Doméstica", "Agressão física e verbal", LocalDateTime.of(2023, 10, 2, 19, 0),
                "Av. Principal, 456, Apto 101", "Maria Santos", "maria.santos@email.com", "Carlos Pereira", "Recorrente",
                "Mãos (soco)", "Nenhum", "Lesões leves, trauma psicológico");
        oc2.setStatusCaso("Em Investigação"); // Atualiza status para teste
        arvoreOcorrencias.inserir(oc2);


        Ocorrencia oc3 = new Ocorrencia("Condução Perigosa", "Manobras arriscadas em via pública", LocalDateTime.of(2023, 9, 15, 23, 10),
                "Rodovia BR-101 KM 50", "N/A (Denúncia anônima)", "N/A", "Placa XYZ-1234 (Veículo)", "N/A",
                "Veículo automotor", "Nenhum", "Risco à segurança pública");
        arvoreOcorrencias.inserir(oc3);
        
        // Para testar o alerta, vamos adicionar mais algumas ocorrências abertas
        for (int i = 0; i < 8; i++) {
             Ocorrencia ocTemp = new Ocorrencia("Roubo", "Assalto a pedestre", LocalDateTime.now().minusDays(i),
                "Centro da Cidade", "Pedestre "+i, "N/A", "Indivíduo de capuz", "Primário",
                "Faca", "Celular, Carteira", "Ameaça");
            arvoreOcorrencias.inserir(ocTemp);
        }


        Informador inf1 = new Informador("José Antunes", "1111-2222", "Fornece informações sobre tráfico local");
        mapaInformadores.put(inf1.getIdInformador(), inf1);

        System.out.println("Dados de exemplo populados.");
    }
}