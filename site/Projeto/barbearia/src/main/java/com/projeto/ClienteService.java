package com.projeto;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente adicionarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(nome, telefone);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarClientePorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public boolean atualizarCliente(int id, String novoNome, String novoTelefone) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public boolean deletarCliente(int id) {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }
}