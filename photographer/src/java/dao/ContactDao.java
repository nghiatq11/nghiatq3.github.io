/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class ContactDao {
    public Contact getContact() throws Exception{
        
        String query = "Select * from Contact";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contact c = new Contact();
           // c.setId(rs.getInt("id"));
            c.setAddress(rs.getString("address"));
            c.setCity(rs.getString("city"));
            c.setCountry(rs.getString("country"));
            c.setTel(rs.getString("tel"));
            c.setEmail(rs.getString("email"));
            return c;
        }
        }catch(Exception e){
            throw e;
        }
        return null;
    }
}
