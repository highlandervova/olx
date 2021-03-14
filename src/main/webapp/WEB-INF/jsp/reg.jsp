<%@ page import="data.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <br/>
    <h2>CREATE AN ACCOUNT</h2>
<br/>
</head> <body>
<%--    <form action='/olx_war/reg' method='POST'>--%>
    <form  method='POST'>
    Enter Login: <input type='text'     name='login'>
    Enter Pass:  &nbsp <input type='password' name='pass1'>
    Enter again: <input type='password' name='pass2'>
    <br/> <br/>
    Enter City: &nbsp  <input type='city'  name='city'>
    Enter Phone: <input type='phone' name='phone'>
    Enter Email: <input type='email' name= 'email'>
    <br/> <br/>

    <input type='submit' value='Register'>
    </form>

    <br/>
    <br/>

    <form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
    </form>

</body>
</html>