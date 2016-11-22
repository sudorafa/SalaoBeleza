/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocio.Cliente;
import UI.ICliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class DCliente implements ICliente {

    ConexaoSQLServer conexao = new ConexaoSQLServer();
    Cliente cliente = new Cliente();
    PreparedStatement preparador;

    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception, SQLException {
        String sql = "insert into Cliente(nome, bairro, cidade, cpf, telefone, sexo, nascimento) values (? ,? ,? ,? ,? ,? ,?)";
        try {
            conexao.connect();

            preparador = conexao.connection.prepareStatement(sql);

            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getBairro());
            preparador.setString(3, cliente.getCidade());
            preparador.setString(4, cliente.getCpf());
            preparador.setLong(5, cliente.getTelefone());
            preparador.setString(6, cliente.getSexo());
            preparador.setString(7, cliente.getNascimento());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Cliente Não Cadastrado !\n" + e);
        }
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws Exception, SQLException {
        String sql = "Update Cliente set Nome = ?, Bairro = ?, Cidade = ?, Cpf = ?, Telefone = ?, Sexo = ?, Nascimento = ?  where codCliente = ?";

        try {
            conexao.connect();

            preparador = conexao.connection.prepareStatement(sql);

            preparador.setString(1, cliente.getNome());
            preparador.setString(2, cliente.getBairro());
            preparador.setString(3, cliente.getCidade());
            preparador.setString(4, cliente.getCpf());
            preparador.setLong(5, cliente.getTelefone());
            preparador.setString(6, cliente.getSexo());
            preparador.setString(7, cliente.getNascimento());
            preparador.setInt(8, cliente.getCodCliente());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Cliente Não Atualizado !\n" + e);
        }
    }

    @Override
    public void deletarCliente(Cliente codCliente) throws SQLException, Exception {
        String sql = "delete from Cliente where codCliente = ?";

        try {
            conexao.connect();
            preparador = conexao.connection.prepareStatement(sql);

            preparador.setInt(1, cliente.getCodCliente());

            preparador.execute();
            preparador.close();

            conexao.disconnect();
        } catch (SQLException e) {
            throw new Exception("Cliente Não Deletado !\n" + e);
        }
    }

    @Override
    public Cliente buscarCliente(Cliente cpf) throws SQLException, Exception {
        try {
            conexao.connect();

            String sql = "select codCliente, nome, bairro, cidade, cpf, telefone, sexo, nascimento from Cliente where cpf = " + cpf;

            conexao.execSQLCode(sql);
            conexao.rs.first();
            try {
                cliente.setCodCliente(conexao.rs.getInt("codCliente"));
                cliente.setNome(conexao.rs.getString("nome"));
                cliente.setBairro(conexao.rs.getString("bairro"));
                cliente.setCidade(conexao.rs.getString("cidade"));
                cliente.setCpf(conexao.rs.getString("cpf"));
                cliente.setTelefone(conexao.rs.getInt("telefone"));
                cliente.setSexo(conexao.rs.getString("sexo"));
                cliente.setNascimento(conexao.rs.getString("nascimento"));
            } catch (Exception e) {
                throw new Exception("Erro nos paranauéis \n" + e);
            }
            conexao.disconnect();
        } catch (SQLException ex) {
            throw new Exception("Erro na consulta \n" + ex);
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> listarCliente(Cliente nome) throws Exception, SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            conexao.connect();

            String sql = "select codCliente, nome, bairro, cidade, cpf, telefone, sexo, nascimento from Cliente where codCliente = codCliente";

            if (cliente.getNome() != null && cliente.getNome().trim().equals("") == false) {
                sql += " and nome like '% " + nome + " %'";
            }

            conexao.execSQLCode(sql);
            try {
                while (conexao.rs.next()) {
                    Cliente cli = new Cliente();
                    cli.setCodCliente(conexao.rs.getInt("codCliente"));
                    cli.setNome(conexao.rs.getString("nome"));
                    cli.setBairro(conexao.rs.getString("bairro"));
                    cli.setCidade(conexao.rs.getString("cidade"));
                    cli.setCpf(conexao.rs.getString("cpf"));
                    cli.setTelefone(conexao.rs.getInt("telefone"));
                    cli.setSexo(conexao.rs.getString("sexo"));
                    cli.setNascimento(conexao.rs.getString("nascimento"));
                    clientes.add(cli);
                }
            } catch (Exception e) {
                throw new Exception("Pesquisa sem resultado");
            }
            conexao.disconnect();
        } catch (SQLException ex) {
            throw new Exception("Erro na consulta \n" + ex);
        }
        return clientes;
    }
}
