package com.example.trabalho.dao;

import com.example.trabalho.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {
    public ArrayList<Fornecedor> getFornecedores() {

        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {

            String sql = "SELECT * FROM fornecedor ORDER BY codfor;";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while(rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setCodfor(rs.getInt("codfor"));
                fornecedor.setNomefor(rs.getString("nomefor"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedores.add(fornecedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedores;
    }


    public Fornecedor getFornecedor(int codfor){

        Fornecedor f = new Fornecedor();

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM fornecedor where codfor = ?; ";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codfor);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                f.setCodfor(rs.getInt("codfor"));
                f.setNomefor(rs.getString("nomefor"));
                f.setCep(rs.getString("cep"));
                f.setCnpj(rs.getString("cnpj"));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return f;
    }
    public boolean editarFornecedor(Fornecedor fornecedor){

        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE fornecedor SET nomefor= ?, cep = ?, cnpj = ? WHERE codfor = ?";

            PreparedStatement pt = con.prepareStatement(sql);


            pt.setString(1, fornecedor.getNomefor());
            pt.setString(2, fornecedor.getCep());
            pt.setString(3, fornecedor.getCnpj());
            pt.setInt(4, fornecedor.getCodfor());


            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean deletarFornecedor(int codfor){

        System.out.println("CODFOR: "+ codfor);

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "DELETE FROM fornecedor WHERE codfor = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codfor);

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
    public boolean verificaFornecedor(String cnpj){

        Fornecedor fornecedor = new Fornecedor();

        boolean tem = false;

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM fornecedor where cnpj = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, cnpj);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                fornecedor.setCodfor(rs.getInt("codfor"));
                fornecedor.setNomefor(rs.getString("nomefor"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setCnpj(rs.getString("cnpj"));

                tem = true;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("tem: " + tem);
        return tem;

    }
    public boolean cadastrarFornecedor(Fornecedor fornecedor){

        boolean cadastrou = false;

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "INSERT INTO fornecedor (nomefor, cep, cnpj) VALUES (?,?,?);";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, fornecedor.getNomefor());
            pt.setString(2, fornecedor.getCep());
            pt.setString(3, fornecedor.getCnpj());

            cadastrou = true;

            pt.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("CADASTROU: " + cadastrou);

        return cadastrou;
    }
}
