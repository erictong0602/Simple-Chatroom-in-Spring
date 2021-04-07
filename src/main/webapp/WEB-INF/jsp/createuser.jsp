<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ page language="java" contentType="text/html"@%>--%>
<html lang="en">
<head>
    <title>CreateUser</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#userForm").on("submit",function(e) {

                e.preventDefault(); // avoid to execute the actual submit of the form.

                var form = {
                    user_Name: $("#user_name").val(),
                    user_Password: $("#user_password").val()
                }
                console.log(form);

                $.ajax({
                    type: "POST",
                    url: "/user/addUser",
                    contentType: 'application/json',
                    data: JSON.stringify(form), // serializes the form's elements.
                    processData: false,
                    encode: true,
                    success: function(data)
                    {
                        console.log('Submission was successful.');
                        alert(data); // show response from the php script.
                    },
                    error: function (data) {
                        console.log('An error occurred.');
                        console.log(data);
                    },
                });
            });
        });
    </script>
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
        <h2>Message: This is the CreateUser pages, called from ${name} </h2>
    </div>
</div>

<form id="userForm">
    <input name="user_name" type="text" id="user_name" value="User Name">
    <input name="user_password" type="password" id="user_password" valssue="User Password">
    <button type="submit">AddUser</button>
</form>

</body>

</html>