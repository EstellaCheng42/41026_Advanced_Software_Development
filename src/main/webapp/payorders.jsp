<%-- 
    Document   : payorders
    Created on : 2021年10月3日, 上午2:08:14
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
                            <input type="number" id="cardnumber" name="cardnumber" class="form-control" required onchange="tocount('1')">
                        </div>
                        <div class="form-group">
                            <label class="fontbold">CVV</label>
                            <input type="number" id="cvv" name="cvv" class="form-control" required onchange="tocount('2')">
                        </div>
                        <div class="form-group">
                            <label class="fontbold">Owner Name</label>
                            <input type="text" id="ownername" name="ownername" class="form-control" required onchange="tocount('3')">
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
            <div class="form-group nextbox col-md-8">
                <button type="submit" class="btn next_button next_button_bg1 fontwhite" disabled="disabled" role="button" id="nextbtn">Check Out</button>
                <input type="hidden" id="id" name="id" value="<%=order.getId()%>">
                <input type="hidden" id="num" name="num" value="">
            </div>
            </form>
        </div>
        <script type="text/javascript">
            function toback(){
               window.location.href="ordersServlet";
            }
            var sumcount=0;
            function tocount(flag){
                var num=$("#num").val();
                if(flag=="1"){
                    var cardnumber=$("#cardnumber").val();
                    if(cardnumber.length!=0){
                        if(num.indexOf("cardnumber")==-1){
                            $("#num").val(num+"cardnumber,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("cardnumber")!=-1){
                            $("#num").val(num.replaceAll("cardnumber,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="2"){
                    var cvv=$("#cvv").val();
                    if(cvv.length!=0){
                        if(num.indexOf("cvv")==-1){
                            $("#num").val(num+"cvv,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("cvv")!=-1){
                            $("#num").val(num.replaceAll("cvv,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="3"){
                    var ownername=$("#ownername").val();
                    if(ownername.length!=0){
                        if(num.indexOf("ownername")==-1){
                            $("#num").val(num+"ownername,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("ownername")!=-1){
                            $("#num").val(num.replaceAll("ownername,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(sumcount==3){
                    $("#nextbtn").removeClass("next_button_bg1");
                    $("#nextbtn").addClass("next_button_bg2");
                    document.getElementById("nextbtn").removeAttribute("disabled");
                }
            }   
        </script>
    </body>
</html>
