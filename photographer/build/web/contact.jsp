<%-- 
    Document   : contact
    Created on : Mar 13, 2020, 9:19:58 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="body-content">
            <div class="content center">
                <div class="left">
                    <div class="content-left">
                        <div class="main contact">
                            <div class="txtContact font">
                                Contact
                            </div>
                            <div class="txtContact txtPhotographer font">
                                PHOTOGRAPHER
                            </div>
                            <div class="text">Address:<div class="text txtInfo" >${requestScope.contact.address}</div></div>
                            <div class="text">City: <div class="text txtInfo" >${requestScope.contact.city}</div></div>
                            <div class="text">Country: <div class="text txtInfo" >${requestScope.contact.country}</div></div>
                            <br/>
                            <div class="text">Tel:<div class="text txtInfo" >${requestScope.contact.tel}</div> </div>
                            <div class="text">Email: <div class="text txtInfo" >${requestScope.contact.email}</div></div>
                            <div class="map"></div>
                        </div>


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
