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
    
        
    public void update(Cliente c) throws SQLException {
       PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE cliente SET telefone = ?, cnh = ?,  rg = ?, nome = ?, endereco = ? WHERE id_cliente = ?");
         
        stmt.setInt(1, c.getTelefone());
        stmt.setInt(2, c.getCnh());
        stmt.setString(3, c.getRG());
        stmt.setString(4, c.getEndereco());
        stmt.setString(4, c.getNome());
        stmt.setInt(4, c.getId());
         
        stmt.execute();
        stmt.close();        
    
    
    }
     
    /**
     * 
     * @param id 
     */
    public void delete(int Id) throws SQLException {
     PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM cliente WHERE id = ? ");
        stmt.setInt(1, Id);
        stmt.execute();
        stmt.close(); 
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
        stmt.execute();
        stmt.close(); 
        
        return c;
       
    }
    
    public ArrayList<Cliente> getAllrows()   throws SQLException, Exception {
     
        ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM cliente ");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Cliente c = new Cliente();
            
            c.setId(Integer.parseInt (rs.getString ("id_cliente")));
            c.setTelefone(Integer.parseInt (rs.getString("telefone")));
            c.setCnh(Integer.parseInt (rs.getString("cnh")));
            c.setRG(rs.getString("rg"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));
    
            lista_clientes.add(c);
        }

        stmt.close();
        
        return lista_clientes;        
    }
    
    public ArrayList<Cliente> findByDescricao( String _nome) throws SQLException, Exception {
     
        ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
      
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM cliente WHERE nome LIKE '%" + _nome + "%'");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Cliente c = new Cliente();
            
            c.setId(Integer.parseInt(rs.getString("id_cliente")));
            c.setRG(rs.getString("rg"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));
            c.setCnh(Integer.parseInt(rs.getString("cnh")));
            c.setTelefone(Integer.parseInt(rs.getString("telefone")));
            

            lista_clientes.add(c);
        }

        stmt.close();
        
            
        return lista_clientes;        
    }
      
    } 

