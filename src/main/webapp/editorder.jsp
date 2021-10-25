<%-- 
    Document   : editorders
    Created on : 2021年10月3日, 上午2:07:59
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="opal.entity.Order"%>
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
                        <button type="button" class="btn alink fontwhite mx-4" data-toggle="button" onclick="tohome()">Home</button>
                        <span class="px-lg-5 mx-5">Edit Order.</span>
                    </div>          
                </div>
                <div class="col-2">
                    <button type="button" class="btn alink fontwhite" data-toggle="button" onclick="toback()">Back</button>
                </div>
            </div>
            <form name="form1" action="updateordersServlet" method="post" role="form">
            <% Order order = (Order)request.getAttribute("orderinfo");%>
            <div class="form-group my-lg-5">
                <span class="fontbold">Card Type:<%=order.getCardtype()%></span>
            </div>
            <div class="form-group fontbold">
                <div class="row">
                    <div class="col-4">
                        <div class="form-inline">
                            <label for="firstname" class="col-sm-5 control-label">First Name</label>
                            <div class="col-sm-5">
                              <input type="text" class="form-control" id="firstname" name="firstname" class="form-control" required onchange="tocount('1')" value="<%=order.getFirstName()%>">
                            </div>
                        </div>
                        <div class="form-inline my-4">
                            <label for="lastname" class="col-sm-5 control-label">Last Name</label>
                            <div class="col-sm-5">
                              <input type="text" class="form-control" id="lastname" name="lastname" class="form-control" required onchange="tocount('2')" value="<%=order.getLastName()%>">
                            </div>
                        </div>
                        <div class="form-inline my-4">
                            <label for="lastname" class="col-sm-5 control-label">Age</label>
                            <div class="col-sm-5">
                                <input type="number" class="form-control" id="age" name="age" class="form-control" required onchange="tocount('3')" value="<%=order.getAge()%>">
                            </div>
                        </div>
                        <div class="form-inline my-4">
                            <label for="lastname" class="col-sm-5 control-label">Phone</label>
                            <div class="col-sm-5">
                              <input type="tel" class="form-control" id="phone" name="phone" class="form-control" required onchange="tocount('4')" value="<%=order.getPhone()%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <label class="col-12 textcenter">Add Value</label>
                            <div style="display: flex;" id="addvaluediv">
                                <div class="form-group col-2">
                                    <div class="discenter">20</div>
                                    <div class="discenter">
                                        <input type="radio" name="addvalue_select" id="option1" value="20" class="addsel" <%if(order.getAddvalue()==20){%>checked<%}%>>
                                    </div>
                                </div>
                                <div class="form-group col-2">
                                    <div class="discenter">50</div>
                                    <div class="discenter">
                                    <input type="radio" name="addvalue_select" id="option2" value="50" class="addsel" <%if(order.getAddvalue()==50){%>checked<%}%>>
                                    </div>
                                </div>
                                <div class="form-group col-2">
                                    <div class="discenter">100</div>
                                    <div class="discenter">
                                    <input type="radio" name="addvalue_select" id="option3" value="100" class="addsel" <%if(order.getAddvalue()==100){%>checked<%}%>>
                                    </div>
                                </div>
                                <div class="form-group col-5">
                                    <input type="number" name="self_add_value" id="self_add_value" class="form-control" placeholder="Enter value here..." style="height:30px;" <%if(order.getAddvalue()!=20&&order.getAddvalue()!=50&&order.getAddvalue()!=100){%><%=order.getAddvalue()%><%}%>>
                                    <div class="discenter">
                                        <input type="radio" name="addvalue_select" id="option4" value="" class="addsel" <%if(order.getAddvalue()!=20&&order.getAddvalue()!=50&&order.getAddvalue()!=100){%>checked<%}%>>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-12 textcenter">Delivery Address</label>
                            <input type="text" name="deliveryaddress" id="deliveryaddress" class="form-control" required onchange="tocount('5')" value="<%=order.getDeliveryaddress()%>">
                        </div>
                        <div class="row">
                            <div class="form-group col-6">
                                <label class="col-12 textcenter">State</label>
                                <input type="text" name="state" id="state" class="form-control" required onchange="tocount('6')" value="<%=order.getState()%>">
                            </div>
                            <div class="form-group col-6">
                                <label class="col-12 textcenter">Code</label>
                                <input type="text" name="code" id="code" class="form-control" required onchange="tocount('7')" value="<%=order.getCode()%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group" style="margin-top:43%;">
                            <label class="col-12 textcenter">Receiver Nike Name</label>
                            <input type="text" name="receivername" id="receivername" class="form-control" required onchange="tocount('8')" value="<%=order.getReceivername()%>">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group nextbox col-md-8">
                <button type="submit" class="btn next_button next_button_bg2 fontwhite" role="button" id="nextbtn">Update</button>
            </div>
            <input type="hidden" id="num" name="num" value="firstname,lastname,age,phone,addvalue,deliveryaddress,state,code,receivername,">
            <input type="hidden" id="v_addvalue" name="v_addvalue" value="9">
            <input type="hidden" id="id" name="id" value="<%=order.getId()%>">
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
                    var firstname=$("#firstname").val();
                    if(firstname.length!=0){
                        if(num.indexOf("firstname")==-1){
                            $("#num").val(num+"firstname,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("firstname")!=-1){
                            $("#num").val(num.replaceAll("firstname,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="2"){
                    var lastname=$("#lastname").val();
                    if(lastname.length!=0){
                        if(num.indexOf("lastname")==-1){
                            $("#num").val(num+"lastname,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("lastname")!=-1){
                            $("#num").val(num.replaceAll("lastname,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="3"){
                    var age=$("#age").val();
                    if(age.length!=0){
                        if(num.indexOf("age")==-1){
                            $("#num").val(num+"age,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("age")!=-1){
                            $("#num").val(num.replaceAll("age,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="4"){
                    var phone=$("#phone").val();
                    if(phone.length!=0){
                        if(num.indexOf("phone")==-1){
                            var myreg = /^1[0-9]{10}$/;
                            if (!myreg.test(phone)) {
                                alert("Please enter the correct 11 digit mobile phone number");
                            }else{
                                $("#num").val(num+"phone,");
                                sumcount=sumcount+1;
                            }
                        }
                    }else{
                        if(num.indexOf("phone")!=-1){
                            $("#num").val(num.replaceAll("phone,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="5"){
                    var deliveryaddress=$("#deliveryaddress").val();
                    if(deliveryaddress.length!=0){
                        if(num.indexOf("deliveryaddress")==-1){
                            $("#num").val(num+"deliveryaddress,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("deliveryaddress")!=-1){
                            $("#num").val(num.replaceAll("deliveryaddress,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="6"){
                    var state=$("#state").val();
                    if(state.length!=0){
                        if(num.indexOf("state")==-1){
                            $("#num").val(num+"state,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("state")!=-1){
                            $("#num").val(num.replaceAll("state,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="7"){
                    var code=$("#code").val();
                    if(code.length!=0){
                        if(num.indexOf("code")==-1){
                            $("#num").val(num+"code,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("code")!=-1){
                            $("#num").val(num.replaceAll("code,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }
                if(flag=="8"){
                    var receivername=$("#receivername").val();
                    if(receivername.length!=0){
                        if(num.indexOf("receivername")==-1){
                            $("#num").val(num+"receivername,");
                            sumcount=sumcount+1;
                        }
                    }else{
                        if(num.indexOf("receivername")!=-1){
                            $("#num").val(num.replaceAll("receivername,",""));
                            sumcount=sumcount-1;
                        }
                    }
                }

                if(sumcount==9){
                    $("#nextbtn").removeClass("next_button_bg1");
                    $("#nextbtn").addClass("next_button_bg2");
                    document.getElementById("nextbtn").removeAttribute("disabled");
                }
            }
            $("#addvaluediv :input").change(function() {
                var num=$("#num").val();
                if(num.indexOf("addvalue")==-1){
                    $("#num").val(num+"addvalue,");
                    sumcount=sumcount+1;
                }
                var radio=document.getElementsByName("addvalue_select");
                if(radio[3].checked==false){
                    $("#self_add_value").val("");
                    $("#self_add_value").removeAttr("required");
                }else{
                    $("#self_add_value")[0].setAttribute("required","true");
                }
                
                for(var i=0;i<radio.length;i++){
                    if(radio[i].checked==true){
                        $("#v_addvalue").val(radio[i].value);
                    }
                }
                if(sumcount==9){
                    $("#nextbtn").removeClass("next_button_bg1");
                    $("#nextbtn").addClass("next_button_bg2");
                    document.getElementById("nextbtn").removeAttribute("disabled");
                }
            });
            function tohome(){
                window.location.href="main.jsp";
            }
            </script>
    </body>
</html>

