<%-- 
    Document   : dispay
    Created on : 2021年10月3日, 上午7:21:51
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="opal.entity.Order"%>
<%Order order = (Order)request.getAttribute("orderinfo");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/shopping.css">
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row my-2">
                <div class="col-10">
                    <div class="form-inline">
                        <span class="fontbold">Opal</span>
                        <button type="button" class="btn alink fontwhite mx-4" data-toggle="button">Home</button>
                        <span class="px-lg-5 mx-5">Check Out</span>
                    </div>          
                </div>
                <div class="col-2">
                    <button type="button" class="btn alink fontwhite" data-toggle="button" onclick="toback()">Back</button>
                </div>
            </div>
            <form name="form1" action="paymentServlet" method="post" role="form">
            <div class="form-group my-lg-5">
                <div class="row">
                    <div class="col-4">
                        <div class="form-group"><label>Payment information</label></div>
                        <div class="form-group"><label class="fontbold">Total Amount</label><label class="mx-2"><%=order.getAddvalue()%></label></div>
                        <div class="form-group">
                            <label class="fontbold">Card Number</label>
                            <label class="mx-2"><%=order.getCardnumber()%></label>
                        </div>
                        <div class="form-group">
                            <label class="fontbold">CVV</label>
                            <label class="mx-2"><%=order.getCvv()%></label>
                        </div>
                        <div class="form-group">
                            <label class="fontbold">Owner Name</label>
                            <label class="mx-2"><%=order.getOwnername()%></label>
                        </div>
                    </div>
                    <div class="px-lg-5 mx-lg-5 col-md-6">
                        <div class="form-group"><label class="fontbold">Delivery Address</label><label class="mx-2"><%=order.getDeliveryaddress()%></label></div>
                        <div class="form-group"><label class="fontbold">State</label><label class="mx-2"><%=order.getState()%></label></div>
                        <div class="form-group"><label class="fontbold">Code</label><label class="mx-2"><%=order.getCode()%></label></div>
                        <div class="form-group"><label class="fontbold">Receiver Nike Name</label><label class="mx-2"><%=order.getReceivername()%></label></div>
                    </div>
                </div>
            </div>
        </div>    
        <script type="text/javascript">
            function toback(){
                window.history.back();
            }
        </script>
    </body>
</html>
