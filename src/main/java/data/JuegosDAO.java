package data;

import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Juegos;

/**
 *
 * @author Daniela
 */
public class JuegosDAO {
    
    //                           QUERYS 
    private static final String SQL_SELECT = "SELECT * FROM juegos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM juegos WHERE "
            + "idjuego = ?";
    private static final String SQL_INSERT = "INSERT INTO juegos (nombre, genero, "
            + "plataforma, unidades, precio) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE libros SET nombre = ?, "
            + "genero = ?, plataforma = ?, unidades = ?, precio = ? "
            + "WHERE idjuego = ?";
    private static final String SQL_DELETE = "DELETE FROM juegos WHERE idjuego = ?";
    
    
    
    //                         MÉTODOS
    
    // SELECCIONAR
    public List<Juegos> seleccionar() throws SQLException{
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Juegos juegos = null;
        List<Juegos> listaJuegos = new ArrayList();
        
        try{
            conn = getConexion();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            
            while(rs.next()){
                int idjuego = rs.getInt("idjuego");
                String nombre = rs.getString("nombre");
                String genero = rs.getString("genero");
                String plataforma = rs.getString("plataforma");
                int unidades = rs.getInt("unidades");
                double precio = rs.getDouble("precio");
                
                juegos = new Juegos(idjuego, nombre, genero, plataforma, 
                        unidades, precio);
                listaJuegos.add(juegos);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try{
                rs.close();
                pst.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return listaJuegos;
    }
    
    // INSERTAR
    public int insertar(Juegos juegos){
        Connection conn = null;
        PreparedStatement pst = null;
        int registrosMod = 0;

        try {
            conn = getConexion();
            pst = conn.prepareStatement(SQL_INSERT);
            pst.setString(1, juegos.getNombre());
            pst.setString(2, juegos.getGenero());
            pst.setString(3, juegos.getPlataforma());
            pst.setInt(4, juegos.getUnidades());
            pst.setDouble(5, juegos.getPrecio());

            registrosMod = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosMod;
    }
    
    // ACTUALIZAR
    public int actualizar(Juegos juegos){
        Connection conn = null;
        PreparedStatement pst = null;
        int registrosMod = 0;

        try {
            conn = getConexion();
            pst = conn.prepareStatement(SQL_UPDATE);
            pst.setString(1, juegos.getNombre());
            pst.setString(2, juegos.getGenero());
            pst.setString(3, juegos.getPlataforma());
            pst.setInt(4, juegos.getUnidades());
            pst.setDouble(5, juegos.getPrecio());

            registrosMod = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosMod;
    }
    
    // ELIMINAR
    public int eliminar(int idjuego){
        Connection conn = null;
        PreparedStatement pst = null;
        int registrosMod = 0;

        try {
            conn = getConexion();
            pst = conn.prepareStatement(SQL_DELETE);
            pst.setInt(1, idjuego);
            
            registrosMod = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosMod;
    }
    
    // SELECIONAR POR ID
    public Juegos seleccionarPorID(int id){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Juegos juegos = null;
        
        try{
            conn = getConexion();
            pst = conn.prepareStatement(SQL_SELECT_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                int idjuego = rs.getInt("idjuego");
                String nombre = rs.getString("nombre");
                String genero = rs.getString("genero");
                String plataforma = rs.getString("plataforma");
                int unidades = rs.getInt("unidades");
                double precio = rs.getDouble("precio");
                
                juegos = new Juegos(idjuego, nombre, genero, plataforma, 
                        unidades, precio);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try{
                rs.close();
                pst.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return juegos;
    }
    
    
    
    
    
}

