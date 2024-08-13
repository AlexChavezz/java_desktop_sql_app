package com.mycompany.testingsqlconnection.controller;

import com.mycompany.testingsqlconnection.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IUserController {
    public User findUserByUserNameAndPassword(String userName, String  password) throws SQLException;
}
