<%-- 
    Document   : Error
    Created on : Feb 21, 2020, 12:36:58 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="post">
                    
                    <div class="img"></div>
                    <div class="text">
                        <c:choose>
                            <c:when test="${requestScope.message!= null}">
                                <h1>${requestScope.message}</h1>
                                <br />
                            </c:when>    
                            <c:otherwise>
                                <h1>Error ! Can't found this page...</h1>
                                <br />
                            </c:otherwise>
                        </c:choose>
                        
                    </div>

                </div>
            </div>
            <jsp:include page="Footer.jsp"/> 
        </div>
    </body>
</html>
