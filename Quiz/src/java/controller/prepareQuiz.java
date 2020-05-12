/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.QuestionDao;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebServlet(name = "prepareQuiz", urlPatterns = {"/prepareQuiz"})
public class prepareQuiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int maxQuestion = new QuestionDao().totalQuestions();
            request.setAttribute("maxQuestion", maxQuestion);
            request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String numOfQues_raw = request.getParameter("numOfQues");
            String message = "";
            int maxQues = 0;
            int timeOfQues = 10;
            int timeDelay = 3;
            try {
                int numOfQues = Integer.valueOf(numOfQues_raw);
                maxQues = new QuestionDao().totalQuestions();
                if (numOfQues > maxQues) {
                    message = "number Question can't > " + maxQues;
                } else {
                    long totalTime = System.currentTimeMillis() + (timeOfQues*numOfQues+timeDelay)*1000;
                    request.setAttribute("totalTime", totalTime);
                    List<Question> questions = new QuestionDao().RandomQuestion(numOfQues);
                    request.setAttribute("questions", questions);
                }
            } catch (Exception e) {
                message = "number too large";
            }
            if (message == null || message == "") {
                
                request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
            } else {
                request.setAttribute("maxQuestion", maxQues);
                request.setAttribute("message", message);
                request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
