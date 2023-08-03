package edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;

public abstract class TransacaoFinanceira {
    private String descricao;
    private double valor;
    private LocalDate data;
    private boolean efetivada;

    public TransacaoFinanceira(String descricao, double valor, LocalDate data, boolean efetivada) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.efetivada = efetivada;
    }

    // Getters e Setters
    // Implemente-os, se necessário

    @Override
    public String toString() {
        return "TransacaoFinanceira{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", efetivada=" + efetivada +
                '}';
    }
}
