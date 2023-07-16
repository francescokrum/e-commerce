package com.example.trabalho.dao;

import com.example.trabalho.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public Produto getProduto(int codprod){
        Produto p = new Produto();

        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM produto WHERE codprod = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codprod);

            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                p.setCodprod(rs.getInt("codprod"));
                p.setNomeprod(rs.getString("nomeprod"));
                p.setPreco(rs.getDouble("preco"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return p;
    }
    public ArrayList<Produto> getProdutos() {

        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {

            String sql = "SELECT * FROM produto;";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();

                p.setCodprod(rs.getInt("codprod"));
                p.setNomeprod(rs.getString("nomeprod"));
                p.setPreco(rs.getDouble("preco"));
                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
    public boolean editarProduto(Produto produto){

        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE produto SET nomeprod= ?, preco = ? WHERE codprod = ?";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, produto.getNomeprod());
            pt.setDouble(2, produto.getPreco());
            pt.setInt(3, produto.getCodprod());

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean deletarProduto(int codprod){

        System.out.println("ENTROU NO DAO DELETA PRODUTO");

        System.out.println("PRODUTO: " + codprod);

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "DELETE FROM produto WHERE codprod = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codprod);

            System.out.println("FEZ A QUERY");

            pt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
    public boolean verificaProduto(String nomeprod){

        Produto p = new Produto();

        boolean tem = false;

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM produto where nomeprod = ?; ";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, nomeprod);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                p.setCodprod(rs.getInt("codprod"));
                p.setNomeprod(rs.getString("nomeprod"));
                p.setPreco(rs.getDouble("preco"));

                tem = true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return tem;
    }
    public boolean cadastrarProduto(Produto p){

        boolean cadastrou = false;

        try(Connection con  = new ConectaBD().getConexao()){

            String sql = "INSERT INTO produto (nomeprod, preco) VALUES (?, ?);";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, p.getNomeprod());
            pt.setDouble(2, p.getPreco());

            cadastrou = true;

            pt.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("CADASTROU PROD: " + cadastrou);
        return cadastrou;
    }

}
