/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;

/**
 *
 * @author aluno
 */
public class LoginController {
    
     private Conexao bd;
     
     public LoginController() throws SQLException, ClassNotFoundException {
           this.bd = new Conexao(); 
     }
     
     
     public Login faz_login(Login dados_login) throws SQLException {

         Login l = null;

         String sql = "SELECT * FROM login WHERE usuario = 'cami' AND senha = '123' "; 
         
         //System.out.println(dados_login.getUsuario() + dados_login.getSenha());
        
        PreparedStatement stmt = bd.getConn().prepareStatement(sql);
        //stmt.setString(1, dados_login.getUsuario());
        //stmt.setString(2, dados_login.getSenha());       
        
        ResultSet rs = stmt.executeQuery();
        
        //System.out.println(stmt.toString());
        
       //System.out.println( rs.next() );
        
        

        while (rs.next()) {
            
            System.out.println("aqui");

            l = new Login();
            
            l.setId(Integer.parseInt(rs.getString("id")));
        }
        
        

        stmt.close();
         
         return l;
     }
    
    
}
