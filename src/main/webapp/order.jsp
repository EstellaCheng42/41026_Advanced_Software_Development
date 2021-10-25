<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="opal.entity.User"%>
<%@page import="opal.dao.CardDao"%>
<%@page import="opal.entity.Card"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="opal.entity.Orders"%>
<html>
    <head>
        <title>bills</title>
        <script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        <style>
            body,form{margin: 0}


            .root{

                height: 100%;
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


            .pop,.pop-pay{
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
                padding:10px;
                width: 300px;
            }

        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("loginUser");
            List<Orders> orders = (List<Orders>) request.getAttribute("ordersList");
        %>
        <div class="root">
            <div class="header">
                <h3 class="h-title">Bills History</h3>
                <form action="orders" id="h-form"  class="form-inline">
                    <input name="method" type="hidden" value="search">
                    <div class="form-group">
                        <input class="form-control mb-2 mr-sm-2" type="text" name="orderId" placeholder="enter order number">
                    </div>
                    <button type="submit" class="btn btn-success mb-2 mr-sm-2" id="h-button">search</button><a class="editBtn btn btn-warning btn-sm" href="card?method=list">View Card List</a>
                </form>
            </div>

            <div class="cont">
                <div class="list">
                    <table  class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>OpalCardNum</th>
                                <th>CreditCardNum</th>
                                <th>Top-up Amount</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Orders order : orders) {%>
                            <tr>
                                <td><%=order.getId()%></td>
                                <td><%=order.getOpalCardId()%></td>
                                <td><%=order.getCreditCardId()%></td>
                                <td><%=order.getAmount()%></td>
                                <td>
                                    <a class="editBtn btn btn-warning btn-sm" href="orderDelete?orderId=<%=order.getId()%>">Delete</a>
                                </td>
                            </tr><%}%>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        

        <div class="pop">
            <div class="pop-wrap">
                <form action="orders" method="post" id="pop-form">
                    <input type="hidden" name="method" value="update">
                    <input type="hidden" name="id">

                    <div class="form-group">
                        <label for="orderNum">Order number</label>
                        <input type="text" class="form-control" name = "orderNum" id="orderNum" readonly>
                    </div>
                    <div class="form-group">
                        <label for="cardNum">Card number</label>
                        <input type="text" class="form-control" name = "cardNum" id="cardNum" readonly>
                    </div>
                    <div class="form-group">
                        <label for="balance">Card balance</label>
                        <input type="text" class="form-control" name = "balance" id="balance" readonly>
                    </div>
                    <div class="form-group">
                        <label for="count">Top-up Amount</label>
                        <input type="number" class="form-control" name = "count" id="count">
                    </div>

                    <div class="btn">
                        <button type="button" class="btn btn-primary btn-sm" id="sure">sure</button>
                        <button type="button" class="btn btn-secondary btn-sm" id="cancel">cancel</button>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            $("#h-button").click(function () {
                $('#h-form')[0].submit()
            })

            $('#sure').click(function () {
                var data = $('#pop-form').serialize();
                console.log(data)
                $.post('orders?' + data, function (res) {
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

            $('#pop-form input[name="count"]').blur(function () {
                var ipt = $(this);
                var count = ipt.val();

                if (count == '' || count < 0) {
                    count = 0;
                    ipt.val(count)
                }


                console.log(count, ipt.attr('max'))

                var balance = $('#pop-form input[name="balance"]').val()
                $('#pop-form input[name="count"]').val(balance + count)
            })

            $('#payMethod').change(function () {
                var data = $(this).val();
                if (data == 'credit card') {
                    $('.card').css('display', '')
                    $('#pay-form input[name="cardNum"]').attr('required', 'required')
                } else {
                    $('.card').css('display', 'none')
                    $('#pay-form input[name="cardNum"]').removeAttr('required')
                }
                console.log(data)
            });

            $('#p-sure').click(function () {
                var card = $('#pay-form input[name="cardNum"]')
                if (card.attr('required') && card.val() == '') {
                    alert("Please enter credit card number")
                    return
                }

                var data = $('#pay-form').serialize();
                console.log(data)
                $.post('payment?' + data, function (res) {
                    if (res == 'success') {
                        reloadTab()
                        $('.pop-pay').css('display', 'none')
                    } else {
                        alert(res)
                    }
                })
            })

            $('#p-cancel').click(function () {
                $('.pop-pay').css('display', 'none')
            })

            function edit(btn, id) {
                var tds = $(btn).parent().siblings('td')
                var orderNum = tds.eq(1).attr('data-val')
                var cardNum = tds.eq(2).attr('data-val')
                var balance = tds.eq(3).attr('data-val')
                var count = tds.eq(4).attr('data-val')

                $('#pop-form input[name="id"]').val(id)
                $('#pop-form input[name="orderNum"]').val(orderNum)
                $('#pop-form input[name="cardNum"]').val(cardNum)
                $('#pop-form input[name="balance"]').val(balance)
                $('#pop-form input[name="count"]').val(count)

                $('.pop').css('display', 'flex')
            }

            function del(id) {
                var r = confirm("Are you sure to delete?");
                if (r == true) {
                    $.post('orders', {method: 'delete', id: id}, function (res) {
                        if (res == 'success') {
                            reloadTab()
                        }
                    })
                }
            }

            function pay(btn, id) {
                var r = confirm("Are you sure to submit?");
                if (r == true) {
                    $.post('orders', {method: 'submit', id: id, status: 1}, function (res) {
                        if (res == 'success') {
                            reloadTab()
                        }
                    })
                }
            }

            function reloadTab() {
                $('#h-form')[0].submit()
            }


        </script>
    </body>
</html>
