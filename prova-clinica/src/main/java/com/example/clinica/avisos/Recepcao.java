package com.example.clinica.avisos;

import java.util.ArrayList;
import java.util.List;

public class Recepcao implements Observador {
    private List<String> avisos = new ArrayList<>();

    @Override
    public void atualizar(String msg) {
        avisos.add(msg);
    }

    public List<String> getAvisos() { return avisos; }
}