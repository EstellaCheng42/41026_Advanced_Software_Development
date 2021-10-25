<%@page import="opal.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body class="text-center" cz-shortcut-listen="true">
        <%
            User user = (User) session.getAttribute("loginUser");
        %>
        <form class="container-md text-left" method="post" action="updateServlet">
            <h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input value="<%= user.getEmail()%>" type="email" class="form-control" id="email" name="email">
                </div>
                <div class="form-group col-md-6">
                    <label for="password">Password</label>
                    <input value="<%= user.getPassword()%>" type="password" class="form-control" id="password" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="firstname">FirstName</label>
                <input value="<%= user.getFirstName()%>" type="text" class="form-control" id="address" name="firstname">
            </div>
            <div class="form-group">
                <label for="lastname">LastName</label>
                <input value="<%= user.getLastName()%>" type="text" class="form-control" id="address2" name="lastname">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="type">Type</label>
                    <input value="<%= user.getType()%>" type="text" class="form-control" id="city" name="type">
                </div>
            </div>
            <button href="UpdateServlet" class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
            <a href="CancelCustomerServlet" class="btn btn-lg btn-primary btn-block">Delete</a>
            <a href="main.jsp" class="btn btn-lg btn-primary btn-block">Back</a>


        </form>
    </body>
</html>
