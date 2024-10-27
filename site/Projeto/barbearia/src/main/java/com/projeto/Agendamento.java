package com.projeto;

public class Agendamento {
    private static int contadorId = 1;
    private int id;
    private String servico;
    private String data;
    private String horario;
    private Cliente cliente;

    public Agendamento(String servico, String data, String horario, Cliente cliente) {
        this.id = contadorId++;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Serviço: " + servico + ", Data: " + data + ", Horário: " + horario + ", Cliente: [" + cliente + "]";
    }
}