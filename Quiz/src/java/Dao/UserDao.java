/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.User;
import entity.UserType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author quang
 */
public class UserDao {

    public User getone(String userName, String pass) throws Exception {
        String query = "select u.id,u.username,u.[password],u.email,t.id as tid,t.name as tname \n"
                + "from [user] u ,usertype t\n"
                + "where u.typeid = t.id\n"
                + "	and u.username = ?\n"
                + "	and u.[password] = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setString(1, userName);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            User u = new User();
            if (rs != null && rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));

                UserType t = new UserType();
                t.setId(rs.getInt("tid"));
                t.setName(rs.getString("tname"));

                u.setType(t);
                return u;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
    
    public List<UserType> getType() throws Exception {
        List<UserType> types = new ArrayList<>();
        String query = "select * from usertype";
       try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null){
           ResultSet rs = ps.executeQuery();
            while (rs!= null && rs.next()) {
                UserType t = new UserType();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                types.add(t);
            }
            return types; 
        } catch (Exception e) {
            throw e;
        }
    }
    public int addUser(String userName, String pass, int type, String email) throws Exception{
        String query = "INSERT INTO [user]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[typeid]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setString(1, userName);
            ps.setString(2, pass);
            ps.setInt(3, type);
            ps.setString(4, email);
            return ps.executeUpdate();
            
        }catch(Exception e){
            throw e;
        }
    }
        public boolean userIsExist(String username) throws Exception {
        String query = "select * from [user] where username = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));

                UserType t = new UserType();
                t.setId(rs.getInt("typeid"));
                u.setType(t);
                if (u != null) {
                    return true;
                } 
            }

        } catch (Exception e) {
            throw e;
        }
        return false;
    }
}
