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
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO cliente (telefone,numero,telefonemer, renda, complemento, cidade, estado ,sexo, datanas, cnh, rg, cpf, nome, endereco)" + "VALUES (?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)");
         
        stmt.setInt(1, c.getTelefone());
        stmt.setInt(2, c.getNumero());
        stmt.setInt(3, c.getTelefonemer());
        stmt.setInt(4, c.getRenda());
        stmt.setString(5, c.getComplemento());
        stmt.setString(6, c.getCidade());
        stmt.setString(7, c.getEstado());
        stmt.setString(8, c.getSexo());
        stmt.setString(9, c.getDatanas());
        stmt.setString(10, c.getCnh());
        stmt.setString(11, c.getCpf());
        stmt.setString(12, c.getRG());
        stmt.setString(13, c.getEndereco());
        stmt.setString(14, c.getNome());
         
        stmt.execute();
        stmt.close();        
    
        // inserir no banco de dados
    }
    
        
    public void update(Cliente c) throws SQLException {
       PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE cliente SET telefone = ?,numero = ?,telefonemer = ?, renda = ?, complemento = ?, cidade = ?, estado = ? ,sexo = ?, datanas = ?, cnh = ?, rg = ?, cpf = ?, nome = ?, endereco = ? WHERE id_cliente = ?");
         
        stmt.setInt(1, c.getTelefone());
        stmt.setInt(2, c.getNumero());
        stmt.setInt(3, c.getTelefonemer());
        stmt.setInt(4, c.getRenda());
        stmt.setString(5, c.getComplemento());
        stmt.setString(6, c.getCidade());
        stmt.setString(7, c.getEstado());
        stmt.setString(8, c.getSexo());
        stmt.setString(9, c.getDatanas());
        stmt.setString(10, c.getCnh());
        stmt.setString(11, c.getCpf());
        stmt.setString(12, c.getRG());
        stmt.setString(13, c.getEndereco());
        stmt.setString(14, c.getNome());
        stmt.setInt(15, c.getId());
         
        stmt.execute();
        stmt.close();        
    
    
    }
     
    /**
     * 
     * @param id 
     */
    public void delete(int Id) throws SQLException {
     PreparedStatement stmt = bd.getConn().prepareStatement("DELETE FROM cliente WHERE id = ? ");
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
            c.setCnh(rs.getString("cnh"));
            c.setRG(rs.getString("rg"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefonemer(rs.getInt("telefonemer"));
            c.setNumero(rs.getInt("Numero"));
            c.setRenda(rs.getInt("Renda"));
            c.setComplemento(rs.getString("complemento"));
            c.setCidade(rs.getString("cidade"));
            c.setSexo(rs.getString("sexo"));
            c.setEstado(rs.getString("estado"));
            c.setDatanas(rs.getString("datanas"));
            c.setCpf(rs.getString("cpf"));
     
      
        
    
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
            c.setCnh(rs.getString("cnh"));
            c.setTelefone(Integer.parseInt(rs.getString("telefone")));
            c.setTelefonemer(Integer.parseInt(rs.getString("telefonemer")));
            c.setNumero(Integer.parseInt(rs.getString("Numero")));
            c.setRenda(Integer.parseInt(rs.getString("Renda")));
            c.setComplemento(rs.getString("complemento"));
            c.setCidade(rs.getString("cidade"));
            c.setSexo(rs.getString("sexo"));
            c.setEstado(rs.getString("estado"));
            c.setDatanas(rs.getString("datanas"));
            c.setCpf(rs.getString("cpf"));

            lista_clientes.add(c);
        }

        stmt.close();
        
            
        return lista_clientes;        
    }
      
    } 

