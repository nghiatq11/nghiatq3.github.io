/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GalleryDao;
import dao.ImgDao;
import entity.Gallery;
import entity.Image;
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
@WebServlet(name = "detail", urlPatterns = {"/detail"})
public class detail extends HttpServlet {

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
            try {

                String idGallery_raw = request.getParameter("idGallery");
                request.setAttribute("menuPageGallery", idGallery_raw);

                int quantityOnPage = 4;
                String txtPage = request.getParameter("page");
                if (txtPage == null) { //defaut is pafe one
                    txtPage = "1";
                }
                try {
                    List<Gallery> top3Gallery = new GalleryDao().top3();
                    request.setAttribute("top3Gallery", top3Gallery);
                    int idGallery = Integer.parseInt(idGallery_raw);
                    int page = Integer.parseInt(txtPage);
                    Gallery gallery = new GalleryDao().getOne(idGallery);
                    //get list images by idGallery in a page
                    List<Image> images = new ImgDao().proceducepagingImg(page, quantityOnPage, idGallery);
                    if(images.size()==0){
                        request.setAttribute("message", "can't found any Gallery in this page");
                    }
                    //count total number page
                    int countPage = (new GalleryDao().count() % quantityOnPage > 0)
                            ? (new GalleryDao().count() / quantityOnPage + 1)
                            : new GalleryDao().count() / quantityOnPage;
                    request.setAttribute("countPage", countPage);
                    request.setAttribute("page", page);
                    request.setAttribute("images", images);
                    request.setAttribute("gallery", gallery);
                } catch (Exception e) {
                    request.setAttribute("message", "can't found any Gallery");
                }
                request.getRequestDispatcher("detail.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("error.jsp");
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
