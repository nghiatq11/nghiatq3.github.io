<%-- 
    Document   : takeQuiz
    Created on : Mar 25, 2020, 9:34:02 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/takeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="center padding-bottom">
                <div class="text-content space-Top well-come"><p>Welcome</p> <pre> ${sessionScope.user.username} </pre>
                    
                </div>
                <div class="timer text-content">Time remaining <span id="time"></span></div>

                <form id="myForm" action="takeQuiz" method="post">
                        <c:forEach items="${requestScope.questions}" var="i" varStatus="loop" >
                            <div id="questiondiv${i.id}" class="text-content question">
                                <br>Question ${loop.count}: ${i.question}<br>
                                <input type="hidden" name="totalTime" value="${requestScope.totalTime}"/>
                                <input type="hidden" name="idQ${loop.count-1}" value="${i.id}"/>
                                <input type="hidden" name="numOfQues" value="${requestScope.questions.size()}" id="numberQuestion"/>
                                <input class="answer" type="checkbox" name="q${loop.count-1}" value="1"/>${i.o1}<br>
                                <input class="answer" type="checkbox" name="q${loop.count-1}" value="2"/>${i.o2}<br>
                                <input class="answer" type="checkbox" name="q${loop.count-1}" value="3"/>${i.o3}<br>
                                <input class="answer" type="checkbox" name="q${loop.count-1}" value="4"/>${i.o4}<br>
                            </div>
                        
                        </c:forEach>
                        <div class="button">
                            
                            <button type="button" id="btnnext" onclick="plusDivs(1)">Next</button>
                            <button id="btnsubmit" type="submit">Submit</button>
                        </div>
                </form>

            </div>
        </div>
            <script src="js/takeQuiz.js" type="text/javascript"></script>
    </body>
</html>
