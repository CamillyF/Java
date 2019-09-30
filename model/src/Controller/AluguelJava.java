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
     *
 */
         private Conexao bd;
    
        public AluguelJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
        
    public void insert(Aluguel a) throws SQLException {
       
          PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO aluguel ( Dias_locados, valor_diaria, valor_total, data_locacao, pagamento;) VALUES (?, ?, ?, ?, ?)"); 
               stmt.setInt(1, a.getDiasLocados());
               stmt.setInt(2, a.getValorDiaria());
               stmt.setInt(3, a.getValorTotal());
               stmt.setInt(4, a.getDataLocacao());
               stmt.setString(5, a.getPagamento());
               
               stmt.execute();
               stmt.close();  
               // inserir no banco de dados
           }
    
      
    /**
     * 
     * @param a
     */
    public void update(Aluguel a) throws SQLException  {
        PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE aluguel SET Dias_locados = ?, valor_diaria = ?, valor_total = ?, data_locacao = ?, pagamento = ? WHERE id = ?, id_cliente = ?, id_proprietario = ?");
        
         
        stmt.setInt(1, a.getDiasLocados());
        stmt.setInt(2, a.getValorDiaria());
        stmt.setInt(3, a.getValorTotal());
        stmt.setInt(4, a.getDataLocacao());
        stmt.setString(4, a.getPagamento());
        
        stmt.setInt(4, a.getId_cliente()); 
        stmt.setInt(4, a.getId_proprietario());
        stmt.setInt(4, a.getId());
         
        stmt.execute();
        stmt.close();        
    
    }
      
    /**
     * 
     * @param ID
     */
    
    public void delete(int ID) throws SQLException {
     
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM aluguel WHERE id = ? ");
        stmt.setInt(1, ID);
        stmt.execute();
        stmt.close(); 
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
                   
                   a.setId(Integer.parseInt(rs.getString("id_aluguel")));
                     a.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
                     a.setId_proprietario(Integer.parseInt(rs.getString("id_proprietario")));
                   a.setDiasLocados(Integer.parseInt("dias_locados"));
                   a.setValorDiaria((int) Float.parseFloat("valor_diaria"));
                   a.setValorTotal((int) Float.parseFloat("valor_total"));
                   a.setDataLocacao(Integer.parseInt("data_locacao"));
                   a.setPagamento(rs.getString("pagamento"));
                   
                   lista_aluguel.add(a);
               }  }
        
        return lista_aluguel;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Aluguel> findByDescricao(String _cadastro_loc) throws SQLException, Exception{
     
        ArrayList<Aluguel> lista_aluguel = new ArrayList<>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM aluguel WHERE cadastro LIKE '%" + _cadastro_loc + "%'");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

           Aluguel a = new Aluguel();
            
            a.setId(Integer.parseInt(rs.getString("id_aluguel")));
             a.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
             a.setId_proprietario(Integer.parseInt(rs.getString("id_proprietario")));
            a.setDiasLocados(Integer.parseInt(rs.getString("dias_locados")));
            a.setValorDiaria(Integer.parseInt(rs.getString("marca")));
            a.setValorTotal(Integer.parseInt(rs.getString("modelo")));
            a.setPagamento(rs.getString("placa"));

            lista_aluguel.add(a);
        }

        stmt.close();
        
        return lista_aluguel;        
    }
    
    public void getByDone(Aluguel a) {
      
    }  
}

   
