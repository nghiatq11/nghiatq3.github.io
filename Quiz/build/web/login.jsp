<%-- 
    Document   : login
    Created on : Mar 25, 2020, 8:47:51 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="top"></div>
            <div class="menu center">
                <div class="link">
                    <a href="home.jsp">Home</a>
                    <a href="prepareQuiz">Take Quiz</a>
                    <a href="makeQuiz">Make Quiz</a>
                    <a href="manageQuiz">Manage Quiz</a>
                </div>
            </div>
            <div class="center  space-Top padding-bottom">
                <div class="title">
                    Login Form
                </div>
                <div class="">
                    <form action="login" method="post">
                        <table>
                            <tr>
                                <td class="text-content">User Name: </td>
                                <td>
                                    <input class="userName" type="text" name="username" value=${requestScope.username}>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-content"  >Password: </td>
                                <td>
                                    <input class="passWorld" type="password" name="password" value =${requestScope.password}>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input id="singin" type="submit" value="Sign in"/>
                                    <a class="text-content register" href="register">Register</a>
                                    <br><br>
                                    <div class="incorrect">${requestScope.message}</div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <!--<script src="js/login.js" type="text/javascript"></script>-->
    </body>
</html>
