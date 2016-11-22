/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.Item;
import UI.IItem;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author o Rafa
 */
public class DItem implements IItem {

    ConexaoSQLServer conexao = new ConexaoSQLServer();
    Item item = new Item();
    PreparedStatement preparador;

    @Override
    public void cadastrarItem(Item item) throws Exception, SQLException {
        String sql = "insert into Item(qtdEstoque, descricao, tipoItem, valor, valorPromocional, codBarras, qtdPromocao) values (? ,? ,? ,? ,? ,? ,?)";
        try {
            conexao.connect();

            preparador = conexao.connection.prepareStatement(sql);

            preparador.setInt(1, item.getQtdEstoque());
            preparador.setString(2, item.getDescricao());
            preparador.setString(3, item.getTipoItem());
            preparador.setDouble(4, item.getValor());
            preparador.setDouble(5, item.getValorPromocional());
            preparador.setLong(6, item.getCodBarras());
            preparador.setInt(7, item.getQtdPromocao());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Item Não Cadastrado !\n" + e);
        }
    }

    @Override
    public void atualizarItem(Item idItem) throws Exception, SQLException {
        String sql = "Update Item set qtdEstoque = ?, descricao = ?, tipoItem = ?, valor = ?, valorPromocional = ?, codBarras = ?, qtdPromocao = ?  where idItem = ?";

        try {
            conexao.connect();

            preparador = conexao.connection.prepareStatement(sql);

            preparador.setInt(1, item.getQtdEstoque());
            preparador.setString(2, item.getDescricao());
            preparador.setString(3, item.getTipoItem());
            preparador.setDouble(4, item.getValor());
            preparador.setDouble(5, item.getValorPromocional());
            preparador.setLong(6, item.getCodBarras());
            preparador.setInt(7, item.getQtdPromocao());
            preparador.setInt(7, item.getIdItem());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Item Não Atualizado !\n" + e);
        }
    }

    @Override
    public void deletarItem(Item idItem) throws Exception, SQLException {
        String sql = "delete from Item where idItem = ?";

        try {
            conexao.connect();
            preparador = conexao.connection.prepareStatement(sql);

            preparador.setInt(1, item.getIdItem());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Item Não Deletado !\n" + e);
        }
    }

    @Override
    public ArrayList<Item> buscarItem(Item descricao) throws Exception, SQLException {
        ArrayList<Item> itens = new ArrayList<>();
        try {
            conexao.connect();

            String sql = "select idItem, qtdEstoque, descricao, tipoItem, valor, valorPromocional, codBarras, qtdPromocao from Item where idItem = idItem";

            if (item.getDescricao() != null && item.getDescricao().trim().equals("") == false) {
                sql += " and descricao like '% " + descricao + " %'";
            }

            conexao.execSQLCode(sql);
            try {
                while (conexao.rs.next()) {
                    Item it = new Item();
                    it.setIdItem(conexao.rs.getInt("idItem"));
                    it.setQtdEstoque(conexao.rs.getInt("qtdEstoque"));
                    it.setDescricao(conexao.rs.getString("descricao"));
                    it.setTipoItem(conexao.rs.getString("tipoItem"));
                    it.setValor(conexao.rs.getDouble("valor"));
                    it.setValorPromocional(conexao.rs.getDouble("valorPromocional"));
                    it.setCodBarras(conexao.rs.getInt("codBarras"));
                    it.setQtdPromocao(conexao.rs.getInt("qtdPromocao"));
                    itens.add(it);
                }
            } catch (Exception e) {
                throw new Exception("Pesquisa sem resultado");
            }
            conexao.disconnect();
        } catch (SQLException ex) {
            throw new Exception("Erro na consulta \n" + ex);
        }
        return itens;
    }

}
