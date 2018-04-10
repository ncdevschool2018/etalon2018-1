<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 06.10.2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>
<body>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<h1> Home page for Admin</h1>

<sec:authentication var="user" property="principal"/>
You are logged as ${user.username}
<br>

<a href="/logout">Log out</a>
</body>
</html>
