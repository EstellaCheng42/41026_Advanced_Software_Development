<%-- 
    Document   : addSecurityRequest
    Created on : 2021-10-15, 20:49:38
    Author     : chengming
--%>

<%@page import="opal.entity.SecurityRequest"%>
<%@page import="opal.entity.OpalCard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/general_layout.css">
        <link rel="stylesheet" href="css/general_form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>add security request Page</title>
    </head>
    <body>
        <img  src="images/image1.png" alt="" width="330" height="80">
        <div class="login_area">
            <div class="container-md bg-white p-4" style="margin-top: 30px">
                <h2 class="text-info mb-2">Apply for block card</h2>
                <form action="addRequestServlet" method="post" style="margin-top: 50px">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="cardno" placeholder="Which card do you want to block" aria-label="blockcard" aria-describedby="button-addon2">
                        <button class="btn btn-outline-secondary" type="Submit" id="button-addon2">Apply</button>
                    </div>
                </form>
            </div>
    </body>
</html>
