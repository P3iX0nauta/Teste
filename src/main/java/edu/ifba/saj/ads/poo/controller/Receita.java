package edu.ifba.saj.ads.poo.controller;

public class Receita {
    private String nome;
    private int valor;
    private int data;
    private int id;
    public Receita(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public Receita(String nome, int valor, int data) {
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
