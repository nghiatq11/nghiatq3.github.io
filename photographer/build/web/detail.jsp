<%-- 
    Document   : detail
    Created on : Mar 2, 2020, 5:05:49 PM
    Author     : quang
--%>

<%@page import="entity.Gallery"%>
<%@page import="utils.Helper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Front Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>

    </head>
    <body> 
        <jsp:include page="header.jsp"/>
        <div class="body-content">
            <div class="content center">
                <div class="left">
                    <c:choose>
                        <c:when test="${requestScope.images.size() != 0 || requestScope.images == null}">
                            <div class="content-left">
                                <div class="title">${requestScope.gallery.entryName}</div>
                                <div class="content-img">
                                    <div class="img_common"><img id="mainImg" src="${requestScope.images.get(0).path}"></div>

                                </div>
                            </div>
                            <div class="list-gallery">
                                <ul class="list-img">
                                    <c:forEach items="${requestScope.images}" var="image" varStatus="loop">
                                        <li class="image" onclick="myClick(${image.id})">
                                            <img id="${image.id}" src="${image.path}" >
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                            <div class="page">
                                ${Helper.pagerGallery(requestScope.page, requestScope.countPage, 2,requestScope.gallery.id)}
                            </div>
                        </c:when>    
                        <c:otherwise>
                            <h1>${requestScope.message}</h1>
                            <br />
                        </c:otherwise>
                    </c:choose>

                </div>
                <div class="right">
                    <jsp:include page="right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script src="js/changeImg.js" type="text/javascript"></script>
    </body>
</html>
