<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ page language="java" contentType="text/html"@%>--%>
<html lang="en">
<head>
    <title>CreateROOM</title>
    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <spring:url value="../css/welcome.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />

    <c:url value="../css/welcome.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>CreateRoom</h1>
        <h2>Message: This is the CreateRoom pages, called from ${name} </h2>
    </div>
    <form action="/room/createUser" method="POST">
        <input type="text" id="user_name" value="User Name"></form>
    <input type="submit" value="CreateUser">
    </form>;
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>