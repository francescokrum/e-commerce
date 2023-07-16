package com.example.trabalho.model;

public class Produto {

    private int codprod;
    private String nomeprod;
    private double preco;

    public Produto(int codprod, String nomeprod, double preco) {
        this.codprod = codprod;
        this.nomeprod = nomeprod;
        this.preco = preco;
    }

    public Produto() {

    }

    public int getCodprod() {
        return codprod;
    }

    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
