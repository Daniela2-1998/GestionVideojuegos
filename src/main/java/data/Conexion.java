package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_URL="jdbc:postgresql://localhost:5432/juegos";
    private static final String JDBC_USR="dan";
    private static final String JDBC_PASS="dani";
    
    
    public static DataSource getDataSource(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USR);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(50);
        return ds;
    }

    public static Connection getConexion()throws SQLException{
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Statement st){
        try {
            st.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection cn){
        try {
            cn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
