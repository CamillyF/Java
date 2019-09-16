/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author aluno
 */
import java.sql.*;

/**
 *
 * @author aluno
 */
public class Conexao {
    
    private static final String host = "localhost";
    private static String database = "locadora";
    private static String usuario = "root";
    private static String senha = "";
    private static String url = "jdbc:mysql://" + host + "/" + database;
    
    private Connection conn;
     
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Conexao() throws SQLException, ClassNotFoundException
    {        
        Class.forName("com.mysql.jdbc.Driver");

        conn = (Connection) DriverManager.getConnection(url, usuario, senha);        
    }
    
    
    /**
     * 
     * @return 
     */
    public Connection getConn() {
        return this.conn;
    }
     
    
    /**
     * 
     * @throws SQLException 
     */
    public void fecharConexao() throws SQLException
    {        
       conn.close();
    }          
}