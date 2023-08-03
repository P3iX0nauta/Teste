package edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;

public class Despesa extends TransacaoFinanceira {
    public Despesa(String descricao, double valor, LocalDate data, boolean efetivada) {
        super(descricao, valor, data, efetivada);
    }
}
