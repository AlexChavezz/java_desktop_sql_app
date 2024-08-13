/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.testingsqlconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**

/**
 *
 * @author alexi
 */
public class DBConnection {
      private static String connectionString = "jdbc:mysql://140.84.170.44:3306/javaproject?user=alexis&password=password";
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Replace "connectionString" with the actual connection string
            Connection connection = DriverManager.getConnection(connectionString);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return null;
    }
     public ResultSet checkUser(String username, String password){
        Connection connect = getConnection();
        
        String query = "SELECT * FROM USUARIOS WHERE nombre='"+username+"' and " + "userPassword='"+password+"';";
        try{
           Statement statement = connect.createStatement();
           ResultSet results = statement.executeQuery(query);
           return results;
//           if(results.next()){
//                System.out.print("Existe");
//                
//           }else{
//               System.out.print("No existe");
//           }
//           while(results.next()){
//                System.out.println(results.getString("nombre") +": "+ results.getString("userPassword"));
//
//            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }
   
}
