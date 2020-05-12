/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.QuestionDao;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebServlet(name = "makeQuiz", urlPatterns = {"/makeQuiz"})
public class makeQuiz extends HttpServlet {

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
                int count = 0;
                String question = request.getParameter("question");
                String o1 = request.getParameter("o1");
                String o2 = request.getParameter("o2");
                String o3 = request.getParameter("o3");
                String o4 = request.getParameter("o4");
                String answer[] = request.getParameterValues("answer");

                String message = "";
                if (question.equals("") || question == null) {
                    message = "Question is empty!";
                    count++;
                } else if (o1.equals("") || o1 == null) {
                    message = "Option 1 is empty!";
                    count++;
                } else if (o2.equals("") || o2 == null) {
                    message = "Option 2 is empty!";
                    count++;
                } else if (o3.equals("") || o3 == null) {
                    message = "Option 3 is empty!";
                    count++;
                } else if (o4.equals("") || o4 == null) {
                    message = "Option 4 is empty!";
                    count++;
                } else if (answer == null) {
                    message = "Answer is empty!";
                    count++;
                } else if (answer.length == 4) {
                    message = "Do not select all answers!!";
                    count++;
                }
                if (count == 0) {
                    String ans = "";
                    for (String answer1 : answer) { //append String to save answer to database
                        ans += answer1 + ",";
                    }
                    ans = ans.substring(0, ans.length() - 1); //delete "," in last index
                    User u = (User) request.getSession().getAttribute("user");
                    int teacherId = u.getId();

                    if (new QuestionDao().addQuestion(question, o1, o2, o3, o4, ans, teacherId)) {
                        request.setAttribute("message", "Add success");
                    } else {
                        request.setAttribute("message", "Add not success");
                    }
                } else {
//                    request.setAttribute("answer", a);
                    request.setAttribute("message", message);
                    request.setAttribute("question", question);
                    request.setAttribute("o1", o1);
                    request.setAttribute("o2", o2);
                    request.setAttribute("o3", o3);
                    request.setAttribute("o4", o4);

                }
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
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
