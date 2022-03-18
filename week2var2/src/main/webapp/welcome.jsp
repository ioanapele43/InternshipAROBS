<html>
<head>
    <title> Welcome </title>
</head>
<body>
    <h1>Welcome </h1>
    <%
         out.println("Your IP address is " + request.getRemoteAddr());
         %><br><%
         out.println("\n Welcome back "+session.getAttribute("user"));

    %>
</body>
</html>