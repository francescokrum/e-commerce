package com.example.trabalho.service;

import com.example.trabalho.dao.FornecedorDAO;
import com.example.trabalho.model.Fornecedor;

public class FornecedorService {

    public boolean autenticaFornecedor(Fornecedor fornecedor){

        boolean cnpj = new FornecedorDAO().verificaFornecedor(fornecedor.getCnpj());
        boolean verifica = false;

        if(fornecedor == null){

            return false;
        }
        else if(cnpj == false){

            if(new FornecedorDAO().cadastrarFornecedor(fornecedor)){
                verifica = true;
            }
            else{
                return false;
            }
        }
        return verifica;
    }

}
