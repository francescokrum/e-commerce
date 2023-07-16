package com.example.trabalho.dao;

import com.example.trabalho.model.Pedido;
import com.example.trabalho.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    public ArrayList<Pedido> getPedidos() {

        ArrayList<Pedido> pedidos = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {

            String sql = "SELECT * FROM pedido ORDER BY codpedido;";

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while(rs.next()) {

                Pedido pedido = new Pedido();

                pedido.setCodpedido(rs.getInt("codpedido"));
                pedido.setCodfor(rs.getInt("codfor"));
                pedido.setCodprod(rs.getInt("codprod"));
                pedido.setQtd(rs.getDouble("qtd"));

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
    public Pedido getPedido(int codpedido){

        Pedido pedido = new Pedido();

        try(Connection con = new ConectaBD().getConexao()){

            String sql = "SELECT * FROM pedido where codpedido = ?; ";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codpedido);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){

                pedido.setCodpedido(rs.getInt("codpedido"));
                pedido.setCodfor(rs.getInt("codfor"));
                pedido.setCodprod(rs.getInt("codprod"));
                pedido.setQtd(rs.getDouble("qtd"));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return pedido;
    }

    public boolean editarPedido(Pedido pedido){

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "UPDATE pedido SET codfor = ?, codprod = ?, qtd = ? WHERE codpedido = ?";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, pedido.getCodfor());
            pt.setInt(2, pedido.getCodprod());
            pt.setDouble(3, pedido.getQtd());
            pt.setInt(4, pedido.getCodpedido());

            pt.executeQuery();

            System.out.println(""+ pedido.getCodfor());
            System.out.println(""+ pedido.getCodprod());
            System.out.println(""+ pedido.getQtd());
            System.out.println(""+ pedido.getCodpedido());

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean deletarPedido(int codpedido){


        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "DELETE FROM pedido WHERE codpedido = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codpedido);

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    public boolean cadastrarPedido(Pedido pedido) {

        boolean cadastrou = false;

        try(Connection con = new ConectaBD().getConexao()) {

            String sql = "INSERT INTO pedido (codfor, codprod, qtd) VALUES (?, ?, ?);";
            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, pedido.getCodfor());
            pt.setInt(2, pedido.getCodprod());
            pt.setDouble(3, pedido.getQtd());

            cadastrou = true;

            pt.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("cadastrou: " + cadastrou);
        return cadastrou;
    }


}
