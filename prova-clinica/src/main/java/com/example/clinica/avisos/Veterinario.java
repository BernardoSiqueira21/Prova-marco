package com.example.clinica.avisos;

import java.util.ArrayList;
import java.util.List;

public class Veterinario implements Observador {
    private String nome;
    private List<String> avisos = new ArrayList<>();

    public Veterinario(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String msg) {
        avisos.add(msg);
    }

    public String getNome() { return nome; }
    public List<String> getAvisos() { return avisos; }
}
