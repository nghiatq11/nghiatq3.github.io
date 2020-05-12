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
@WebServlet(name = "manageQuiz", urlPatterns = {"/manageQuiz"})
public class manageQuiz extends HttpServlet {

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
            try {
                String message = null;

                // get the value of page size 
                int pageSize = 3;
                QuestionDao qdao = new QuestionDao();
                String raw_pageIndex = request.getParameter("page");
                if (raw_pageIndex == null) {
                    raw_pageIndex = "1";
                }
                // get the count of questions 
                int count = qdao.totalQuestions();
                request.setAttribute("count", count);
                int pageCount = (count % pageSize == 0) ? count / pageSize : count / pageSize + 1;
                System.out.println(pageCount);
                request.setAttribute("pageCount", pageCount);
                int pageIndex = 0;
                try {
                    // check page index, then send message error
                    pageIndex = Integer.valueOf(raw_pageIndex);
                    System.out.println(pageIndex);
                    if (pageIndex > pageCount || pageIndex <= 0) {
                        message = "The page " + pageIndex + " isn't exist!!";
                    } else {
                        request.setAttribute("pageIndex", pageIndex);
                    }
                } catch (NumberFormatException e) {
                    message = e.getMessage();
                }
                // get list questions
                List<Question> questions = qdao.proceducePaging(pageIndex, pageSize);
                request.setAttribute("questions", questions);

                // get error message 
                request.setAttribute("message", message);
                request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
            } catch (Exception e) {

                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
