<%-- 
    Document   : shopping
    Created on : 2021年10月2日, 下午1:10:53
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getAttribute("msg") != null) {
%>
<script>alert("<%=request.getAttribute("msg")%>");</script>
<%}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/shopping.css">
        <script src="js/jquery-3.5.1.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row my-2">
                <div class="col-10">
                    <div class="form-inline">
                        <span class="fontbold">Opal</span>
                         <a class="btn alink fontwhite mx-4" href="main.jsp">home</a>
                        
                        <span class="px-lg-5 mx-5">Shopping Page Step 1:<br>Please Select your card type.</span>
                    </div>          
                </div>
                <div class="col-2">
                    <div class="form-group">
                        <button type="button" class="btn alink fontwhite" data-toggle="button" onclick="toorderlist()">Order List</button>
                    </div>
                    <div class="form-group my-2">
                        <button type="button" class="btn alink fontwhite" data-toggle="button" onclick="topaymenthistory()">Payment History</button>
                    </div>
                </div>
            </div>
            <div class="form-group my-lg-5 px-lg-5">
                <div class="cardbox">
                    <div class="leftdiv fontwhite">Children Card</div>
                    <div class="rightdiv fontwhite" style="margin-left:15%;">Adult Card</div>
                </div>
            </div>
            <div class="form-group col-md-12">
                <div class="btn-group col-md-12" data-toggle="buttons" id="cardButtons">
                    <input type="radio" name="card_select" id="option1" value="Children" style="margin-left:30%;">
                    <input type="radio" name="card_select" id="option2" value="Adult" style="margin-left:38%;">
                </div>                        
            </div>
            <div class="form-group nextbox col-md-8">
                <a href="#" class="btn next_button next_button_bg1 fontwhite disabled" role="button" id="nextbtn" onclick="tonext()">Next step</a>
            </div>
        </div>
        <script type="text/javascript">
            $("#cardButtons :input").change(function () {
                $("#nextbtn").removeClass("disabled");
                $("#nextbtn").removeClass("next_button_bg1");
                $("#nextbtn").addClass("next_button_bg2");
            });
            function tonext() {
                var value = "";
                var radio = document.getElementsByName("card_select");
                for (var i = 0; i < radio.length; i++) {
                    if (radio[i].checked == true) {
                        value = radio[i].value;
                    }
                }
                window.location.href = "shoptwo.jsp?card=" + value;
            }
            function toorderlist() {
                window.location.href = "ordersServlet";
            }
            function topaymenthistory() {
                window.location.href = "paymenthistoryServlet";
                //<button type="button" class="btn alink fontwhite mx-4" data-toggle="button" href="main.jsp">Home</button>
            }
        </script>
    </body>
</html>
