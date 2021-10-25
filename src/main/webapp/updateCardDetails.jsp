<%-- 
    Document   : updateCardDetails
    Created on : 2021-9-30, 1:21:07
    Author     : chengming
--%>

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
        <title>update card</title>
    </head>
    <body >
        <%
            OpalCard opalcard = (OpalCard) request.getAttribute("opalcard");
            String cardId=(String) request.getAttribute("cardID");
        %>
        <img  src="images/image1.png" alt="" width="330" height="80">
        <div class="login_area">
            <div class="container-md bg-white p-4" style="margin-top: 30px">
                <h2 class="text-info mb-2">Update Card</h2>
                <form action="updateCardServlet" method="post">

                    <input name="cardId" value="${opalcard.getCardId()}" type="hidden">

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Opal card number</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="cardno" value="${opalcard.getCardNo()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Security code</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="code" value="${opalcard.getsecurityCode()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nickname</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nickname" value="${opalcard.getnickname()}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Card type</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="type" value="${opalcard.getcardType()}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
    </body>
</html>
