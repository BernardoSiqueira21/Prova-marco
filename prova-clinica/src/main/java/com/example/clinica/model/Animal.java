package com.example.clinica.model;

public class Animal {
    private String nome;
    private boolean adotado;

    public Animal(String nome, boolean adotado) {
        this.nome = nome;
        this.adotado = adotado;
    }

    public String getNome() { return nome; }
    public boolean isAdotado() { return adotado; }
    public void setAdotado(boolean adotado) { this.adotado = adotado; }
}