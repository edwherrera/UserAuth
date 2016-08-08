/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao;

import com.ss.userAuth.dao.entities.UserDTO;
import com.ss.userAuth.dao.sql.USERS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eherrerra
 */
public class UserDAO extends GenericDAO {

    public UserDAO(Connection connection) {
        super(connection);
    }

    public List<UserDTO> getAll() {
        
        List<UserDTO> c = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(USERS.GetAll.sql());

            rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO e = new UserDTO();
                hydrateUser(e, rs);
                c.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return c;
    }
    
    public UserDTO getById(int id) {
        
        UserDTO e = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(USERS.GetById.sql());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                e = new UserDTO();
                hydrateUser(e, rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return e;
    }
    
    public UserDTO getByUsername(String username) {
        
        UserDTO e = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(USERS.GetByUsername.sql());
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                e = new UserDTO();
                hydrateUser(e, rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return e;
    }
    
    public void add(UserDTO newUser) {
        
        CallableStatement ps = null;
        
        try {
            ps = connection.prepareCall(USERS.Add.sql());
            ps.setString(1, newUser.getName());
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());
            
            ps.registerOutParameter(4, Types.INTEGER);            
            ps.execute();
            
            int newId = ps.getInt(4);
            
            newUser.setId(newId);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps);
        }
    }
    
    private void hydrateUser(UserDTO e, ResultSet rs) throws SQLException {
        e.setId(rs.getInt("id"));
        e.setName(rs.getString("name"));
        e.setPassword(rs.getString("password"));
        e.setUsername(rs.getString("username"));
    }
}
