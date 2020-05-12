/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebFilter(filterName = "filter", urlPatterns = {"/*"})
public class filter implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String reqURI = req.getRequestURI();
        if(reqURI.endsWith(".jsp")&&!reqURI.endsWith("error.jsp")){
            res.sendRedirect("home");
        }else{
            chain.doFilter(request, response);
        }
        
    }

    public void destroy() {        
    }

}
