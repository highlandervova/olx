<%@ page import="data.Ad" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<form method='post'>
    <input name="name" type="text" required placeholder="Name">
    <input name="descr" type="text" required placeholder="Description">
    <input name="pic" type="text" required placeholder="Picture">
    <input name="price" type="number" required placeholder="Price">
    <input name="city" type="text" required placeholder="City">
    <input name="phone" type="text" required placeholder="Phone">
    <input name="email" type="text" required placeholder="Email">
    <input name="rubric" type="number" required placeholder="Rubric">
    <input type='submit' value='Add New Ad'/>
</form>

</body>
</html>