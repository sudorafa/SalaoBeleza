/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Negocio.Admin;
import UI.IAdmin;

/**
 *
 * @author o Rafa
 */
public class DAdmin implements IAdmin {

    ConexaoSQLServer conexao = new ConexaoSQLServer();
    Admin admin = new Admin();

    @Override
    public final Admin validarLogin(Admin admin) throws SQLException, Exception {

        String loginBanco, senhaBanco;
        int idAdmin;

        try {
            conexao.connect();
            String sql = "select login, senhaAtual, idAdmin from Admin where login = '" + admin.getLogin() + "'";
            conexao.execSQLCode(sql);
            conexao.rs.first();

            try {
                loginBanco = conexao.rs.getString("login");
                senhaBanco = conexao.rs.getString("senhaAtual");
                idAdmin = conexao.rs.getInt("idAdmin");
                admin.setIdAdmin(idAdmin);

                if (!loginBanco.equals(admin.getLogin()) || !senhaBanco.equals(admin.getSenhaAtual())) {
                    throw new Exception("Acesso Negado");
                }
            } catch (Exception e) {
                throw new Exception("Acesso Negado");
            }

            conexao.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }

    @Override
    public void cadastrarAdmin(Admin admin) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
