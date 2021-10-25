<%-- 
    Document   : orders
    Created on : 2021年10月3日, 上午1:29:49
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="opal.entity.Order"%>
<%@page import="java.util.List"%>
<%
if(request.getAttribute("msg")!=null){
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
        <script src="js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row my-2">
                <div class="col-10">
                    <div class="form-inline">
                        <span class="fontbold">Opal</span>
                        <button type="button" class="btn alink fontwhite mx-4" data-toggle="button" onclick="tohome()">Home</button>
                        <span class="px-lg-5 mx-5"></span>
                    </div>          
                </div>
                <div class="col-2">
                    <button type="button" class="btn alink fontwhite" data-toggle="button" onclick="tohome()">Back</button>
                </div>
            </div>
            <div class="form-group my-lg-5">
                <h1>Order List</h1>
            </div>
            <% List<Order> list = (List<Order>)request.getAttribute("list");%>
            <table class="table">
                <% for(int i=0;i<list.size();i++){
                    Order order = (Order)list.get(i);
                %>
                <tr>
                    <td><%=order.getId()%></td>
                    <td><%=order.getFirstName()%> <%=order.getLastName()%>(<%=order.getReceivername()%>)</td>
                    <td>
                        <a href="deleteordersServlet?id=<%=order.getId()%>" class="alink fontwhite" style="width:100px;display: inline-block;text-align: center;">Delete</a>
                        <%if(order.getStatus()==0){%>
                        <a href="getinfoServlet?id=<%=order.getId()%>&op=edit" class="alink fontwhite" style="width:100px;display: inline-block;text-align: center;">Edit</a>
                        <a href="getinfoServlet?id=<%=order.getId()%>&op=checkout" class="alink fontwhite" style="width:100px;display: inline-block;text-align: center;">Pay</a>
                        <%}%>
                    </td>
                </tr>    
               <% }%>
            </table>
        </div>
        <script type="text/javascript">
            function tohome(){
                window.location.href="main.jsp";
            }
        </script>   
    </body>
</html>
