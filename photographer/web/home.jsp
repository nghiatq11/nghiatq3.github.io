<%-- 
    Document   : home
    Created on : Mar 2, 2020, 10:39:24 AM
    Author     : quang
--%>

<%@page import="utils.Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Front Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <jsp:include page="header.jsp"/>
        <div class="body-content">
            <div class="content center">
                <div class="left">
                    <div class="content-left">
                        <div class="content-img">
                            <div class="img"><img src="${requestScope.info.mainPic}"></div>
                            <h5 class="text">${requestScope.info.mainDescription}</h5>
                        </div>
                        <div class="list-gallery">
                            <ul>
                                <c:forEach items="${requestScope.gallerys}" var="gallery">
                                    <li class="gallery">
                                        <div class="img"><img src="${gallery.desPicture}"></div>
                                        <a href="detail?idGallery=${gallery.id}"><h2 class="font">${gallery.entryName}</h2></a>
                                        <p class="text">${gallery.description}</p>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="page">
                            ${Helper.pager(requestScope.page, requestScope.countPage,2,"home?page=")}
                        </div>
                    </div>
                    <div class="about-me">
                        <div class="title font">About me</div>
                        <p class="text">${requestScope.info.aboutMe}</p>
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
