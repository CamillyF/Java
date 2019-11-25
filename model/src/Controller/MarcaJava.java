package Controller;

import model.Marca;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class MarcaJava {
    
    /**
     * 
     */
    private Conexao bd;
    
    
    /**
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public MarcaJava() throws SQLException, ClassNotFoundException {
        
        this.bd = new Conexao();        
    }    
    
    
    /**
     * 
     * @param ma 
     */
    public void insert(Marca ma) throws SQLException {
       
        PreparedStatement stmt = bd.getConn().prepareStatement("INSERT INTO marca (nome) VALUES (? )");
         
        stmt.setString(1, ma.getModelo());
 
         
        stmt.execute();
        stmt.close();        
    }
    
    
    /**
     * 
     * @param c 
     */
    public void update(Marca ma)throws SQLException {
        
        PreparedStatement stmt = bd.getConn().prepareStatement("UPDATE marca SET nome = ? WHERE id = ?");
         
        stmt.setString(1, ma.getNome());
        stmt.setInt(4, ma.getId());
         
        stmt.execute();
        stmt.close();    
    }
    
    
    /**
     * 
     * @param id 
     */
    public void delete(int id) throws SQLException {
           
        PreparedStatement stmt = bd.getConn().prepareStatement("DELETE  FROM marca WHERE id = ? ");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close(); 
    }
    
    
    /**
     * 
     * @param id
     * @return 
     */
    public Marca  getById(int id) throws SQLException {
        
        Marca ma = new Marca ();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM marca WHERE id = ? ");
        stmt.setInt(1, id);
           stmt.execute();
        stmt.close(); 
        
        return ma;
    }
    
    
    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public ArrayList<Marca> getAllRows() throws SQLException, Exception {
     
        ArrayList<Marca> lista_marcas = new ArrayList<Marca>();
        
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM marca ");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Marca ma = new Marca();
            
            ma.setId(Integer.parseInt(rs.getString("id")));
            ma.setNome(rs.getString("Nome"));
       

            lista_marcas.add(ma);
        }

        stmt.close();
        
        return lista_marcas;        
    }
    
    
    /**
     * 
     * @param descricao
     * @return 
     */
    public ArrayList<Marca> findByDescricao(String _nome) throws SQLException, Exception {
     
        ArrayList<Marca> lista_marcas = new ArrayList<Marca>();
        PreparedStatement stmt = bd.getConn().prepareStatement("SELECT * FROM marca WHERE nome LIKE '%" + _nome + "%'");
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Marca ma = new Marca();
            
            ma.setId(Integer.parseInt(rs.getString("id_marca")));
            ma.setNome(rs.getString("nome"));

            lista_marcas.add(ma);
        }

        stmt.close();
        return lista_marcas;        
    }
}
