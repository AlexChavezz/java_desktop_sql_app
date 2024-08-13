package com.mycompany.testingsqlconnection.controller;

import com.mycompany.testingsqlconnection.model.Employed;
import com.mycompany.testingsqlconnection.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeController {
    public Boolean saveEmployed(Employed employed) throws SQLException;
    public Employed searchEmployed(Long key) throws SQLException;
    public Boolean updateEmployed(Employed employed, Long id) throws SQLException;
    public Boolean deleteEmployed(Long key) throws SQLException;
}
