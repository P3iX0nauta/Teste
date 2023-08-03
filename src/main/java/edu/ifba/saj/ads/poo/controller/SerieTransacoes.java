package edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class SerieTransacoes {
    private String descricao;
    private TransacaoFinanceira transacaoBase;
    private int recorrencia;
    private List<TransacaoFinanceira> transacoes;

    public SerieTransacoes(String descricao, TransacaoFinanceira transacaoBase, int recorrencia) {
        this.descricao = descricao;
        this.transacaoBase = transacaoBase;
        this.recorrencia = recorrencia;
        this.transacoes = new ArrayList<>();
        gerarTransacoes();
    }

    private void gerarTransacoes() {
        transacoes.clear();
        for (int i = 0; i < recorrencia; i++) {
            TransacaoFinanceira transacao = criarTransacaoBase();
            transacoes.add(transacao);
        }
    }

    private TransacaoFinanceira criarTransacaoBase() {
        return new TransacaoFinanceira(transacaoBase.getDescricao(), transacaoBase.getValor(), transacaoBase.getData(), transacaoBase.isEfetivada()) {
        };
    }

    public List<TransacaoFinanceira> getTransacoes() {
        return transacoes;
    }

    // Getters e Setters
    // Implemente-os, se necessário

    @Override
    public String toString() {
        return "SerieTransacoes{" +
                "descricao='" + descricao + '\'' +
                ", transacaoBase=" + transacaoBase +
                ", recorrencia=" + recorrencia +
                '}';
    }
}
