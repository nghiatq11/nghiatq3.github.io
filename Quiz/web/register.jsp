<%-- 
    Document   : register
    Created on : Mar 25, 2020, 10:29:28 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="top"></div>
            <div class="menu center">
                <div class="link">
                    <a href="home.jsp">Home</a>
                    <a href="takeQuiz">Take Quiz</a>
                    <a href="makeQuiz">Make Quiz</a>
                    <a href="manageQuiz">Manage Quiz</a>
                </div>
            </div>
            <div class="center space-Top padding-bottom text-content">
                <div class="title">
                    Registration Form
                </div>
                <form action="register" method="post">
                    <table>
                        <tr>
                            <td class="text-content">User Name: </td>
                            <td>
                                <input class="userName" type="text" name="username" value="${username}" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-content">Password: </td>
                            <td>
                                <input class="passWorld" type="password" name="password" value="${password}" required=""/>
                            </td>
                        </tr>

                        <tr>
                            <td>User Type: </td>
                            <td>
                                <select name="type">
                                    <c:forEach items="${types}" var="i">
                                    <option ${(i.id == t)?"selected=\"selected\"":"" }value="${i.id}"> ${i.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        <tr>
                            <td>Email:  </td>
                            <td>
                                <input class="gmail" type="text" name="email" value="${email}"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input onclick="checkEmptyRegister()" id="singin" type="submit" value="Register"/>
                            </td>
                        </tr>
                        
                    </table>
                </form>
                <c:if test="${requestScope.message!=null}">
                    <div class="incorrect">${requestScope.message}</div>
                </c:if>
            </div>

        </div>
                            <script src="js/login.js" type="text/javascript"></script>
    </body>
</html>
