<%-- 
    Document   : Right
    Created on : Feb 17, 2020, 1:59:50 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Right</title>
            <link href="css/right.css" rel="stylesheet" type="text/css" />
            <link href="css/common.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div class="right">
                <div class="newst">
                    <div class="titleNews">
                        <span>Digital News</span>
                    </div>
                    <div class="contentNews">
                        ${sessionScope.shortDescription}
                    </div>
                </div>
                <div class="newst">
                    <div class="titleNews">Search</div>
                    <form action="search" method="post">
                        <input class="searchBox" type="text" name="txtSearch" size="15"  required = true>
                        <input class="searchButton" type="submit" name="btnGo" value="Go">
                    </form>                        
                </div>
                <div class="newst">
                    <div class="titleNews">
                        <span>Last Articles</span><br>
                    </div>
                    <c:forEach items="${requestScope.recent}" var = "newRecent" >
                    <div class="lastArticles">
                        <a href="detail_news?idNews=${newRecent.id}" >${newRecent.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>    
    </body>
</html>
