/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngiegerich
 */
public class DBConnection {
    
    // JDBC URL parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//3.227.166.251/U05z0B";
    
    // JDBC URL
    private static final String jdbcURL = protocol + vendorName + ipAddress;
            
    // Driver and Connection Interface reference
    private static final String MYSQLJDBCDriver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    
    
    private static final String username = "U05z0B"; // Username
    private static final String password = "********"; // Password
    
    public static Connection startConnection() { 
        
        try {
            
            Class.forName(MYSQLJDBCDriver);
            conn = (Connection)DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection succesful");
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println(e.getMessage());
            
        }
        return conn;
    }
    
    public static void closeConnection(){ 
        
        try { 
            
            conn.close();
            System.out.println("Connection closed.");
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            
        }
    }
    
    
}
