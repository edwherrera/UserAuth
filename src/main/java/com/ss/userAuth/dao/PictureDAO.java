/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao;

import com.ss.userAuth.dao.entities.PictureDTO;
import com.ss.userAuth.dao.sql.PICTURES;
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
public class PictureDAO extends GenericDAO {
    
    public PictureDAO(Connection connection) {
        super(connection);
    }
    
    public List<PictureDTO> getAll() {
        
        List<PictureDTO> c = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(PICTURES.GetAll.sql());

            rs = ps.executeQuery();
            while (rs.next()) {
                PictureDTO e = new PictureDTO();
                hydratePicture(e, rs);
                c.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return c; 
    }
    
    public List<PictureDTO> getByUserId(int userId) {
        
        List<PictureDTO> c = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(PICTURES.GetByUserId.sql());
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                PictureDTO e = new PictureDTO();
                hydratePicture(e, rs);
                c.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close(ps, rs);
        }

        return c; 
    }

    private void hydratePicture(PictureDTO e, ResultSet rs) throws SQLException {
        e.setId(rs.getInt("id"));
        e.setLocation(rs.getString("location"));
        e.setUserId(rs.getInt("user_id"));
    }
}
