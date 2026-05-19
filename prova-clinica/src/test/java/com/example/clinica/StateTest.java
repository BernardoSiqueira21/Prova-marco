package com.example.clinica;

import com.example.clinica.model.Animal;
import com.example.clinica.model.ServicoVeterinario;
import com.example.clinica.model.Tutor;
import com.example.clinica.atendimento.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    private Atendimento atendimento;

    @BeforeEach
    void setUp() {
        atendimento = new Atendimento(new Animal("Rex", false), new Tutor("João"), new ServicoVeterinario("Consulta", 100.0));
    }

    @Test
    void estadoInicialDeveSerAgendado() {
        assertInstanceOf(Agendado.class, atendimento.getEstado());
    }

    @Test
    void transicaoValidaAgendadoParaEmAtendimento() {
        atendimento.alterarEstado(new EmAtendimento());
        assertInstanceOf(EmAtendimento.class, atendimento.getEstado());
    }

    @Test
    void transicaoInvalidaDeveLancarExcecao() {
        assertThrows(IllegalStateException.class, () -> atendimento.alterarEstado(new Finalizado()));
    }
}
