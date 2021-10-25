<%-- 
    Document   : requestDetail
    Created on : 2021-10-19, 21:37:31
    Author     : chengming
--%>

<%@page import="opal.entity.SecurityRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/general_layout.css">
        <link rel="stylesheet" href="css/general_form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Security Request Detail</title>
    </head>
    <body>
        <%SecurityRequest securityRequest =(SecurityRequest) request.getAttribute("securityRequest"); %>
        <img  src="images/image1.png" alt="" width="330" height="80">
        <div class="container-md bg-white" style="margin-top: 50px">

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Opal card number</th>
                        <th scope="col">Date</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"><%=securityRequest.getRequestId()%></th>
                        <td><%=securityRequest.getCardNo()%></td>
                        <td><%=securityRequest.getDatetime()%></td>
                        <td><%=securityRequest.getStatus()%></td>
                    </tr> 
                    <tr>
                        <td colspan="2">
                            <a href="deleteRequestServlet?requestId=${securityRequest.requestId}" class="btn btn-sm btn-danger">Delete</a>
                            <a href="updateRequestServlet?requestId=${securityRequest.requestId}" class="btn btn-sm btn-primary">Confirm</a>
                        </td>
                       
                    </tr>
                </tbody>
            </table>
               <a href="requestManageServlet" class="btn btn-lg btn-secondary px-4">Back</a>       
        </div>
    </body>
</html>
