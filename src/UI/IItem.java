/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Negocio.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public interface IItem {

    void cadastrarItem(Item item) throws Exception, SQLException;

    void atualizarItem(Item idItem) throws Exception, SQLException;

    void deletarItem(Item idItem) throws Exception, SQLException;

    ArrayList<Item> buscarItem(Item descricao) throws Exception, SQLException;

}
