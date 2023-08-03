package edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;

public class Receita extends TransacaoFinanceira {
    public Receita(String descricao, double valor, LocalDate data, boolean efetivada) {
        super(descricao, valor, data, efetivada);
    }
}
