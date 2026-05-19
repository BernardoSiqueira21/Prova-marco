package com.example.clinica.acrescimos_descontos;

public class TaxaDomicilio implements RegraValor {
    private static final double TAXA = 0.30;

    @Override
    public double aplicar(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
        return valor * (1 + TAXA);
    }
}