/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class InfoDao {

    public Info getInformation() throws Exception {
        String query = "select [mainPic], [mainDescription], [aboutMe] from Information";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null) {
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            if (rs!=null && rs.next()) {
                Info infor = new Info();
                infor.setMainPic(rs.getString("mainPic"));
                infor.setMainDescription(rs.getString("mainDescription"));
                infor.setAboutMe(rs.getString("aboutMe"));
                return infor;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        InfoDao infoDao = new InfoDao();
        System.out.println(infoDao.getInformation());
    }
}
