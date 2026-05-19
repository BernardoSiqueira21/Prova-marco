package com.example.clinica.atendimento;

public class Cancelado implements EstadoAtendimento {
    @Override
    public String nome() {
        return "Cancelado";
    }
}
