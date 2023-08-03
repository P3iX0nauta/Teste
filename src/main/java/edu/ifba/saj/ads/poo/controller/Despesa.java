package edu.ifba.saj.ads.poo.controller;

public class Despesa {
    private String id;
    public Despesa(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    private String nome;
    private int valor;
    private int data;

    public Despesa(String nome, int valor, int data) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    
}
