/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class ClienteJava {
    
       
    private Conexao bd;
    
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
     public ClienteJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
    
    
    /**
     * 
     * @param c 
     */
    public void insert(Cliente c) throws SQLException {
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO carro (telefone, cnh, rg, nome, endereco) VALUES (?, ?, ?, ?, ? ,?)");
         
        stmt.setInt(1, c.getTelefone());
        stmt.setInt(2, c.getCnh());
        stmt.setString(3, c.getRG());
        stmt.setString(4, c.getNome());
        stmt.setString(4, c.getEndereco());
         
        stmt.execute();
        stmt.close();        
    
        // inserir no banco de dados
    }
    
        
    public void update(Cliente c) {
       
    }
     
    /**
     * 
     * @param id 
     */
    public void delete(Cliente c) {
    
    }
     
    /**
     * 
     * @param id
     * @return 
     */
    public Cliente getById(int id) throws SQLException {
        
        Cliente c = new Cliente();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM cliente WHERE id = ? ");
        stmt.setInt(1, id);
        
        return c;
       
    }
    
    public ArrayList<Cliente> getAllrows()   throws SQLException, Exception {
     
        ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM cliente ");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Cliente c = new Cliente();
            
            c.setId(Integer.parseInt (rs.getString ("descricao")));
            c.setTelefone(Integer.parseInt (rs.getString("descricao")));
            c.setCnh(Integer.parseInt (rs.getString("descricao")));
            c.setRG(rs.getString("descricao"));
            c.setNome(rs.getString("descricao"));
            c.setEndereco(rs.getString("descricao"));
    
            lista_clientes.add(c);
        }

        stmt.close();
        
        return lista_clientes;        
    }
    
    public ArrayList<Cliente> findByDescricao(String descricao) {
     
        ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
        
        return lista_clientes;        
    }
      
    } 

