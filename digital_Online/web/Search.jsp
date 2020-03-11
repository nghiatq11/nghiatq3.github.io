<%-- 
    Document   : search
    Created on : Feb 19, 2020, 2:23:39 PM
    Author     : quang
--%>

<%@page import="utils.Helper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <c:choose>
                    <c:when test="${requestScope.newsSearch!= null}">
                        <div class="post">
                            <c:forEach items="${requestScope.newsSearch}" var = "news">
                                <div class="describe">
                                    <div class="titleNews"><a href="detail_news?idNews=${news.id}">${news.title}</a></div>
                                    <div class="img"><img src=${news.image}></div>
                                    <div class="text">${news.shortDescription}</div>

                                </div>
                            </c:forEach>
                            <div class="page">
                                <%
                                    Integer pageIndex = (Integer) request.getAttribute("page");
                                    Integer countSearch = (Integer) request.getAttribute("countSearch");
                                %>
                                <%= Helper.pager(pageIndex, countSearch, 2, "search?page=")%>

                            </div>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="post">
                            <h1>${requestScope.message}</h1>
                            <br />
                        </div>
                    </c:otherwise>
                </c:choose>


                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/> 
        </div>
    </body>
</html>
