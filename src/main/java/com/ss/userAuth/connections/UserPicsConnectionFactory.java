/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eherrerra
 */
public class UserPicsConnectionFactory {

    private static Connection con = null;
    private final static String CONNECTIONSTRING = "jdbc:mysql://10.102.1.148/USER_PICS_DB",
            USERNAME = "edwin",
            SECRET = "1234";

    public static Connection getDbConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, SECRET);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return con;
    }
}
