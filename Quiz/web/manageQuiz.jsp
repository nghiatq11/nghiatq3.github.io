<%-- 
    Document   : manageQuiz
    Created on : Mar 25, 2020, 10:07:46 AM
    Author     : quang
--%>

<%@page import="utils.Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manageQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <c:if test="${sessionScope.user.type.id==1}">
                <div class="center space-Top padding-bottom text-content">
                    <div class="title well-come"><p>Number of questions: <p> <pre class="texBlue"> ${requestScope.count}<pre></div>
                <div class="">
                    <table>
                        <tr>
                            <th class="texBlue">Question</th>
                            <th class="texBlue">Date Created</th>
                        </tr>
                                        <c:forEach items="${questions}" var="i">
                        <tr>
                            <td>${i.question} </td> 
                            <td>${i.createdDate}</td>
                            
                            <td>
                                <form action="deleteQuiz" method="post">
                                    <input type="hidden" name="id" value="${i.id}"/>
                                    <input onclick="CfDelete()" id="deleteQuiz" type="button" value="Delete"/>
                                </form>
                            </td>
                        </tr>
                                        </c:forEach>
                    </table>
                </div>
                <div class="page">
                                    ${Helper.pager(requestScope.pageIndex, requestScope.pageCount, 2, "manageQuiz?page=")} 
                </div>            
                </div>
                            </c:if>
                            <c:if test="${sessionScope.user.type.id!=1}">
                <div class="center space-Top padding-bottom text-content">
                    <div class="texBlue"> You are not authorized to access this page!!</div>
                </div>
                            </c:if>
        </div>
    </body>
    <script src="js/manageQuiz.js" type="text/javascript"></script>
</html>
