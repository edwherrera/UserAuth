/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao;

import com.ss.userAuth.dao.entities.SessionDTO;
import com.ss.userAuth.dao.sql.SESSIONS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author eherrerra
 */
public class SessionDAO extends GenericDAO {

    public SessionDAO(Connection connection) {
        super(connection);
    }
    
    public List<SessionDTO> getAll() {
        List<SessionDTO> c = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(SESSIONS.GetAll.sql());

            rs = ps.executeQuery();
            while (rs.next()) {
                SessionDTO e = new SessionDTO();
                hydrateSession(e, rs);
                c.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return c;
    }
    
    public SessionDTO getByToken(String token) {
        SessionDTO e = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(SESSIONS.GetByToken.sql());
            ps.setString(1, token);

            rs = ps.executeQuery();
            while (rs.next()) {
                e = new SessionDTO();
                hydrateSession(e, rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }
        
        return e;
    }

    public void add(SessionDTO newSession) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SESSIONS.Add.sql());
            ps.setString(1, newSession.getToken());
            ps.setInt(2, newSession.getUserId());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps);
        }
    }
    
    private void hydrateSession(SessionDTO e, ResultSet rs) throws SQLException {
        e.setId(rs.getInt("id"));
        e.setUserId(rs.getInt("user_id"));
        e.setToken(rs.getString("token"));
    }

}
