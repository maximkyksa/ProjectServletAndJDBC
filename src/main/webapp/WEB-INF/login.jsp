<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 15.04.2022
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=utf-8"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Guru Login Form</title>
</head>
<body>

<form action="/login" method="post">
    <table style="with: 50%">

        <tr>
            <td>UserName</td>
            <td><input type="text" name="login" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <p style="color:${color};">${message}</p>
    <input type="submit" value="login" /></form>



<form action="/register" method="get">
    <input type="submit" value="Registr" /></form>
</body>
</html>

</body>
</html>
