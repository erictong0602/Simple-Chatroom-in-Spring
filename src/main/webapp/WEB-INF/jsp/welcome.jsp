<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ page language="java" contentType="text/html"@%>--%>
<html lang="en">
<head>
    <title>Main pages</title>
    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--    <spring:url value="../css/welcome.css" var="springCss" />--%>
<%--    <link href="${springCss}" rel="stylesheet" />--%>

<%--    <c:url value="../css/welcome.css" var="jstlCss" />--%>
<%--    <link href="${jstlCss}" rel="stylesheet" />--%>

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
        <h1>BOOTWEBCHAT</h1>
        <h2>Message: This is the main pages/,called from : ${name}</h2>
    </div>
    <form action="/room/createRoom" method="GET">
        <input type="submit" value="CreateRoom">
    </form>
    <form action="/user/addUser" method="GET">
        <input type="submit" value="CreateUser">
    </form>
    <form action="/user/login" method="POST">
        <input type="submit" value="Login">
    </form>
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>