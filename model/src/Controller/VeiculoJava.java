/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Veiculo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class VeiculoJava {
    
    /**
     * 
     */
    private Conexao bd;
    
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public VeiculoJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
    
    
    /**
     * 
     * @param v 
     */
    public void insert(Veiculo v) throws SQLException {
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO veiculo (placa, cadastro, cor, ano, cadastro_loc) VALUES (?, ?, ?, ?, ?)");
         
        stmt.setString(1, v.getPlaca());
        stmt.setString(2, v.getCadastro());
        stmt.setString(3, v.getCor());
        stmt.setString(4, v.getAno());
        stmt.setString(5, v.getCadastroLoc());
         
        stmt.execute();
        stmt.close();        
    }
    
    
    /**
     * 
     * @param c 
     */
    public void update(Veiculo v) {
        
    }
    
    
    /**
     * 
     * @param id 
     */
    public void delete(int id) {
        
    }
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public Veiculo getById(int id) throws SQLException {
        
        Veiculo v = new Veiculo();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM veiculo WHERE id = ? ");
        stmt.setInt(1, id);
        
        return v;
    }
    
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public ArrayList<Veiculo> getAllRows() throws SQLException, Exception {
     
        ArrayList<Veiculo> lista_veiculos = new ArrayList<Veiculo>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM veiculo");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Veiculo v = new Veiculo();
            
            v.setId(Integer.parseInt(rs.getString("descricao")));
              v.setId_marca(Integer.parseInt(rs.getString("descricao")));
              v.setId_modelo(Integer.parseInt(rs.getString("descricao")));
              v.setId_cliente(Integer.parseInt(rs.getString("descricao")));
            v.setPlaca(rs.getString("descricao"));
            v.setCadastro(rs.getString("descricao"));
            v.setCor(rs.getString("descricao"));
            v.setAno(rs.getString("descricao"));
            v.setCadastroLoc(rs.getString("descricao"));

            lista_veiculos.add(v);
        }

        stmt.close();
        
        return lista_veiculos;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Veiculo> findByDescricao(String descricao) {
     
        ArrayList<  Veiculo> lista_veiculos = new ArrayList<Veiculo>();
        
        return lista_veiculos;        
    }
}
