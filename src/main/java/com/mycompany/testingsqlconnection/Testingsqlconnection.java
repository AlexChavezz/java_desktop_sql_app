/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testingsqlconnection;

import com.mycompany.testingsqlconnection.view.Login;
import com.mycompany.testingsqlconnection.view.PanelDeControl;

import java.sql.SQLException;

/**
 *
 * @author alexis
 */
public class Testingsqlconnection {

    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        login.setVisible(true);
    }
}
