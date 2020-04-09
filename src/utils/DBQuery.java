/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ngiegerich
 */
public class DBQuery {
    
    private static Statement statement; // Statement reference
    
    // Create Statement Object
    public static void setStatement(Connection conn) throws SQLException { 
        statement = conn.createStatement();
    }
    
    // Return Statement Object
    public static Statement getStatement() { 
        return statement;
    }
}
