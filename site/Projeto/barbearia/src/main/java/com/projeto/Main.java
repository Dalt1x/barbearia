package com.projeto;

import java.util.Scanner;

public class Main {
    private static ClienteService clienteService = new ClienteService();
    private static AgendamentoService agendamentoService = new AgendamentoService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Barbearia ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Adicionar Agendamento");
            System.out.println("6. Listar Agendamentos");
            System.out.println("7. Atualizar Agendamento");
            System.out.println("8. Deletar Agendamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarCliente(scanner);
                case 2 -> listarClientes();
                case 3 -> atualizarCliente(scanner);
                case 4 -> deletarCliente(scanner);
                case 5 -> adicionarAgendamento(scanner);
                case 6 -> listarAgendamentos();
                case 7 -> atualizarAgendamento(scanner);
                case 8 -> deletarAgendamento(scanner);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.next();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.next();
        clienteService.adicionarCliente(nome, telefone);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void listarClientes() {
        System.out.println("\nClientes:");
        clienteService.listarClientes().forEach(System.out::println);
    }

    private static void atualizarCliente(Scanner scanner) {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        System.out.print("Novo Nome: ");
        String novoNome = scanner.next();
        System.out.print("Novo Telefone: ");
        String novoTelefone = scanner.next();
        if (clienteService.atualizarCliente(id, novoNome, novoTelefone)) {
            System.out.println("Cliente atualizado!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void deletarCliente(Scanner scanner) {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        if (clienteService.deletarCliente(id)) {
            System.out.println("Cliente deletado!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void adicionarAgendamento(Scanner scanner) {
        System.out.print("ID do Cliente: ");
        int clienteId = scanner.nextInt();
        Cliente cliente = clienteService.buscarClientePorId(clienteId);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.print("Serviço: ");
        String servico = scanner.next();
        System.out.print("Data: ");
        String data = scanner.next();
        System.out.print("Horário: ");
        String horario = scanner.next();
        agendamentoService.adicionarAgendamento(servico, data, horario, cliente);
        System.out.println("Agendamento adicionado!");
    }

    private static void listarAgendamentos() {
        System.out.println("\nAgendamentos:");
        agendamentoService.listarAgendamentos().forEach(System.out::println);
    }
    
    public static void atualizarAgendamento(Scanner scanner) {
        System.out.println("Atualizando agendamento...");
        System.out.print("Digite o ID do agendamento a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o novo horário do agendamento: ");
        String novoHorario = scanner.nextLine();

        System.out.println("Agendamento " + id + " atualizado para o horário: " + novoHorario);
    }

    public static void deletarAgendamento(Scanner scanner) {
        System.out.println("Deletando agendamento...");
        System.out.print("Digite o ID do agendamento a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (agendamentoService.deletarAgendamento(id)) {
            System.out.println("Agendamento " + id + " deletado com sucesso.");
        } else {
            System.out.println("Agendamento não encontrado.");
        }
    }
}