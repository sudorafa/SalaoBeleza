/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Negocio.Admin;
import java.sql.SQLException;

/**
 *
 * @author o Rafa
 */
public interface IAdmin {
    
    void cadastrarAdmin(Admin admin) throws Exception, SQLException;
    
    Admin validarLogin(Admin admin) throws Exception;
    
}
