package com.mycompany.testingsqlconnection.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    private java.sql.Connection connection;

    private static final String connectionString = "jdbc:mysql://%s:%d/%s";

    public Connection() {
        connection = null;
    }

    public void start() throws SQLException {
        String databaseName = System.getenv("DATABASE_NAME"); // Assuming this is the missing environment variable
        int port = Integer.parseInt(System.getenv("PORT")); // Assuming port is an integer

        connection = DriverManager.getConnection(
                String.format(connectionString, System.getenv("HOST"), port, databaseName),
                System.getenv("USERNAME"),
                System.getenv("PASSWORD")
        );
    }

    public void close () {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet excecute(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public Boolean simpleExcecute(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        return stmt.execute(query);
    }
}
