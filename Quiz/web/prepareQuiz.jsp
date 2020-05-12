<%-- 
    Document   : prepareQuiz
    Created on : Mar 25, 2020, 9:02:00 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/prepareQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="center padding-bottom space-Top">
                <div class="text-content well-come"><p>Welcome<p> <pre> ${sessionScope.user.username}<pre></div>
                <div class=" text-content">
                    <form action="prepareQuiz" method="post">
                        Enter number of questions: <br>
                        <input type="number" name="numOfQues" min="1" max="${requestScope.maxQuestion}" required=""/></br>
                        <input class="start" type="submit" value="Start" />
                    </form>
                        <div class="texBlue">${requestScope.message}</div>
                </div>
                
            </div>

        </div>
    </body>
</html>
