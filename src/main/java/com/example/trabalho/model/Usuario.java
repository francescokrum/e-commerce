package com.example.trabalho.model;

public class Usuario {

    private int codusuario;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private String cargo;
    private int codper;

    public Usuario(int codusuario, String nome, String cpf, String login, String senha, String cargo, boolean ativo, int codper) {
        this.codusuario = codusuario;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
        this.codper = codper;
    }

    public Usuario() {

    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCodper() {
        return this.codper;
    }

    public void setCodper(int codper) {
        this.codper = codper;
    }
}
