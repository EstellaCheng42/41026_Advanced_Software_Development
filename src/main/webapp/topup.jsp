<%@page import="opal.entity.User"%>
<%@page import="opal.dao.CardDao"%>
<%@page import="opal.entity.Card"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="opal.entity.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top Up</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <% 
            User user = (User) session.getAttribute("loginUser");
            Card card = (Card )request.getAttribute("card");
        %>
        <form class="container-md text-left" method="post" action="orderCreate">
            <h1 class="h3 mb-3 font-weight-normal">Top Up</h1>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="number">Card Number</label>
                    <input type="number" class="form-control" id="cardNumber" name="creditCardNum">
                </div>
                <div class="form-group col-md-6">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="number">Expire Date</label>
                <input type="number" class="form-control" id="expireDate" name="expireDate">
            </div>
            <div class="form-group">
                <label for="number">CVV</label>
                <input type="number" class="form-control" id="CVV" name="CVV">
            </div>
            <div class="form-group">
                <label for="number">Top-up Amount</label>
                <input type="number" class="form-control" id="amount" name="amount">
                <input type="hidden" value="<%= card.getCardNum() %>" name="opalCardNum" >
                <input type="hidden" value="<%= user.getId() %>" name="customer_id" >
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Top Up</button>
            <a class="editBtn btn btn-warning btn-sm" href="orders?method=list">View Order History</a>
        </form>
    </body>
</html>
