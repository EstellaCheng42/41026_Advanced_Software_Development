<%@page import="com.mycompany.iotbay.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
           User user  = new User();
           user.setEmail(request.getParameter("email")); 
           user.setPassword(request.getParameter("password")); 
           user.setAddress(request.getParameter("address")); 
           user.setCity(request.getParameter("city")); 
           user.setState(request.getParameter("state")); 
           user.setPostcode(request.getParameter("postcode")); 
           session.setAttribute("currentUser", user);
           response.sendRedirect("main.jsp");
        %>
        
    </body>
</html>
