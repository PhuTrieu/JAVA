
package uti;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectManager {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/2020?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url,username,pass);
            return conn;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
