package edu.ifba.saj.ads.poo.controller;

public class SerieTransacoes ... {


    // Independete de qual TransacaoFinanceira (Despesa ou Receita) a SerieTransacoes cria todas as TransacaoFinanceira da Serie.
    private void gerarTransacoes(TransacaoFinanceira transacaoInicial) {

        String novoNome = getNome() + " " + (getQuantidadeTransacoes() + 1) + "/"+getTotalTransacoes();
        transacaoInicial.setDescricao(novoNome);
        transacoes.add(transacaoInicial);
        transacaoInicial.setSerieTransacoes(this);
        TransacaoFinanceira transacaoReferencia = transacaoInicial;
        while (getQuantidadeTransacoes() < getTotalTransacoes()) {
            LocalDate novaData = transacaoReferencia.getData().plusMonths(1);
            novoNome = getNome() + " " + (getQuantidadeTransacoes() + 1) + "/"+getTotalTransacoes();
            transacaoReferencia = transacaoReferencia.copia();
            transacaoReferencia.setData(novaData);
            transacaoReferencia.setDescricao(novoNome);
            transacoes.add(transacaoReferencia);
        }
    }

}