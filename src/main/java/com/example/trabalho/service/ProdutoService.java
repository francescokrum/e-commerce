package com.example.trabalho.service;

import com.example.trabalho.dao.ProdutoDAO;
import com.example.trabalho.model.Produto;

public class ProdutoService{

    public boolean autenticarProduto(Produto produto){

        boolean nome = new ProdutoDAO().verificaProduto(produto.getNomeprod());
        boolean verifica;

        if(produto == null){

            return false;
        }
        else if(nome == true){

            verifica = false;
        }
        else{
            new ProdutoDAO().cadastrarProduto(produto);
            verifica = true;
        }
        return verifica;
    }
}
