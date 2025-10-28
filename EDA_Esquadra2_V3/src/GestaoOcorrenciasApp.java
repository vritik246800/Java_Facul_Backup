import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class GestaoOcorrenciasApp {
    private static ArvoreBinariaOcorrencias arvoreOcorrencias = new ArvoreBinariaOcorrencias();
    private static List<Informador> listaInformadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String ARQUIVO_OCORRENCIAS = "ocorrencias.txt";
    private static final String ARQUIVO_INFORMADORES = "informadores.txt";
    private static final int MAX_OCORRENCIAS_ALERTA = 50;

    public static void main(String[] args) {
        carregarDados();
        exibirMenu();
        // A chamada salvarDados() aqui ainda é útil como uma última garantia
        // ou se nem todas as operações de salvamento imediato forem implementadas.
        salvarDados(); 
        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Sistema de Gestão de Ocorrências Policiais ---");
            System.out.println("Ocorrências cadastradas: " + arvoreOcorrencias.getCount());
            if (arvoreOcorrencias.getCount() > MAX_OCORRENCIAS_ALERTA) {
                System.out.println("!!! ALERTA: Número de ocorrências ("+ arvoreOcorrencias.getCount() +") acima do limite ("+MAX_OCORRENCIAS_ALERTA+") !!!");
            }
            System.out.println("1. Cadastrar Nova Ocorrência");
            System.out.println("2. Listar Todas as Ocorrências (em ordem de código)");
            System.out.println("3. Buscar Ocorrência por Código");
            System.out.println("4. Editar Ocorrência");
            System.out.println("5. Excluir Ocorrência");
            System.out.println("6. Cadastrar Informador da Polícia");
            System.out.println("7. Listar Informadores");
            System.out.println("8. Gerar Relatórios Simples");
            System.out.println("0. Sair"); // "Salvar" foi removido do nome, pois o salvamento é mais frequente
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarOcorrencia();
                    break;
                case 2:
                    arvoreOcorrencias.listarEmOrdem();
                    break;
                case 3:
                    buscarOcorrencia();
                    break;
                case 4:
                    editarOcorrencia();
                    break;
                case 5:
                    excluirOcorrencia();
                    break;
                case 6:
                    cadastrarInformador();
                    break;
                case 7:
                    listarInformadores();
                    break;
                case 8:
                    gerarRelatorios();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static Pessoa lerDadosPessoa(String tipoPessoa) {
        System.out.println("Dados do " + tipoPessoa + ":");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty() && tipoPessoa.toLowerCase().contains("suspeito")) return null; 
        if (nome.trim().isEmpty()) {
             System.out.println(tipoPessoa + " não pode ser vazio.");
             return lerDadosPessoa(tipoPessoa); 
        }

        System.out.print("BI: ");
        String bi = scanner.nextLine();
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        return new Pessoa(nome, bi, contacto, endereco);
    }
    
    private static Suspeito lerDadosSuspeito() {
        System.out.println("Dados do Suspeito (deixe nome em branco se desconhecido):");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()) return null;

        System.out.print("BI: ");
        String bi = scanner.nextLine();
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("É recorrente (s/n)? ");
        boolean recorrente = scanner.nextLine().trim().equalsIgnoreCase("s");
        return new Suspeito(nome, bi, contacto, endereco, recorrente);
    }


    private static void cadastrarOcorrencia() 
    {
        System.out.println("--- Cadastro de Nova Ocorrência ---");
        int codigo;
        while (true) {
            try {
                System.out.print("Código da Ocorrência (único, numérico): ");
                codigo = Integer.parseInt(scanner.nextLine());
                if (arvoreOcorrencias.buscar(codigo) != null) {
                    System.out.println("Código já existente. Tente outro.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Código inválido. Deve ser um número.");
            }
        }

        System.out.print("Tipo da Ocorrência (ex: Furto, Agressão): ");
        String tipo = scanner.nextLine();
        
        Pessoa vitima = lerDadosPessoa("Vítima");
        if (vitima == null) { 
            System.out.println("Cadastro de vítima falhou. Abortando ocorrência.");
            return;
        }

        Suspeito suspeito = lerDadosSuspeito(); 

        System.out.print("Descrição do Problema: ");
        String descricao = scanner.nextLine();
        System.out.print("Data e Hora (dd/MM/yyyy HH:mm): ");
        String dataHora = scanner.nextLine();
        System.out.print("Local da Ocorrência: ");
        String local = scanner.nextLine();
        
        int numPessoas = 0;
        try {
            System.out.print("Número de Pessoas Envolvidas: ");
            numPessoas = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, usando 0.");
        }

        System.out.print("Meios/Instrumentos Usados: ");
        String meios = scanner.nextLine();
        System.out.print("Prejuízo Material (descrição e valor): ");
        String prejMaterial = scanner.nextLine();
        System.out.print("Prejuízo Moral (descrição): ");
        String prejMoral = scanner.nextLine();
        
        String status;
        while(true){
            System.out.print("Status Inicial (Aberta, Fechada, Anulada): ");
            status = scanner.nextLine();
            if(status.equalsIgnoreCase("Aberta") || status.equalsIgnoreCase("Fechada") || status.equalsIgnoreCase("Anulada")){
                break;
            }
            System.out.println("Status inválido. Use Aberta, Fechada ou Anulada.");
        }

        Ocorrencia novaOcorrencia = new Ocorrencia(codigo, tipo, vitima, suspeito, descricao, dataHora, local, status, numPessoas, meios, prejMaterial, prejMoral);
        arvoreOcorrencias.inserir(novaOcorrencia);
        System.out.println("Ocorrência cadastrada com sucesso!");
        
        arvoreOcorrencias.salvarParaArquivo(ARQUIVO_OCORRENCIAS);
        System.out.println("Lista de ocorrências atualizada no ficheiro.");
    }

    private static void buscarOcorrencia() {
        System.out.print("Digite o código da ocorrência a buscar: ");
        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            Ocorrencia oc = arvoreOcorrencias.buscar(codigo);
            if (oc != null) {
                System.out.println("--- Ocorrência Encontrada ---");
                System.out.println(oc);
            } else {
                System.out.println("Ocorrência com código " + codigo + " não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Código inválido.");
        }
    }

    private static void editarOcorrencia() {
        System.out.print("Digite o código da ocorrência a editar: ");
        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            Ocorrencia oc = arvoreOcorrencias.buscar(codigo);
            if (oc != null) {
                System.out.println("--- Editando Ocorrência Cód: " + codigo + " ---");
                System.out.println("Deixe em branco para não alterar.");

                System.out.print("Novo Tipo (" + oc.getTipoOcorrencia() + "): ");
                String tipo = scanner.nextLine();
                if (!tipo.isEmpty()) oc.setTipoOcorrencia(tipo);

                System.out.print("Nova Descrição (" + oc.getDescricao() + "): ");
                String desc = scanner.nextLine();
                if (!desc.isEmpty()) oc.setDescricao(desc);

                System.out.print("Nova Data/Hora (" + oc.getDataHora() + "): ");
                String dh = scanner.nextLine();
                if (!dh.isEmpty()) oc.setDataHora(dh);
                
                System.out.print("Novo Local (" + oc.getLocal() + "): ");
                String local = scanner.nextLine();
                if (!local.isEmpty()) oc.setLocal(local);

                System.out.print("Novo Status (" + oc.getStatus() + ") (Aberta, Fechada, Anulada): ");
                String st = scanner.nextLine();
                if (!st.isEmpty()) {
                     if(st.equalsIgnoreCase("Aberta") || st.equalsIgnoreCase("Fechada") || st.equalsIgnoreCase("Anulada")){
                        oc.setStatus(st);
                    } else {
                        System.out.println("Status inválido, mantendo o anterior.");
                    }
                }

                System.out.println("Ocorrência atualizada.");
                arvoreOcorrencias.salvarParaArquivo(ARQUIVO_OCORRENCIAS);
                System.out.println("Lista de ocorrências atualizada no ficheiro após edição.");

            } else {
                System.out.println("Ocorrência com código " + codigo + " não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Código inválido.");
        }
    }

    private static void excluirOcorrencia() {
        System.out.print("Digite o código da ocorrência a excluir: ");
         try {
            int codigo = Integer.parseInt(scanner.nextLine());
            if (arvoreOcorrencias.buscar(codigo) != null) {
                arvoreOcorrencias.remover(codigo);
                System.out.println("Ocorrência " + codigo + " removida (se existia).");
                arvoreOcorrencias.salvarParaArquivo(ARQUIVO_OCORRENCIAS);
                System.out.println("Lista de ocorrências atualizada no ficheiro após exclusão.");
            } else {
                 System.out.println("Ocorrência com código " + codigo + " não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Código inválido.");
        }
    }

    private static void cadastrarInformador() {
        System.out.println("--- Cadastro de Novo Informador ---");
        Pessoa dadosPessoa = lerDadosPessoa("Informador");
        if(dadosPessoa != null) {
            Informador informador = new Informador(dadosPessoa.getNome(), dadosPessoa.getBi(), dadosPessoa.getContacto(), dadosPessoa.getEndereco());
            listaInformadores.add(informador);
            System.out.println("Informador cadastrado com sucesso!");
            
            // SALVAR INFORMADORES IMEDIATAMENTE
            salvarInformadoresNoArquivo();
            System.out.println("Lista de informadores atualizada no ficheiro.");
        } else {
            System.out.println("Cadastro de informador falhou.");
        }
    }
    
    // NOVO MÉTODO para salvar informadores
    private static void salvarInformadoresNoArquivo() {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_INFORMADORES))) {
            if (listaInformadores.isEmpty()){
                 // Se a lista estiver vazia, garante que o ficheiro fica vazio ou não é criado (depende da implementação do FileWriter)
                 // Se quiser que um arquivo vazio seja criado: out.print(""); 
                 // Neste caso, não fazer nada se estiver vazio é ok, e se o ficheiro existir, será sobrescrito como vazio.
                 // System.out.println("Nenhum informador para salvar, ficheiro atualizado/limpo.");
                 return; 
            }
            for (Informador inf : listaInformadores) {
                out.println(inf.toFileString());
            }
            // System.out.println("Informadores salvos em " + ARQUIVO_INFORMADORES); // Mensagem já está no cadastrarInformador
        } catch (IOException e) {
            System.err.println("Erro ao salvar informadores: " + e.getMessage());
        }
    }


    private static void listarInformadores() {
        System.out.println("--- Lista de Informadores ---");
        if (listaInformadores.isEmpty()) {
            System.out.println("Nenhum informador cadastrado.");
            return;
        }
        for (int i = 0; i < listaInformadores.size(); i++) {
            System.out.println((i + 1) + ". " + listaInformadores.get(i));
        }
    }
    
    private static void gerarRelatorios() {
        System.out.println("--- Relatórios ---");
        System.out.println("1. Listar Ocorrências por Status");
        System.out.println("2. Contagem Total de Ocorrências");
        System.out.print("Escolha um relatório: ");
        String escolha = scanner.nextLine();

        List<Ocorrencia> todas = arvoreOcorrencias.getTodasOcorrencias();

        switch (escolha) {
            case "1":
                System.out.print("Digite o status para filtrar (Aberta, Fechada, Anulada): ");
                String statusFiltro = scanner.nextLine();
                int countStatus = 0;
                for (Ocorrencia oc : todas) {
                    if (oc.getStatus().equalsIgnoreCase(statusFiltro)) {
                        System.out.println(oc);
                        countStatus++;
                    }
                }
                if(countStatus == 0) System.out.println("Nenhuma ocorrência encontrada com o status: " + statusFiltro);
                else System.out.println("Total de ocorrências com status '"+statusFiltro+"': " + countStatus);
                break;
            case "2":
                System.out.println("Total de Ocorrências Registradas: " + arvoreOcorrencias.getCount());
                break;
            default:
                System.out.println("Opção de relatório inválida.");
        }
    }

    // Método principal de salvar ao sair. Agora foca mais em garantir que tudo
    // que não foi salvo imediatamente seja salvo.
    // Como as ocorrências e informadores agora são salvos imediatamente após modificações,
    // este método se torna mais uma redundância segura.
    private static void salvarDados() {
        // Ocorrências já são salvas após cada add/edit/delete.
        // arvoreOcorrencias.salvarParaArquivo(ARQUIVO_OCORRENCIAS); 

        // Informadores também são salvos após cadastro.
        // salvarInformadoresNoArquivo(); 

        // Poderia adicionar uma mensagem aqui se não houver nada específico para salvar que já não tenha sido.
        System.out.println("Verificando dados finais antes de encerrar...");
        // Se, por exemplo, houvesse configurações do sistema a salvar, seria aqui.
    }

    private static void carregarDados() {
        arvoreOcorrencias.carregarDeArquivo(ARQUIVO_OCORRENCIAS);
        
        File fileInformadores = new File(ARQUIVO_INFORMADORES);
        if (!fileInformadores.exists()) {
            System.out.println("Arquivo " + ARQUIVO_INFORMADORES + " não encontrado. Iniciando com lista de informadores vazia.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_INFORMADORES))) {
            String linha;
            listaInformadores.clear();
            while ((linha = br.readLine()) != null) {
                 if (linha.trim().isEmpty()) continue;
                String[] parts = linha.split(";",-1);
                if (parts.length >= 4) { 
                    Informador inf = new Informador(parts[0], parts[1], parts[2], parts[3]);
                    listaInformadores.add(inf);
                } else {
                    System.err.println("Erro ao parsear linha (informador): " + linha);
                }
            }
            System.out.println("Informadores carregados de " + ARQUIVO_INFORMADORES);
        } catch (IOException e) {
            System.err.println("Erro ao carregar informadores: " + e.getMessage());
        }
    }
}