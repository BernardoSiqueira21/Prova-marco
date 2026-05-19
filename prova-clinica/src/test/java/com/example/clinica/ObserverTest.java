package com.example.clinica;

import com.example.clinica.model.Animal;
import com.example.clinica.model.ServicoVeterinario;
import com.example.clinica.model.Tutor;
import com.example.clinica.avisos.Veterinario;
import com.example.clinica.atendimento.EmAtendimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    private Atendimento atendimento;
    private Tutor tutor;

    @BeforeEach
    void setUp() {
        tutor = new Tutor("Maria");
        atendimento = new Atendimento(new Animal("Mimi", false), tutor, new ServicoVeterinario("Vacina", 80.0));
    }

    @Test
    void tutorRecebeNotificacaoAoMudarEstado() {
        atendimento.alterarEstado(new EmAtendimento());
        assertEquals(1, tutor.getAvisos().size());
    }

    @Test
    void observadorAdicionadoTambemRecebeNotificacao() {
        Veterinario vet = new Veterinario("Dr. Silva");
        atendimento.adicionarObservador(vet);
        atendimento.alterarEstado(new EmAtendimento());
        assertEquals(1, vet.getAvisos().size());
    }

    @Test
    void observadorRemovidoNaoRecebeNotificacao() {
        Veterinario vet = new Veterinario("Dr. Silva");
        atendimento.adicionarObservador(vet);
        atendimento.removerObservador(vet);
        atendimento.alterarEstado(new EmAtendimento());
        assertEquals(0, vet.getAvisos().size());
    }
}
