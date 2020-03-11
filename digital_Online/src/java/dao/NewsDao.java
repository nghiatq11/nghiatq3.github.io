/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.News;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;
import utils.NewsFormat;

/**
 * 
 * @author quang
 */
public class NewsDao {

    public List<News> getTopFiveMostRecentNews() throws Exception {
        String query = "select top 5* from News where publishedDate not in \n"
                + "(select max(publishedDate) from News) order by publishedDate desc";
        List<News> fiveLatest = new ArrayList<>();
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null) {
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            while (rs != null && rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                fiveLatest.add(news);
            }
            return fiveLatest;
        } catch (Exception e) {
            throw e;
        }
    }

    public News getMostRecentNews() throws Exception {

        //select latest news by order the publishedDate descending, then take the first
        String query = "select top 1 * from News order by publishedDate desc";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null) {
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            if (rs != null && rs.next()) {    //data existed on database
                News news = new News();
                news.setPublishedDate(NewsFormat.parseDatetimeStringToDate(rs.getString("publishedDate")));
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setWriter(rs.getString("writer"));
                news.setShortDescription(rs.getString("shortDescription"));
                news.setFullDescription(rs.getString("fullDescription"));
                news.setImage(new SQLServerConnection().getImagePath()+rs.getString("img"));
                return news;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public News getNewsById(String id) throws Exception {
        String query = "select * from News where id = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null) {
            ps.setString(1, id);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            if (rs != null && rs.next()) {    //data existed on database
                News news = new News();
                news.setPublishedDate(NewsFormat.parseDatetimeStringToDate(rs.getString("publishedDate")));
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setWriter(rs.getString("writer"));
                news.setShortDescription(rs.getString("shortDescription"));
                news.setFullDescription(rs.getString("fullDescription"));
                news.setImage(new SQLServerConnection().getImagePath()+rs.getString("img"));
                return news;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<News> proceduceSearchNews(int page, int quantyNewsInAPage, String title) throws Exception {
        
        String query = "pagingSearchNews ?, ?, ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, page);
            ps.setInt(2, quantyNewsInAPage);
            ps.setString(3, title);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            List<News> list = new ArrayList<>();
            while (rs != null && rs.next()) {
                News news = new News();
                news.setPublishedDate(NewsFormat.parseDatetimeStringToDate(rs.getString("publishedDate")));
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setWriter(rs.getString("writer"));
                news.setShortDescription(rs.getString("shortDescription"));
                news.setFullDescription(rs.getString("fullDescription"));
                news.setImage(new SQLServerConnection().getImagePath()+rs.getString("img"));
                list.add(news);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public int count(String txt) throws Exception {
        String query = "select count(*) from News \n"
                + "where title like ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {

            ps.setString(1, "%" + txt + "%");
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

//    public static void main(String[] args) throws Exception {
//        
//            NewsDao newsDao = new NewsDao();
//            System.out.println(newsDao.getMostRecentNews().getTitle());
//        
//    }
}
