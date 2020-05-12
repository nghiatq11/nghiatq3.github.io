/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.QuestionDao;
import Dao.ResultDao;
import entity.Question;
import entity.Result;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebServlet(name = "takeQuiz", urlPatterns = {"/takeQuiz"})
public class takeQuiz extends HttpServlet {

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
                String numOfQues_raw = request.getParameter("numOfQues");
                String totalTime_raw = request.getParameter("totalTime");
                long totalTime = Long.valueOf(totalTime_raw);
                int numOfQues = Integer.valueOf(numOfQues_raw);
                int correctAnswer = 0;
                for (int i = 0; i < numOfQues; i++) {
                    String idQ_raw = request.getParameter("idQ" + i); //take ID of Question
                    int idQ = Integer.valueOf(idQ_raw);
                    String anserUser[] = request.getParameterValues("q" + (i)); //answer of user
                    if (anserUser == null) {
                        anserUser = new String[0];
                        break;
                    } else {
                        Question question = new QuestionDao().getOne(idQ); //laays ra question cungf id vs caau cuar user
                        System.out.println(question.getAnswer());
                        String anserAdim[] = question.getAnswer().split(",");
                        //question has 1 correct answer
                        if (anserUser.length == 1 && anserAdim.length == 1 && anserUser[0].equals(anserAdim[0])) {
                            correctAnswer += 1;
                        }
                        //question has 2 correct answer
                        if (anserUser.length == 2 && anserAdim.length == 2 && anserUser[0].equals(anserAdim[0]) && anserUser[1].equals(anserAdim[1])) {
                            correctAnswer += 1;
                        }
                        //question has 3 correct answer
                        if (anserUser.length == 3 && anserAdim.length == 3 && anserUser[0].equals(anserAdim[0])
                                && anserUser[1].equals(anserAdim[1]) && anserUser[2].equals(anserAdim[2])) {
                            correctAnswer += 1;
                        }
                    }
                }
                String status = "";
                double point = 0;
                if (totalTime >= System.currentTimeMillis()) {
                    String pointString = String.format("%.2f", ((double) correctAnswer / numOfQues * 10));
                    point = Double.valueOf(pointString);
                    status = point >= 5 ? "pass" : "not pass";
                } else {
                    status = "reject";
                }
                
                User user = (User) request.getSession().getAttribute("user");
                Result r = new Result();
                r.setUsername(user.getUsername());
                r.setScore((float) point);
                r.setStatus(status);
                ResultDao resultDao = new ResultDao();
                resultDao.add(r);
                request.setAttribute("status", status);
                request.setAttribute("point", point);
                request.getRequestDispatcher("score.jsp").forward(request, response);
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
