package Controller;

import model.Modelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class ModeloJava{
    
    /**
     * 
     */
    private Conexao bd;
    
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ModeloJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
    
    
    /**
     * 
     * @param c 
     */
    public void insert(Modelo m) throws SQLException {
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO carro (nome) VALUES (?)");
         
        stmt.setString(1, m.getNome());
     
         
        stmt.execute();
        stmt.close();        
    }
    
    
    /**
     * 
     * @param m 
     */
    public void update(Modelo m)throws SQLException {
        
        PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE modelo SET nome = ? WHERE id = ?");
         
        stmt.setString(1, m.getNome());
        stmt.setInt(4, m.getId());
         
        stmt.execute();
        stmt.close();         
        
    }
    
    /**
     *
     * @param id
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        
        try (PreparedStatement stmt = bd.getConn().prepareStatement("DELETE FROM modelo WHERE id = ? ")) {
            stmt.setInt(1, id);
            stmt.execute();
        } 
    }
    
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public Modelo getById(int id) throws SQLException {
        
       Modelo m = new Modelo();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM modelo WHERE id = ? ");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close(); 
        
        return m;
    }
    
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public ArrayList<Modelo> getAllRows() throws SQLException, Exception {
     
        ArrayList<Modelo> lista_modelos= new ArrayList<Modelo>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM modelo");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Modelo m = new Modelo();
            
            m.setId(Integer.parseInt (rs.getString("id_modelo")));
            m.setNome(rs.getString("nome"));
         

            lista_modelos.add(m);
        }

        stmt.close();
        
        return lista_modelos;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Modelo> findByDescricao(String _nome) throws Exception {
     
         ArrayList<Modelo> lista_modelos = new ArrayList<Modelo>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM modelo WHERE nome LIKE '%" + _nome + "%'");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Modelo m = new Modelo();
            
            m.setId(Integer.parseInt(rs.getString("id_modelo")));
            m.setNome(rs.getString("nome"));

            lista_modelos.add(m);
        }

        stmt.close(); 
        return lista_modelos;
    }
}   
   


