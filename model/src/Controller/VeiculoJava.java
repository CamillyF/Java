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
    public void update(Veiculo v) throws SQLException {
        
        PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE veiculo SET placa = ? cadastro = ?, cor = ?, ano = ?, cadastro_loc = ? WHERE id_veiculo = ?, id_marca = ?, id_modelo = ?, id_cliente = ?");
         
        stmt.setString(1, v.getPlaca());
        stmt.setString(2, v.getCor());
        stmt.setString(3, v.getCadastro());
        stmt.setString(4, v.getAno());
        stmt.setString(2, v.getCadastroLoc());
        stmt.setInt(3, v.getId());
        stmt.setInt(4, v.getId_marca());
        stmt.setInt(2, v.getId_modelo());
        stmt.setInt(3, v.getId_cliente());
        stmt.setInt(4, v.getId());
         
        stmt.execute();
        stmt.close();        
    }
    
    
    /**
     * 
     * @param id 
     * @throws java.sql.SQLException 
     */
    public void delete(int id) throws SQLException {
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM veiculo WHERE id = ? ");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close(); 
        
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
            
            v.setId(Integer.parseInt(rs.getString("id")));
              v.setId_marca(Integer.parseInt(rs.getString("id_marca")));
              v.setId_modelo(Integer.parseInt(rs.getString("id_modelo")));
              v.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
            v.setPlaca(rs.getString("placa"));
            v.setCadastro(rs.getString("cadastro"));
            v.setCor(rs.getString("cor"));
            v.setAno(rs.getString("ano"));
            v.setCadastroLoc(rs.getString("cadastro_loc"));

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
    public ArrayList<Veiculo> findByModeloMarca(String _modelo) throws Exception {
     
        ArrayList<  Veiculo> lista_veiculos = new ArrayList<Veiculo>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM veiculo WHERE modelo LIKE '%" + _modelo + "%'");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Veiculo v = new Veiculo();
            
            v.setId(Integer.parseInt(rs.getString("id_veiculo")));
            v.setCor(rs.getString("cor"));
            v.setPlaca(rs.getString("placa"));
            v.setPlaca(rs.getString("ano"));   
            v.setPlaca(rs.getString("cadastro"));
            v.setPlaca(rs.getString("cadastro_loc"));
            v.setPlaca(rs.getString("id_modelo"));
            v.setPlaca(rs.getString("id_cliente"));
            v.setPlaca(rs.getString("id_marca"));

            lista_veiculos.add(v);
        }

        stmt.close();
        return lista_veiculos;        
    }
}
