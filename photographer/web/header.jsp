<%-- 
    Document   : home
    Created on : Mar 2, 2020, 10:39:24 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="menu"> 
            <div class="center" >
                <ul class="nav">
                    <li class="e-menu"><a href="home" class="${requestScope.menuPage == "Home" ? 'active':''}">My front page</a></li>
                        <c:forEach items="${requestScope.top3Gallery}" var="gallery">
                        <li class="e-menu"><a href="detail?idGallery=${gallery.id}" class="${requestScope.menuPageGallery == gallery.id ? 'active' : ''}">${gallery.entryName}</a></li>
                        </c:forEach>

                    <li class="e-menu"><a href="contact" class="${requestScope.menuPage == "Contact" ? 'active' : ''}">Contact</a></li>

                </ul>
            </div>
        </div>     
        <div class="logo-title"> 
            <div class="center">
                <a href="myfrontpage.jsp">
                    <div class="logo"></div>
                </a>
                <div class="title">
                    <div>
                        <a class="link-page font" href="home">PHOTOGRAPHER</a>
                    </div>
                    <div class="sub-title font">
                        Welcome to this website
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
