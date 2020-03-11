<%-- 
    Document   : Home
    Created on : Feb 19, 2020, 12:57:32 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css" />
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <c:choose>
                    <c:when test="${requestScope.news!= null}">
                        <div class="post">
                            <div class="titleNews">
                                ${requestScope.news.title}
                            </div>
                            <div class="img"><img src="${requestScope.news.image}" alt=""/></div>

                            <div class="text">
                                ${requestScope.news.fullDescription}
                            </div>
                            <div class="signature">
                                <div class="icon1"></div>
                                <div class="icon2"></div>
                                By ${requestScope.news.writer} | ${requestScope.news.publishedDate}
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
