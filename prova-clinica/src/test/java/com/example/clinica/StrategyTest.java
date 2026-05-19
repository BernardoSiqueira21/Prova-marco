package com.example.clinica;

import com.example.clinica.model.Animal;
import com.example.clinica.model.ServicoVeterinario;
import com.example.clinica.model.Tutor;
import com.example.clinica.acrescimos_descontos.BanhoPosConsulta;
import com.example.clinica.acrescimos_descontos.DescontoAdocao;
import com.example.clinica.acrescimos_descontos.TaxaDomicilio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    private Atendimento atendimento;

    @BeforeEach
    void setUp() {
        atendimento = new Atendimento(new Animal("Thor", true), new Tutor("Ana"), new ServicoVeterinario("Consulta", 100.0));
    }

    @Test
    void descontoAdocaoAplica20PorCento() {
        atendimento.setRegraValor(new DescontoAdocao());
        assertEquals(80.0, atendimento.calcularValor(), 0.001);
    }

    @Test
    void taxaDomicilioAdiciona30PorCento() {
        atendimento.setRegraValor(new TaxaDomicilio());
        assertEquals(130.0, atendimento.calcularValor(), 0.001);
    }

    @Test
    void banhoPosConsultaAdicionaTaxaFixaDe50() {
        atendimento.setRegraValor(new BanhoPosConsulta());
        assertEquals(150.0, atendimento.calcularValor(), 0.001);
    }
}
