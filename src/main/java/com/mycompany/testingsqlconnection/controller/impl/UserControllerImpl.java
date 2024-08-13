package com.mycompany.testingsqlconnection.controller.impl;

import com.mycompany.testingsqlconnection.controller.IUserController;
import com.mycompany.testingsqlconnection.model.Connection;
import com.mycompany.testingsqlconnection.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserControllerImpl implements IUserController {

    Connection connection = new Connection();
    @Override
    public User findUserByUserNameAndPassword(String userName, String password) throws SQLException {
        User user;
        String sqlQuery = "SELECT * FROM USERS WHERE userName = '" + userName + "' AND password = '" + password + "';";
        connection.start();
        ResultSet result = connection.excecute(sqlQuery);
        if(result.next()){
            return new User(result.getString("userName"), result.getString("password"));
        }
        connection.close();
        return null;
    }
}
