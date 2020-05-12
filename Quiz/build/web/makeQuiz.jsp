<%-- 
    Document   : makeQuiz
    Created on : Mar 25, 2020, 9:54:39 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/makeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <c:if test="${sessionScope.user.type.id==1}">
                <div class="center text-content padding-bottom space-Top">
                    <form action="makeQuiz" method="post">
                        <table>
                            <tr>
                                <td class="ques">Question: </td>
                                <td><textarea class="ques" type ="text" rows="7" name="question">${requestScope.question}</textarea></td>
                            </tr>
                            <tr>
                                <td class="ques">Option 1: </td>
                                <td><textarea class="ques" type="text" rows="3" name="o1">${requestScope.o1}</textarea></td>
                            </tr>
                            <tr>
                                <td class="ques">Option 2: </td>
                                <td><textarea class="ques" type="text" rows="3" name="o2">${requestScope.o2}</textarea></td>
                            </tr>
                            <tr>
                                <td class="ques">Option 3: </td>
                                <td><textarea class="ques" type="text" rows="3" name="o3">${requestScope.o3}</textarea></td>
                            </tr>
                            <tr>
                                <td class="ques">Option 4:</td>
                                <td><textarea class="ques" type="text" rows="3" name="o4">${requestScope.o4}</textarea></td>
                            </tr>
                            <tr>
                                <td>Answer(s): </td>
                                <td>
                                    <input  class="ans" type="checkbox" name="answer" value="1"/>Option 1
                                    <input class="ans" type="checkbox" name="answer" value="2"/>Option 2
                                    <input  class="ans" type="checkbox" name="answer" value="3"/>Option 3
                                    <input  class="ans" type="checkbox" name="answer" value="4"/>Option 4
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input onclick="checkSelect()" id="btnMakeQuiz" type="submit" value="Save"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <c:if test="${requestScope.message!=null}"><div class="notifiAddQues">${requestScope.message}</div></c:if>

                    </div>
            </c:if>
            <c:if test="${sessionScope.user.type.id!=1}">
                <div class="center space-Top padding-bottom text-content">
                    <div class="texBlue"> You are not authorized to access this page!!</div>
                </div>
            </c:if>
        </div>
            
    </body>
</html>
