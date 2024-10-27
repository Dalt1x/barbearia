package com.projeto;

public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.id = contadorId++;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Telefone: " + telefone;
    }
}