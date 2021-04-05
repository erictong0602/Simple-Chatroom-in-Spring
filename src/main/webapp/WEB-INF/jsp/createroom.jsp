<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ page language="java" contentType="text/html"@%>--%>
<html lang="en">
<head>
    <title>CreateRoom</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#roomForm").submit(function(e) {

                e.preventDefault(); // avoid to execute the actual submit of the form.

                var form = {
                    room_name:$("#room_name").val(),
                    room_limitation:$("#room_limitation").val()
                }
                console.log(form);
                console.log(typeof form);

                $.ajax({
                    type: "POST",
                    url: "/room/createRoom",
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
        <h2>Message: This is the CreateRoom pages, called from ${name} </h2>
    </div>
    <form id="roomForm" class="form-group">
        <input class="form-control" name="room_name" type="text" id="room_name" value="Room Name"></form>
        <input class="form-control" name="room_limitation" type="text" id="room_limitation" value="Room Limitation"></form>
        <button type="submit">CreateRoom</button>
    </form>
</div>


</body>

</html>