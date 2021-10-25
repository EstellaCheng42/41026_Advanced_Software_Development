<%-- 
    Document   : securityRequestList
    Created on : 2021-10-15, 20:18:44
    Author     : chengming
--%>

<%@page import="opal.entity.SecurityRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/general_layout.css">
        <link rel="stylesheet" href="css/general_form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Security Request List Page</title>
    </head>
    <body>
        <%
            ArrayList<SecurityRequest> requestList = (ArrayList<SecurityRequest>) request.getAttribute("requestList");
        %>
        <img  src="images/image1.png" alt="" width="330" height="80">
        <div class="container-md bg-white p-4" style="margin-top: 40px">
            <h2 class="text-info mb-2">Security Requests</h2>
            <div align="center">
                <p class="text-muted">
                    Apply for block card <a href="addSecurityRequest.jsp" class="text-reset">click here</a>.
                </p>
            </div>
            <table class="table table-hover">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Opal card number</th>
                    <th scope="col">Date</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                </tr>
                <% for (SecurityRequest r:requestList) {%>
                <tr>
                    <td><%= r.getRequestId()%></td>
                    <td><%= r.getCardNo()%></td>
                    <td><%= r.getDatetime()%></td>
                    <td><%= r.getStatus()%></td>
                    <td><a href="requestDetailServlet?requestId=<%= r.getRequestId()%>" class="btn btn-sm btn-secondary">View</a></td>
                </tr>
                <%}%>
            </table>
            <a href="main.jsp" class="btn btn-lg btn-secondary px-4">Back</a>
        </div>
    </body>
</html>
