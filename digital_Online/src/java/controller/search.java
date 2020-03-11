/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDao;
import entity.News;
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
@WebServlet(name = "seach", urlPatterns = {"/search"})
public class search extends HttpServlet {

    private String txtSearch = "";

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
        int quantityOnPage = 2;
        try (PrintWriter out = response.getWriter()) {
            List<News> recent = new NewsDao().getTopFiveMostRecentNews();
            request.setAttribute("recent", recent);
            String txtPage = request.getParameter("page");
            if (txtPage == null) {
                txtPage = "1";
            }
            if (request.getParameter("txtSearch") != null) { //laays ra text search khi chuyển trang    
                txtSearch = request.getParameter("txtSearch");
            }
            try {
                int page = Integer.parseInt(txtPage);
                List<News> newsSearch = new NewsDao().proceduceSearchNews(page, quantityOnPage, txtSearch);

                if (newsSearch.isEmpty()) {
                    newsSearch = null;
                    request.setAttribute("message", "We can't found any news ");
                }
                int countSearch = (new NewsDao().count(txtSearch) % quantityOnPage > 0)
                        ? (new NewsDao().count(txtSearch) / quantityOnPage + 1)
                        : new NewsDao().count(txtSearch) / quantityOnPage;
                request.setAttribute("countSearch", countSearch);
                request.setAttribute("page", page);
                request.setAttribute("newsSearch", newsSearch);
            } catch (Exception e) {
                request.setAttribute("message", "We can't found page : " + txtPage);
            }
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
