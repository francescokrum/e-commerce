package com.example.trabalho.model;

public class Pedido {

    private int codpedido;
    private int codfor;
    private int codprod;
    private double qtd;

    public Pedido(int codpedido, int codfor, int codprod, double qtd) {
        this.codpedido = codpedido;
        this.codfor = codfor;
        this.codprod = codprod;
        this.qtd = qtd;
    }

    public Pedido() {

    }

    public int getCodpedido() {
        return codpedido;
    }

    public void setCodpedido(int codpedido) {
        this.codpedido = codpedido;
    }

    public int getCodfor() {
        return codfor;
    }

    public void setCodfor(int codfor) {
        this.codfor = codfor;
    }

    public int getCodprod() {
        return codprod;
    }

    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
}
