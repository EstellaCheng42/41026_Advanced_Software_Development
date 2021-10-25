<%@page import="opal.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body class="text-center">
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <nav class="nav nav-masthead justify-content-center">
                        <a class="nav-link active" href="profile.jsp">My profile</a>
                        <a class="nav-link active" href="cardManageServlet">Card Management Center</a>
                        <a class="nav-link active" href="requestManageServlet">Security Management Center</a>
                        <a class="nav-link active" href="shopping.jsp">Shopping Center</a>
                        <a class="nav-link active" href="card?method=list">Top Up</a>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">

                <%
                    User user = (User) session.getAttribute("loginUser");
                    if (user != null) {
                %>
                <h1 id="left">Hello, <%= user.getEmail()%> <a href="LogoutServlet" class="btn btn-secondary">Logout</a></h1>
                <%
                    } else {
                        response.sendRedirect("index.html");
                    }
                %>
            </main>
        </div>
    </body>
</html>
