/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Proprietario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class ProprietarioJava {
    
    /**
     * 
     */
    private Conexao bd;
    
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ProprietarioJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
    
    
    /**
     * 
     * @param p 
     */
    public void insert(Proprietario p) throws SQLException {
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO proprietario (lucros, gastos, nome, acesso_locacao) VALUES (?, ?, ?, ?)");
         
        stmt.setInt(1, p.getLucros());
        stmt.setInt(2, p.getGastos());
        stmt.setString(3, p.getNome());
        stmt.setString(4, p.getAcessoLocacao());
    
        stmt.execute();
        stmt.close();        
    }
    
    
    /**
     * 
     * @param p 
     */
    public void update(Proprietario p) {
        
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
    public Proprietario getById(int id) throws SQLException {
        
        Proprietario p = new Proprietario();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM proprietario WHERE id = ? ");
        stmt.setInt(1, id);
        
        return p;
    }
    
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public ArrayList<Proprietario> getAllRows() throws SQLException, Exception {
     
        ArrayList<Proprietario> lista_proprietario = new ArrayList<Proprietario>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM proprietario ");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Proprietario p = new Proprietario();
            
            p.setId(Integer.parseInt(rs.getString("descricao")));
            p.setLucros(Integer.parseInt(rs.getString("descricao")));
            p.setGastos(Integer.parseInt(rs.getString("descricao")));
            p.setNome(rs.getString("descricao"));
            p.setAcessoLocacao(rs.getString("descricao"));

            lista_proprietario.add(p);
        }

        stmt.close();
        
        return lista_proprietario;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Proprietario> findByDescricao(String descricao) {
     
        ArrayList<Proprietario> lista_proprietario = new ArrayList<Proprietario>();
        
        return lista_proprietario;        
    }
}
