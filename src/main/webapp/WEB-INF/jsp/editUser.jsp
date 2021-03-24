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
    Enter Login: <input type='text' required value="<%=user.getLogin()%>" required name='login'>
    Enter current password:  &nbsp <input type='password' name='curPass'>
    <br/> <br/>
    Enter new password: <input type='password' name='pass1'>
    Enter new password again: <input type='password' name='pass2'>
    <br/> <br/>
    Enter city:
    <select name="city">
        <c:forEach items="${adCity}" var="city1">
            <c:choose>
                <c:when test="${city1.id==cityUser}" >
                    <option value=${city1.id}> ${city1.name} </option>
                </c:when>
            </c:choose>
        </c:forEach>
        <c:forEach items="${otherCities}" var="city">
            <option value=${city.id}> ${city.name} </option>
        </c:forEach>
    </select>

    Enter Phone: <input type='text' value="<%=user.getPhone()%>" required name='phone'>
    Enter Email: <input type='email' value="<%=user.getEmail()%>" required name= 'email'>
    <br/> <br/>
    <c:out value="${status}"/>
    <br/> <br/>
    <input type='submit' value='Save Changes'>
</form>

<br/>
<br/>


<form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
</form>


</body>
</html>
