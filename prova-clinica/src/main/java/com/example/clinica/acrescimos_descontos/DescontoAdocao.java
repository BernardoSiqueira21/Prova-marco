package com.example.clinica.acrescimos_descontos;

public class DescontoAdocao implements RegraValor {
    private static final double DESCONTO = 0.20;

    @Override
    public double aplicar(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
        return valor * (1 - DESCONTO);
    }
}
