/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Negocio.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public interface ICliente {
    void cadastrarCliente(Cliente cliente) throws Exception, SQLException;

    void atualizarCliente(Cliente cliente) throws Exception, SQLException;

    void deletarCliente(Cliente codCliente) throws Exception, SQLException;
    
    Cliente buscarCliente(Cliente codCliente) throws Exception, SQLException;

    ArrayList<Cliente> listarCliente(Cliente cliente) throws Exception, SQLException;

}
