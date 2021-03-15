<%@ page import="data.User" %>
<%@ page import="static enums.SessionAttribute.AUTHENTICATED" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <h1>Edit account</h1>
</head>
<body>
<form  method='POST'>
    <%User user = (User) session.getAttribute(AUTHENTICATED.getValue());%>
    Enter Login: <input type='text' required value="<%=user.getLogin()%>" name='login'>
    Enter current password:  &nbsp <input type='password' name='curPass'>
    <br/> <br/>
    Enter new password: <input type='password' name='pass1'>
    Enter new password again: <input type='password' name='pass2'>
    <br/> <br/>
    Enter City: &nbsp  <input type='text' value="<%=user.getCity()%>" name='city'>
    Enter Phone: <input type='text' value="<%=user.getPhone()%>" name='phone'>
    Enter Email: <input type='text' value="<%=user.getEmail()%>" name= 'email'>
    <br/>
    <c:choose>
        <c:when test="${status==-1}">
            <font color="red">Current password is incorrect</font>
        </c:when>
        <c:when test="${status==-2}">
            <font color="red">New password fields doesn't match</font>
        </c:when>
        <c:when test="${status==1}">
            <font color="#008e00">Changes have been saved!</font>
        </c:when>
    </c:choose>
    <br/>
    <input type='submit' value='Save Changes'>
</form>

<br/>
<br/>

<form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
</form>

</body>
</html>
