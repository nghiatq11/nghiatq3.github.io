<%-- 
    Document   : detail
    Created on : Mar 2, 2020, 5:05:49 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Front Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>

    </head>
    <body> 
        <jsp:include page="header.jsp"/>
        <div class="body-content">
            <div class="content center">
                <div class="left">
                    <div class="content-left error">
                        <div class="title">Error</div>
                    </div>
                </div>
                <div class="right">
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script src="js/slider.js" type="text/javascript"></script>
    </body>
</html>
