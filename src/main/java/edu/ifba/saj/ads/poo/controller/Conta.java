package edu.ifba.saj.ads.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static String nome;
    private static double saldo;
    private static List<TransacaoFinanceira> transacoes;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Conta.nome = nome;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static List<TransacaoFinanceira> getTransacoes() {
        return transacoes;
    }

    public static void inserirTransacao(TransacaoFinanceira transacao) {
        if (transacoes == null) {
            transacoes = new ArrayList<>();
        }
        transacoes.add(transacao);
        if (transacao instanceof Receita) {
            saldo += transacao.getValor();
        } else if (transacao instanceof Despesa) {
            saldo -= transacao.getValor();
        }
    }

    public static void removerTransacao(TransacaoFinanceira transacao) {
        if (transacoes != null && transacoes.contains(transacao)) {
            transacoes.remove(transacao);
            if (transacao instanceof Receita) {
                saldo -= transacao.getValor();
            } else if (transacao instanceof Despesa) {
                saldo += transacao.getValor();
            }
        }
    }

    public static List<TransacaoFinanceira> listaTransacao() {
        return transacoes;
    }

    public static void alternarEfetivada(TransacaoFinanceira transacao) {
        transacao.setEfetivada(!transacao.isEfetivada());
    }

    public static double calcularSaldoPrevisto(LocalDate dataPrevisao) {
        double saldoPrevisto = saldo;
        for (TransacaoFinanceira transacao : transacoes) {
            if (!transacao.isEfetivada() && transacao.getData().isBefore(dataPrevisao)) {
                if (transacao instanceof Receita) {
                    saldoPrevisto += transacao.getValor();
                } else if (transacao instanceof Despesa) {
                    saldoPrevisto -= transacao.getValor();
                }
            }
        }
        return saldoPrevisto;
    }
}
