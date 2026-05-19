package com.example.clinica.model;

import com.example.clinica.avisos.Observador;
import java.util.ArrayList;
import java.util.List;

public class Tutor implements Observador {
    private String nome;
    private List<String> avisos = new ArrayList<>();

    public Tutor(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String msg) {
        avisos.add(msg);
    }

    public void receberAviso(String msg) {
        atualizar(msg);
    }

    public String getNome() { return nome; }
    public List<String> getAvisos() { return avisos; }
}
