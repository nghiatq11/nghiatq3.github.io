/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gallery;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class GalleryDao {

    public Gallery getOne(int id) throws Exception {
        String query = "select * from Gallery where id = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, id);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            if(rs!=null && rs.next()){
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setEntryName(rs.getString("entryName"));
                g.setDescription(rs.getString("description"));
                g.setDesPicture(rs.getString("desPicture"));
                return g;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    

    public List<Gallery> proceducepagingGallery(int page, int quantyGalleryInAPage) throws Exception {

        String query = "spGetRecordsByPageAndSize ?, ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, page);
            ps.setInt(2, quantyGalleryInAPage);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            List<Gallery> gallerys = new ArrayList<>();
            while (rs != null && rs.next()) {
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setEntryName(rs.getString("entryName"));
                g.setDescription(rs.getString("description"));
                g.setDesPicture(rs.getString("desPicture"));
                gallerys.add(g);
            }
            return gallerys;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Gallery> top3() throws Exception {

        String query = "Select top 3* from Gallery order by id asc";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            List<Gallery> gallerys = new ArrayList<>();
            while (rs != null && rs.next()) {
                Gallery g = new Gallery();
                g.setId(rs.getInt("id"));
                g.setEntryName(rs.getString("entryName"));
                g.setDescription(rs.getString("description"));
                g.setDesPicture(rs.getString("desPicture"));
                gallerys.add(g);
            }
            return gallerys;
        } catch (Exception e) {
            throw e;
        }
    }

    public int count() throws Exception {
        String query = "select count(*) from gallery";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw e;
        }
    }
}
