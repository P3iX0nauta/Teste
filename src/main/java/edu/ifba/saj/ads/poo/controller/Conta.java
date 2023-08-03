package edu.ifba.saj.ads.poo.controller;

public class Conta{
    private String nome;
    private int saldo;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Conta(String nome, int saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getSaldo() {
        return saldo;
    }


    public static void inserirTransacao(transacaoFinanceira transacaoFinanceira)  {
        transacoes.add(transacaoFinanceira);
        if (transacaoFinanceira.isEfetivada()) {
            efetivarTransacao(transacaoFinanceira);
        }
    }

    public static void removerTransacao(transacaoFinanceira transacaoFinanceira)  {
        transacoes.remove(transacaoFinanceira);
        if (transacaoFinanceira.isEfetivada()) {
            desefetivarTransacao(transacaoFinanceira);
        }
    }

    //transacaoFinanceira.getValorAplicadoNaConta();
    


 public static double calcularSaldoPrevisto(LocalDate dataReferencia) {
    double diferencaSaldo = transacoes.stream()
            .filter(despesaf -> !despesaf.isEfetivada() && despesaf.getData().isBefore(dataReferencia))
            .mapToDouble(transacaoFinanceira::getValorAplicadoNaConta)
            .sum();

    return getSaldo() + diferencaSaldo;
 }

}