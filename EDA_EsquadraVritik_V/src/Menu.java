import java.util.*;
import java.io.*;


public class Menu {
    private static ArvoreBinaria<Tarefa> arvore = new ArvoreBinaria<>();
    private static Scanner scanner = new Scanner(System.in);
    //private Bufferred 

    public static void mostrarMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU DE OCORRÊNCIAS ---");
            System.out.println("1. Registrar nova ocorrência");
            System.out.println("2. Buscar ocorrência");
            System.out.println("3. Listar todas ocorrências");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> registrarOcorrencia();
                case 2 -> buscarOcorrencia();
                case 3 -> arvore.emOrdem();
                case 4 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private static void registrarOcorrencia() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        Validacao.validarCodigo(codigo);

        System.out.print("Descrição: ");
        String desc = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Vítima: ");
        String vitima = scanner.nextLine();
        Validacao.validarPessoa(vitima);

        System.out.print("Suspeito: ");
        String suspeito = scanner.nextLine();
        Validacao.validarPessoa(suspeito);

        System.out.print("Suspeito é recorrente? (s/n): ");
        boolean recorrente = scanner.nextLine().equalsIgnoreCase("s");

        List<Objecto> objectos = new ArrayList<>();
        System.out.print("Adicionar objeto? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nome do objeto: ");
            String nome = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipoObj = scanner.nextLine();
            System.out.print("Valor estimado: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            objectos.add(new Objecto(nome, tipoObj, valor));
        }

        arvore.inserir(new Tarefa(codigo, desc, tipo, vitima, suspeito, recorrente, objectos));
        System.out.println("Ocorrência registrada!");
    }

    private static void buscarOcorrencia() {
        System.out.print("Informe o código da ocorrência: ");
        String codigo = scanner.nextLine();
        Tarefa buscada = arvore.buscar(new Tarefa(codigo, "", "", "", "", false, null));
        if (buscada != null) {
            System.out.println("Ocorrência encontrada:");
            System.out.println(buscada);
        } else {
            System.out.println("Não encontrada.");
        }
    }
}