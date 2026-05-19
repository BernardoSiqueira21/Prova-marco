package com.example.clinica;

import com.example.clinica.model.Animal;
import com.example.clinica.model.ServicoVeterinario;
import com.example.clinica.model.Tutor;
import com.example.clinica.avisos.Observador;
import com.example.clinica.atendimento.*;
import com.example.clinica.acrescimos_descontos.RegraValor;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {

    private Animal animal;
    private Tutor tutor;
    private ServicoVeterinario servico;
    private EstadoAtendimento estado;
    private double valor;

    private final List<Observador> observadores = new ArrayList<>();
    private RegraValor regraValor;

    public Atendimento(Animal animal, Tutor tutor, ServicoVeterinario servico) {
        this.animal = animal;
        this.tutor = tutor;
        this.servico = servico;
        this.estado = new Agendado();
        this.valor = servico.getValorBase();
        adicionarObservador(tutor);
    }


    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    private void notificar(String msg) {
        for (Observador o : observadores) {
            o.atualizar(msg);
        }
    }

    public void alterarEstado(EstadoAtendimento novoEstado) {
        validarTransicao(novoEstado);
        this.estado = novoEstado;
        notificar("Atendimento de " + animal.getNome() + " mudou para: " + novoEstado.nome());
    }

    private void validarTransicao(EstadoAtendimento novo) {
        String atual = estado.nome();
        String proximo = novo.nome();

        boolean valido = switch (atual) {
            case "Agendado"      -> proximo.equals("EmAtendimento") || proximo.equals("Cancelado");
            case "EmAtendimento" -> proximo.equals("Finalizado")    || proximo.equals("Cancelado");
            default              -> false;
        };

        if (!valido) {
            throw new IllegalStateException(
                    "Transição inválida: " + atual + " -> " + proximo);
        }
    }


    public void setRegraValor(RegraValor regraValor) {
        this.regraValor = regraValor;
    }

    public double calcularValor() {
        if (regraValor != null) {
            return regraValor.aplicar(servico.getValorBase());
        }
        return servico.getValorBase();
    }


    public EstadoAtendimento getEstado() { return estado; }
    public Animal getAnimal()            { return animal; }
    public Tutor getTutor()              { return tutor; }
    public ServicoVeterinario getServico() { return servico; }
    public double getValor()             { return valor; }
}