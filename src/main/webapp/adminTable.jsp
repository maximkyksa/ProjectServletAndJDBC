<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Hello Admin</h1>
You login as ${login}
<h1>User Table</h1>
<table border = "1px">
  <tr>
    <th>Id</th>
    <th>Login</th>
    <th>Name</th>
    <th>EMail</th>
  </tr>
  <c:forEach var="user" items="${usersList}">
    <tr>
      <td><c:out value="${user.id}"/></td>
      <td><c:out value="${user.login}"/></td>
      <td><c:out value="${user.name}"/></td>
      <td><c:out value="${user.email}"/></td>
      </tr>
  </c:forEach>
</table>
</body>
</html>