<%@ page import="data.Ad" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<center>
    <h1>OLX</h1>
</center>

<table width = "80%" border = "1" align = "center">

    <tr><th>NAME</th><th>RUBRIC</th><th>PRICE</th><th>DESCRIPTION</th><th>PICTURE</th><th>CITY</th><th>PHONE</th><th>EMAIL</th></tr>
    <c:forEach items="${ads}" var="ad">
        <tr>
            <td>${ad.getName()}</td>
            <td>${ad.rubric}</td>
            <td><h2>${ad.price}</h2> <h4>USD</h4></td>
            <td>${ad.desc}</td>
            <td><img style='width: 100px;' src='${ad.pic}' alt='No Picture'/></td>
            <td>${ad.city}</td>
            <td>${ad.phone}</td>
            <td>${ad.email}</td>
        </tr>
    </c:forEach>
</table>
<%--<form action='/demo_war_exploded/add' method='GET'>--%>
<%--    <input type='submit' value='Add New Car'/>--%>
<%--</form>--%>
</body>
</html>