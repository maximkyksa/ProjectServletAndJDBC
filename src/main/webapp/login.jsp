<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 17.04.2022
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<div class="center">
    <h1>login</h1>
    <form action="/login" method="post">
        <div class="txt_field">
            <input type="text" name="login"/>
            <span></span>
            <label>UserName</label>
        </div>
        <div class="txt_field">
            <input type="password"  name="password" />
            <span></span>
            <label>Password</label>
        </div>
        <input type="submit" value="Login">
    </form>
    <form action="/register" method="get">
        <input type="submit" value="register">
    </form>
</div>

</body>
</html>
