/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gallery;
import entity.Image;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class ImgDao {

    public List<Image> proceducepagingImg(int page, int quantyImgInAPage, int idGallery) throws Exception {

        String query = "spGetImgsByPageAndSize ?, ?, ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, page);
            ps.setInt(2, quantyImgInAPage);
            ps.setInt(3, idGallery);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            List<Image> imgs = new ArrayList<>();
            while (rs != null && rs.next()) {
                Image i = new Image();
                i.setId(rs.getInt("id"));
                i.setIdGallery(rs.getInt("GalleryID"));
                i.setPath(rs.getString("PicturePath"));
                imgs.add(i);
            }
            return imgs;
        } catch (Exception e) {
            throw e;
        }
    }

    public int count() throws Exception {
        String query = "select count(*) from picture";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw e;
        }
    }
}
