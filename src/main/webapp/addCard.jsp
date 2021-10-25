<%-- 
    Document   : addCard
    Created on : 2021-9-30, 1:20:36
    Author     : chengming
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="opal.entity.OpalCard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/general_layout.css">
        <link rel="stylesheet" href="css/general_form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>add card</title>
    </head>
    <body>
         
        <div class="login_area">
                <div class="container-md bg-white p-4" style="margin-top: 150px">
                    <h2 class="text-info mb-2">Link card</h2>
                    <form action="addCardServlet" method="post">
                        
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Opal card number</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="cardno">
                            </div>
                        </div>
                       
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Security code</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="code">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Nickname</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="nickname">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Card type</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="type">
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">Link card</button>
                            </div>
                        </div>
                        
                    </form>
                </div>
    </body>
</html>
