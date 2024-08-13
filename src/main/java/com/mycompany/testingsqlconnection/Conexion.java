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
public class Conexion {
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
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }
    public void saveEmployed(String nombre, String domicilio, String telefono, String fechaNacimiento, String email, String genero){
        Connection connection =  null;
        
        try{
            connection = getConnection();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO EMPLEADOS (NOMBRE, DOMICILIO, TELEFONO, FECHA_NACIMIENTO, EMAIL, GENERO) VALUES ('" + nombre + "'," +"'"+domicilio+"',"+"'"+telefono+"',"+"'"+fechaNacimiento+"',"+"'"+email+"',"+"'"+genero+"');";
            stmt.execute(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }     
    }
    public ResultSet searchEmployed(int key){
           Connection connection =  null;
        try{
            connection = getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM EMPLEADOS WHERE CLAVE="+key+";";
            System.out.print(query);
            ResultSet results = stmt.executeQuery(query);
            return results;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void updateEmployed(int key, String name, String address, String phone, String date, String email, String genere){
        Connection connection = null;
        Statement stmt = null;
        try{
            connection = getConnection();
            stmt = connection.createStatement();
            
            String query = "UPDATE EMPLEADOS SET NOMBRE='" +name+"', FECHA_NACIMIENTO='" + date +"', TELEFONO='"+phone+"', EMAIL='"+email+"', GENERO='"+genere+"', DOMICILIO='"+address+"' WHERE CLAVE="+key+";";
            stmt.execute(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
   
}
