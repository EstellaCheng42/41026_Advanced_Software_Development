<%-- 
    Document   : checkoutorders
    Created on : 2021年10月3日, 上午6:41:05
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
            <div class="form-group my-lg-5">
                <div class="row">
                    <div class="col-4">
                        <div class="form-group"><label class="fontbold">Card Type:</label><label class="mx-1"><%=order.getCardtype()%></label></div>
                        <div class="form-group"><label class="fontbold">First Name</label><label class="mx-2"><%=order.getFirstName()%></label></div>
                        <div class="form-group"><label class="fontbold">Last Name</label><label class="mx-2"><%=order.getLastName()%></label></div>
                        <div class="form-group"><label class="fontbold">Age</label><label class="mx-2"><%=order.getAge()%></label></div>
                        <div class="form-group"><label class="fontbold">Phone</label><label class="mx-2"><%=order.getPhone()%></label></div>
                        <div class="form-group"><label class="fontbold">Card Value</label><label class="mx-2"><%=order.getAddvalue()%></label></div>
                    </div>
                    <div class="px-lg-5 mx-lg-5 col-md-6">
                        <div class="form-group"><label class="fontbold">Delivery Address</label><label class="mx-2"><%=order.getDeliveryaddress()%></label></div>
                        <div class="form-group"><label class="fontbold">State</label><label class="mx-2"><%=order.getState()%></label></div>
                        <div class="form-group"><label class="fontbold">Code</label><label class="mx-2"><%=order.getCode()%></label></div>
                        <div class="form-group"><label class="fontbold">Receiver Nike Name</label><label class="mx-2"><%=order.getReceivername()%></label></div>
                    </div>
                </div>
            </div>
            <div class="form-group nextbox col-md-8">
                <form name="form1" action="getinfoServlet" method="get" role="form">
                <button type="submit" class="btn next_button next_button_bg2 fontwhite" role="button" id="nextbtn">Check Out</button>
                <input type="hidden" id="id" name="id" value="<%=order.getId()%>">
                <input type="hidden" id="op" name="op" value="pay">
                </form>
            </div>
        </div>
        <script type="text/javascript">
            function toback(){
                window.history.back();
            }
        </script>        
    </body>
</html>
