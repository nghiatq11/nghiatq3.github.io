/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class ResultDao {
    public boolean add(Result r) throws Exception {
        String query = "INSERT INTO Result(username, score, status)\n" +
"              VALUES(?, ?, ?)";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setString(1, r.getUsername());
            ps.setFloat(2, r.getScore());
            ps.setString(3, r.getStatus());
            return ps.executeUpdate()>0;
            
        } catch (Exception e) {
            throw e;
        }

    }
}
