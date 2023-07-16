package com.example.trabalho.dao;

import com.example.trabalho.model.Fornecedor;
import com.example.trabalho.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    public ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {

            String sql = "SELECT * FROM usuario ORDER BY codusuario;";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while(rs.next()) {

                Usuario u = new Usuario();

                u.setCodusuario(rs.getInt("codusuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setCargo(rs.getString("cargo"));


                usuarios.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
    public Usuario getUsuario(int codusuario){

        Usuario u = new Usuario();

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM usuario where codusuario = ?; ";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codusuario);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                u.setCodusuario(rs.getInt("codusuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setCargo(rs.getString("cargo"));
                u.setCodper(rs.getInt("codper"));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return u;
    }

    public boolean editarFuncionario(Usuario usuario){

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "UPDATE usuario SET nome= ?, cpf = ?, login = ?, senha = ?, cargo = ?, codper = ? WHERE codusuario = ?";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, usuario.getNome());
            pt.setString(2, usuario.getCpf());
            pt.setString(3, usuario.getLogin());
            pt.setString(4, usuario.getSenha());
            pt.setString(5, usuario.getCargo());
            pt.setInt(6, usuario.getCodper());
            pt.setInt(7, usuario.getCodusuario());


            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean deletarFuncionario(int codusuario){

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "DELETE FROM usuario WHERE codusuario = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codusuario);

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }


    public boolean verificaUsuario(String cpf, String login, String senha){

        Usuario u = new Usuario();

        boolean tem = false;

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM usuario WHERE cpf = ? OR login = ? OR senha = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, cpf);
            pt.setString(2, login);
            pt.setString(3, senha);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                u.setCodusuario(rs.getInt("codusuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setCargo(rs.getString("cargo"));

                tem = true;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return tem;
    }

    public boolean verificaLogin(String login, String senha){

        Usuario u = new Usuario();

        boolean tem = false;

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, login);
            pt.setString(2, senha);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                u.setCodusuario(rs.getInt("codusuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setCargo(rs.getString("cargo"));

                tem = true;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return tem;
    }

    public boolean cadastrarUsuario(Usuario usuario) {

        boolean cadastrou = false;

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "INSERT INTO usuario (nome, cpf, login, senha, cargo, codper) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, usuario.getNome());
            pt.setString(2, usuario.getCpf());
            pt.setString(3, usuario.getLogin());
            pt.setString(4, usuario.getSenha());
            pt.setString(5, usuario.getCargo());
            pt.setInt(6, usuario.getCodper());

            cadastrou = true;

            pt.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return cadastrou;
    }

}
