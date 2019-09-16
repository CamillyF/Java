/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import model.Aluguel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class AluguelJava {
    /**
 *
 * @author aluno
     * @param a
 */
       private final Conexao bd;
    
        public AluguelJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
        
    public void insert(Aluguel a)throws SQLException {
       
           try (PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO aluguel ( Dias_locados, valor_diaria, valor_total, data_locacao, pagamento;) VALUES (?, ?, ?, ?, ?)")) {
               stmt.setInt(1, a.getDiasLocados());
               stmt.setInt(2, a.getValorDiaria());
               stmt.setInt(3, a.getValorTotal());
               stmt.setInt(4, a.getDataLocacao());
               stmt.setString(5, a.getPagamento());
               
               stmt.execute();
               stmt.close();  
               // inserir no banco de dados
           }
    }
      
    /**
     * 
     * @param a
     */
    public void update(Aluguel a) {
       
    }
      
    /**
     * 
     * @param ID
     */
    
    public void delete(int ID) {
    
    }
      /**
     * 
     * @param id
     * @return 
     * @throws java.sql.SQLException 
     */
    public Aluguel getById(int id)throws SQLException {
        
        Aluguel a = new Aluguel();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM aluguel WHERE id = ? ");
        stmt.setInt(1, id);
        
        return a;   
    }
    
     //public arrayList <model> getAllrows(Aluguel a) {
     
   // }
    
     public ArrayList<Aluguel> getAllRows() throws SQLException, Exception {
     
        ArrayList<Aluguel> lista_aluguel = new ArrayList<>();
        
           try (PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM Aluguel")) {
               ResultSet rs = stmt.executeQuery();
               
               while (rs.next()) {
                   
                   Aluguel a = new Aluguel();
                   
                   a.setId(Integer.parseInt(rs.getString("descricao")));
                     a.setId_cliente(Integer.parseInt(rs.getString("descricao")));
                     a.setId_proprietario(Integer.parseInt(rs.getString("descricao")));
                   a.setDiasLocados(Integer.parseInt("descricao"));
                   a.setValorDiaria(Integer.parseInt("descricao"));
                   a.setValorTotal((int) Float.parseFloat("descricao"));
                   a.setDataLocacao(Integer.parseInt("descricao"));
                   a.setPagamento(rs.getString("descricao"));
                   
                   lista_aluguel.add(a);
               }  }
        
        return lista_aluguel;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Aluguel> findByDescricao(String descricao) {
     
        ArrayList<Aluguel> lista_aluguel = new ArrayList<>();
        
        return lista_aluguel;        
    }
    
    public void getByDone(Aluguel a) {
      
    }  
}

   
