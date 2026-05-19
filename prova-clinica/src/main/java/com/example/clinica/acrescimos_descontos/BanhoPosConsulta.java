package com.example.clinica.acrescimos_descontos;

public class BanhoPosConsulta implements RegraValor {
    private static final double TAXA_BANHO = 50.0;

    @Override
    public double aplicar(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
        return valor + TAXA_BANHO;
    }
}