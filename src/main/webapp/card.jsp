
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="opal.entity.User"%>
<%@page import="opal.dao.CardDao"%>
<%@page import="opal.entity.Card"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="opal.entity.Orders"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bills and assets management</title>
        <script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        <style>
            body,form{margin: 0}

            .root{
                height: 100%;
                padding: 0 50px;
            }

            .header{
                padding-bottom: 10px;
                margin: 10px 60px;
            }

            .h-title{
                margin-bottom: 20px;
                padding-bottom: 10px;
                border-bottom: 1px solid lightgray;
            }

            .cont{
                margin: 10px;
                padding: 0 50px;
            }

            .pop,.pop-order{
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: rgba(0,0,0,0.2);
                display: none;
                justify-content: center;
                align-items: center;
            }

            .pop-wrap{
                background-color: white;
                padding:20px;
                width: 400px;
            }

        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("loginUser");
            List<Card> cards = (List<Card>) request.getAttribute("cards");
        %>
        <h1>Hello, <%=user.getFirstName()%></h1>
        <div class="root">
            <div class="header">
                <h3 class="h-title">Cards Balance</h3>
                <form action="card?method=search" method="post" id="h-form" class="form-inline">
                    <div class="form-group">
                        <input class="form-control mb-2 mr-sm-2" type="text" name="cardNum" value="${param.cardNum}" placeholder="enter card number">
                    </div>
                    <button type="submit" class="btn btn-success mb-2 mr-sm-2" id="h-button">search</button>
                </form>
            </div>
            <a class="editBtn btn btn-warning btn-sm" href="orders?method=list">View Order History</a>

            <div class="cont">
                <div class="list">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>No</th>
                                <th>CardNumber</th>
                                <th>CardBalance</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <%for (Card card : cards) {%>
                        <tr>
                            <td><%=card.getId()%></td>
                            <td><%=card.getCardNum()%></td>
                            <td><%=card.getBalance()%></td>
                            <td>
                                <a class="editBtn btn btn-warning btn-sm" href="topup?cardId=<%=card.getId()%>">Top Up</a>
                            </td>
                        </tr>
                        <%}%>

                    </table>
                </div>
            </div>

            <div class="pop">
                <div class="pop-wrap">
                    <form action="card?method=update" method="post" id="pop-form" class="">
                        <input type="hidden" name="method" value="update">
                        <input type="hidden" name="id">
                        <div class="form-group">
                            <label for="CARDNUM1">Card Number</label>
                            <input type="text" class="form-control" name = "CARDNUM" id="cardNum1">
                        </div>
                        <div class="form-group">
                            <label for="balance1">Card Balance</label>
                            <input type="number" class="form-control" name = "price" id="balance1">
                        </div>
                        <div class="btn">
                            <button type="button" class="btn btn-primary" id="sure">sure</button>
                            <button type="button" class="btn btn-secondary" id="cancel">cancel</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="pop-order">
                <div class="pop-wrap">
                    <form action="orders" method="post" id="order-form">
                        <input type="hidden" name="method" value="save">
                        <input type="hidden" name="customerId" value="${currentUser.id}">
                        <input type="hidden" name="cardId">

                        <div class="form-group">
                            <label for="CARDNUM2">Card Number</label>
                            <input type="text" class="form-control" name = "CARDNUM" id="cardNum2" readonly>
                        </div>
                        <div class="form-group">
                            <label for="balance2">Unit price</label>
                            <input type="number" class="form-control" name = "BALANCE" id="balance2" readonly>
                        </div>
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input type="number" class="form-control" name = "amount" id="amount">
                        </div>
                        <div class="btn">
                            <button type="button" class="btn btn-primary" id="o-sure">sure</button>
                            <button type="button" class="btn btn-secondary" id="o-cancel">cancel</button>
                        </div>
                    </form>
                </div>
            </div>

            <script type="text/javascript">
                $("#h-button").click(function () {
                    $('#h-form')[0].submit()
                })

                $("#h-button-add").click(function () {
                    $('.pop').css('display', 'flex')
                    $('#pop-form')[0].reset()
                    $('#pop-form input[name="method"]').val('save')
                })

                $('#sure').click(function () {
                    var data = $('#pop-form').serialize();
                    console.log(data)
                    $.post('card?' + data, function (res) {
                        if (res == 'success') {
                            reloadTab()
                            $('.pop').css('display', 'none')
                        } else {
                            alert(res)
                        }
                    })
                })

                $('#cancel').click(function () {
                    $('.pop').css('display', 'none')
                })

                $('#o-sure').click(function () {
                    var count = $('#order-form input[name="count"]').val();

                    var data = $('#order-form').serialize();
                    console.log(data)
                    $.post('cards?' + data, function (res) {
                        if (res == 'success') {
                            reloadTab()
                            $('.pop').css('display', 'none')
                        } else {
                            alert(res)
                        }
                    })
                })

                $('#o-cancel').click(function () {
                    $('.pop-order').css('display', 'none')
                })

                $('#order-form input[name="count"]').blur(function () {
                    var ipt = $(this);
                    var count = ipt.val();

                    if (count == '' || count < 0) {
                        count = 0;
                        ipt.val(count)
                    }

                    console.log(count, ipt.attr('max'))

                    var balance = $('#order-form input[name="balance"]').val()
                    $('#order-form input[name="balance"]').val(balance - count)

                })

                function order(btn, id) {

                    var tds = $(btn).parent().siblings('td')
                    var cardNum = tds.eq(1).attr('data-val')
                    var balance = tds.eq(2).attr('data-val')
                    console.log(id, cardNum, balance)

                    $('.pop-order').css('display', 'flex')
                    $('#order-form')[0].reset()
                    $('#order-form input[name="cardId"]').val(id)
                    $('#order-form input[name="cardNum"]').val(cardNum)
                    $('#order-form input[name="balance"]').val(balance)
                    $('#order-form input[name="change"]').val('max', 10 * balance)
                }

                function reloadTab() {
                    $('#h-form')[0].submit()
                }

            </script>
    </body>
</html>