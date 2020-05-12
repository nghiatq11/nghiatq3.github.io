/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quang
 */
@WebFilter(filterName = "jspFilter", urlPatterns = {"/*"})
public class jspFilter implements Filter {
    
    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String reqURI = req.getRequestURI();
        
        User u = (User) session.getAttribute("user");
        if (reqURI.endsWith(".jsp")&& u!=null) {
                if (reqURI.endsWith("register.jsp")) {
                    res.sendRedirect("register");
                } else if (reqURI.endsWith("takeQuiz.jsp")) {
                    res.sendRedirect("prepareQuiz");
                } else if(reqURI.endsWith("manageQuiz.jsp")){
                    res.sendRedirect("manageQuiz");
                }else if(reqURI.endsWith("makeQuiz.jsp")){
                    res.sendRedirect("makeQuizCon");
                }else{
                    res.sendRedirect("home");
                }
            } else {
                chain.doFilter(request, response);
            }
        
    }

    public void destroy() {        
    }

    
}
