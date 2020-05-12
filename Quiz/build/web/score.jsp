<%-- 
    Document   : score
    Created on : Mar 27, 2020, 12:11:20 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="center padding-bottom space-Top">
                <div class="text-content well-come">
                    <p>Your score : <p>
                        <%--<c:if test="${requestScope.point<5}">Not Pass</c:if><c:if test="${requestScope.point>=5}">Pass</c:if>--%>
                    <pre>${requestScope.point} (${requestScope.point*10}%) - ${requestScope.status} <pre></div>
            <div class="text-content">
                Take another test 
                <a href="prepareQuiz">
                    <input type="button" value="Start"/>
                </a>
            </div>
            </div>
        </div>
    </body>
</html>
