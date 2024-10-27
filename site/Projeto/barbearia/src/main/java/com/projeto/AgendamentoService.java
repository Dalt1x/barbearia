package com.projeto;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Agendamento adicionarAgendamento(String servico, String data, String horario, Cliente cliente) {
        Agendamento agendamento = new Agendamento(servico, data, horario, cliente);
        agendamentos.add(agendamento);
        return agendamento;
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }

    public Agendamento buscarAgendamentoPorId(int id) {
        return agendamentos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public boolean atualizarAgendamento(int id, String novoServico, String novaData, String novoHorario) {
        Agendamento agendamento = buscarAgendamentoPorId(id);
        if (agendamento != null) {
            agendamento.setServico(novoServico);
            agendamento.setData(novaData);
            agendamento.setHorario(novoHorario);
            return true;
        }
        return false;
    }

    public boolean deletarAgendamento(int id) {
        return agendamentos.removeIf(agendamento -> agendamento.getId() == id);
    }
}