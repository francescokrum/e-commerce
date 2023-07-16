package com.example.trabalho.model;

public class Fornecedor {

    private int codfor;
    private String nomefor;
    private String cep;
    private String cnpj;

    public Fornecedor(int codfor, String nomefor, String cep, String cnpj) {
        this.codfor = codfor;
        this.nomefor = nomefor;
        this.cep = cep;
        this.cnpj = cnpj;
    }

    public Fornecedor() {

    }

    public int getCodfor() {
        return codfor;
    }

    public void setCodfor(int codfor) {
        this.codfor = codfor;
    }

    public String getNomefor() {
        return nomefor;
    }

    public void setNomefor(String nomefor) {
        this.nomefor = nomefor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
