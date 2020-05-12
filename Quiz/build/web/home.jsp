<%-- 
    Document   : header
    Created on : Mar 25, 2020, 8:07:20 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="center space-Top padding-bottom">
                <div class="text-content space-Top well-come"><p>Hi <p> <pre> ${sessionScope.user.username} </pre></div>
            </div>

        </div>
    </body>
</html>
