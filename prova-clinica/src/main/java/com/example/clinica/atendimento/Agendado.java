package com.example.clinica.atendimento;

public class Agendado implements EstadoAtendimento {
    @Override
    public String nome() {
        return "Agendado";
    }
}
