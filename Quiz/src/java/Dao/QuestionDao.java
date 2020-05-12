/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Question;
import java.sql.CallableStatement;
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
public class QuestionDao {

    public int totalQuestions() throws Exception {
        int total = 0;
        String query = "select COUNT(id) as total from questions";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Question> RandomQuestion(int quantity) {
        List<Question> questions = new ArrayList<>();
        String query = "select top (?) * from questions order by NEWID()";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
                ps.setInt(1, quantity);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setO1(rs.getString("option_1"));
                question.setO2(rs.getString("option_2"));
                question.setO3(rs.getString("option_3"));
                question.setO4(rs.getString("option_4"));
                questions.add(question);
            }

            return questions;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public Question getOne(int id) {
        String query = "select * from questions where id = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            if (ps != null) {
                ps.setInt(1, id);
            }
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setO1(rs.getString("option_1"));
                question.setO2(rs.getString("option_2"));
                question.setO3(rs.getString("option_3"));
                question.setO4(rs.getString("option_4"));
                question.setAnswer(rs.getString("answer"));
                return question;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addQuestion(String question, String opt1, String opt2, String opt3, String opt4, String answer, int teacherId) throws Exception {
        String query = "INSERT INTO [questions]\n"
                + "           ([question]\n"
                + "           ,[option_1]\n"
                + "           ,[option_2]\n"
                + "           ,[option_3]\n"
                + "           ,[option_4]\n"
                + "           ,[answer]\n"
                + "           ,[created_date]\n"
                + "           ,[teacher_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,(select GETDATE())\n"
                + "           , ?)";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setString(1, question);
            ps.setString(2, opt1);
            ps.setString(3, opt2);
            ps.setString(4, opt3);
            ps.setString(5, opt4);
            ps.setString(6, answer);
            ps.setInt(7, teacherId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        String query = "DELETE FROM questions where Id = ?";
        try (Connection con = new SQLServerConnection().getConnection();
                PreparedStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }
    public List<Question> proceducePaging(int page, int quantyQuestionInAPage) throws Exception {
        
        String query = "pagingManageQuiz ?, ?";
        try (Connection con = new SQLServerConnection().getConnection();
                CallableStatement ps = (con != null) ? con.prepareCall(query) : null) {
            ps.setInt(1, page);
            ps.setInt(2, quantyQuestionInAPage);
            ResultSet rs = (ps != null) ? ps.executeQuery() : null;
            List<Question> list = new ArrayList<>();
            while (rs != null && rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setCreatedDate(rs.getDate("created_date"));
                list.add(q);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

}
