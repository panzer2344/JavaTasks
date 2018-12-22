<%--
  Created by IntelliJ IDEA.
  User: lexat
  Date: 12/18/2018
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1 align="center"> Welcome,

    <%
        Cookie[] cookies = request.getCookies();
        Boolean haveCookie = false;
        String login = null;

        if(cookies != null) {
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("login")){
                    login = cookie.getValue();
                    haveCookie = true;
                    break;
                }
            }
        }

        Object loginS = request.getSession(false).getAttribute("login");

        if(haveCookie){
            out.print(login);
        }
        else if (loginS != null){
            out.print((String)loginS);
        } else{
            out.print(request.getAttribute("login"));
        }

    %>


</h1>

<br><p align="center"><a href="/logout">Log out</a></p><br>

<br><p align="center"><a href="/static/login.html">get back to Login</a></p><br>

</body>
</html>
