package com.example.trabalho.service;

import com.example.trabalho.dao.UsuarioDAO;
import com.example.trabalho.model.Usuario;

public class UsuarioService {

    public boolean autenticarUsuario(Usuario usuario){

        boolean cpf = new UsuarioDAO().verificaCPF(usuario.getCpf());
        boolean login = new UsuarioDAO().verificaLogin(usuario.getLogin(), usuario.getSenha());
        boolean verifica = false;

        if(usuario.getCpf() == null || usuario.getLogin() ==null || usuario.getSenha() == null){

            return false;
        }

        else if(login == false && cpf == false){

            if(new UsuarioDAO().cadastrarUsuario(usuario)){

                verifica = true;
            }
            else{
                verifica = false;
            }
        }
        return verifica;
    }

    public boolean autenticarLogin(Usuario usuario) {

        boolean login = new UsuarioDAO().verificaLogin(usuario.getLogin(), usuario.getSenha());

        if(login == true){

            return false;
        }
        else{

            return true;
        }

    }


}
