/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao;

import java.sql.Connection;
import java.util.Arrays;

/**
 *
 * @author eherrerra
 */
public class GenericDAO {
        protected Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    protected final void close(AutoCloseable... c) {
        Arrays.asList(c).forEach(e -> {
            if (e != null) {
                try {
                    e.close();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });
    }
}
