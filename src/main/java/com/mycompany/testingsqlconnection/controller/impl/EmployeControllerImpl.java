package com.mycompany.testingsqlconnection.controller.impl;

import com.mycompany.testingsqlconnection.controller.IEmployeController;
import com.mycompany.testingsqlconnection.model.Connection;
import com.mycompany.testingsqlconnection.model.Employed;
import com.mycompany.testingsqlconnection.model.Gender;

import static com.mycompany.testingsqlconnection.utils.GenderEnumParsing.parseGender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeControllerImpl implements IEmployeController {

    private final Connection connection;

    public EmployeControllerImpl(){
        connection = new Connection();
    }

    @Override
    public Boolean saveEmployed(Employed employed) throws SQLException {
        String query = "INSERT INTO employees (name, address, phoneNumber, birthDate, email, gender) VALUES " +
                "('" + employed.getName() + "'," +"'"+employed.getAddress()+"',"+"'"+employed.getPhoneNumber()+"',"+"'"+employed.getBirthDate()+"',"+"'"+employed.getEmail()+"',"+"'"+employed.getGender()+"');";

        connection.start();
        Boolean results = connection.simpleExcecute(query);
        connection.close();
        return results;
    }

    @Override
    public Employed searchEmployed(Long key) throws SQLException {
        connection.start();
        String query = "SELECT * FROM employees WHERE ID = " + key;
        ResultSet resultSet = connection.excecute(query);
        if (resultSet.next()){
            return  Employed.builder()
                    .name(resultSet.getString("name"))
                    .address(resultSet.getString("address"))
                    .phoneNumber(resultSet.getString("phoneNumber"))
                    .birthDate(resultSet.getString("birthDate"))
                    .email(resultSet.getString("email"))
                    .gender(parseGender(resultSet.getString("gender")))
                    .build();
        }
        connection.close();
        return null;
    }

    @Override
    public Boolean updateEmployed(Employed employed, Long id) throws SQLException {
        connection.start();
        String query =
                "UPDATE employees SET name = '" + employed.getName() + "', address = '" + employed.getAddress() + "', phoneNumber = '" + employed.getPhoneNumber() + "', birthDate = '" + employed.getBirthDate() + "', email = '" + employed.getEmail() + "', gender = '" + employed.getGender()+ "' WHERE ID = " + id + ";";
        Boolean result = connection.simpleExcecute(query);
        connection.close();
        return result;
    }

    @Override
    public Boolean deleteEmployed(Long key) throws SQLException {
        connection.start();
        String query = "DELETE FROM employees WHERE ID = " + key;
        Boolean resultSet = connection.simpleExcecute(query);
        connection.close();
        return resultSet;
    }

}
