package edu.ifba.saj.ads.poo.controller;

public class transacaoFinanceira {
    private int id;
    private String recorrencia;
    private String txNomeRegistro;
    private String data;
    private String TipoTransacao;
    private int valor;
    
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public transacaoFinanceira(int valor) {
        this.valor = valor;
    }
    public transacaoFinanceira(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public transacaoFinanceira(String tipoTransacao) {
        TipoTransacao = tipoTransacao;
    }
    public String getTipoTransacao() {
        return TipoTransacao;
    }
    public void setTipoTransacao(String tipoTransacao) {
        TipoTransacao = tipoTransacao;
    }
    public transacaoFinanceira(String recorrencia, String txNomeRegistro, String data) {
        this.recorrencia = recorrencia;
        this.txNomeRegistro = txNomeRegistro;
        this.data = data;
    }
    public String getRecorrencia() {
        return recorrencia;
    }
    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }
    public String getTxNomeRegistro() {
        return txNomeRegistro;
    }
    public void setTxNomeRegistro(String txNomeRegistro) {
        this.txNomeRegistro = txNomeRegistro;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }


}
