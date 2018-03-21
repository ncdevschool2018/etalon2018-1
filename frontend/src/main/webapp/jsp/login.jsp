<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 15.03.2018
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>

<script src="resources/js/custom/login.js"></script>
<body>

<div class="container">
    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Welcome to login page"/>
    </jsp:include>

    <div class="row">
        <div class="col">
        </div>
        <div class="col login-border">
            <div class="form-group">
                <label for="inputUsername">Username</label>
                <input name="username" class="form-control jsUsername" id="inputUsername" placeholder="Username">
                <div class="alert alert-danger jsUsernameIncorrectNotification" role="alert" style="display: none"> <%--todo create class for disabling blocks--%>
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control jsLoginPassword" id="exampleInputPassword1"
                       placeholder="Password">
                <div class="alert alert-danger jsPasswordIncorrectNotification" role="alert" style="display: none">
                </div>
            </div>

            <button type="submit" class="btn btn-primary jsSubmitLogin">Submit</button>
            <br>
            <div class="alert alert-danger jsCredentialsIncorrectNotification" role="alert" style="display: none">
                Username or Password is incorrect!
            </div>
        </div>
        <div class="col"></div>
    </div>
    <br>
    <div>
        <h3>Printing data using model and view</h3>
        <div class="jsDataUsingModelAndView">
            <c:if test="${not empty users}">
                <c:forEach items="${users}" var="users">
                    ${users.id} | ${users.name} <br>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div>
        <h3>Printing data using js & ajax</h3>
        <div class="jsDataUsingAjax">
        </div>
    </div>

    <br>
    <br>
    Sending Data on server:
    <div class="form-inline">
        <label class="sr-only" for="inlineFormInputId">Id</label>
        <input type="text" class="form-control mb-2 mr-sm-2 jsInputId" id="inlineFormInputId" placeholder="001">
        <label class="sr-only" for="inlineFormInputName">Name</label>
        <input type="text" class="form-control mb-2 mr-sm-2 jsInputName" id="inlineFormInputName" placeholder="Tom">

        <button  class="btn btn-primary mb-2 jsSendData">Send data</button>
    </div>

    <br>
    <div class="jsAddedUser">
    </div>
</div>
</body>
</html>
