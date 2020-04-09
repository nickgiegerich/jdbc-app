/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcapp;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.DBQuery;

/**
 *
 * @author ngiegerich
 */
public class JDBCApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Connection conn = DBConnection.startConnection();
        
        DBQuery.setStatement(conn); // Create Statement Objects
        Statement statement = DBQuery.getStatement(); // Get Statement Reference
        
        // Raw SQL insert statement
//        String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy) "
//                               + "VALUES('USA', '2020-02-22 00:00:00', 'admin', 'admin')";

//        String countryName = "Canada";
//        String createDate = "2020-02-22 00:00:00";
//        String createBy = "admin";
//        String lastUpdateBy = "admin";
//        
//        String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy)" +
//                                 "VALUES(" +
//                                 "'" +  countryName + "'," +
//                                 "'" +  createDate + "'," +
//                                 "'" +  createBy + "'," +
//                                 "'" +  lastUpdateBy + "'" +
//                                 ")";


        // Raw update statement
//        String updateStatement = "UPDATE country SET country = 'Japan' WHERE country = 'Canada'";


        // Raw delete statment 
        String deleteStatement = "DELETE FROM country WHERE country = 'Japan'";
    
        


        // Execute SQL Statment
        statement.execute(deleteStatement);
        
        
        // Confirm rows affected
        if (statement.getUpdateCount() > 0)  
            System.out.println(statement.getUpdateCount() + "row(s) affected");
        else
            System.out.println("No Rows Added");
        
        launch(args);
        
        
        DBConnection.closeConnection();
    }
    
}
