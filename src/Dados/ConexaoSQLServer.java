/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/* Refeito/Editado para conhecimento: Rafael Eduardo L
 * Autor: Marcone Melo Mendonça e Ismael Gomes
 * data: 28/02/2016
 * Classe destinada à conexão de uma aplicação Java com um Baco de Dados do SQL Server. 
 */
public class ConexaoSQLServer {

    private String usuario, senha, servidor, url, banco, instancia;
    private final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private Statement sta;
    public ResultSet rs;
    public SQLException sqle, cnfe;
    Connection connection;

    //Meu Notebook
    public ConexaoSQLServer() {
        this.usuario = "Rafa";
        this.senha = "2016";
        this.servidor = "LAPTOP-J74C8P11";
        this.banco = "SalaoBeleza";
        this.instancia = "Rafael";
        this.url = "jdbc:jtds:sqlserver://" + this.servidor + ":1433/" + this.banco + ";instance=" + this.instancia;
    }

    /*
    //Unibratec
    public ConexaoSQLServer() {
        this.usuario = "aluno";
        this.senha = "aluno";
        this.servidor = "PC-333";
        this.banco = "SalaoBeleza";
        //this.instancia = "Rafael";
        this.url = "jdbc:jtds:sqlserver://" + this.servidor + ":1433/" + this.banco;// + ";instance=" + this.instancia;
    }
     */
    public boolean connect() {
        boolean result = true;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException sqle) {
            sqle.getMessage();
            result = false;
        } catch (ClassNotFoundException cnfe) {
            result = false;
        }
        return result;
    }

    public boolean disconnect() {
        boolean result = true;
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException sqle) {
            result = false;
            sqle.getMessage();
        }
        return result;
    }

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://LAPTOP-J74C8P11:1433/SalaoBeleza;instance=Rafael", "Rafa", "2016");
            System.out.println("Conectado com sucesso!");
        } catch (SQLException sqle) {
            // TODO Auto-generated catch block
            sqle.getMessage();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        return con;

    }

    public void execSQLCode(String sql) {
        try {
            sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sta.executeQuery(sql);
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Erro durante a execução do Código SQL:\n" + "Código informado:\n" + sql + "\n\nErro:\n" + sqlException, "Erro!", 0);
        }
    }
}
