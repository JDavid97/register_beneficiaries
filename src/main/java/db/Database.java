
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    protected  Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/ayvdiningroom";
    
    private final String USER = "root";
    private final String PASS = "judaorfi0997";
    
    public void Conect() throws SQLException{
        conexion = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    
    public void Close() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
