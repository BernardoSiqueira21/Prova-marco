package com.example.clinica.atendimento;

public class Finalizado implements EstadoAtendimento {
    @Override
    public String nome() {
        return "Finalizado";
    }
}