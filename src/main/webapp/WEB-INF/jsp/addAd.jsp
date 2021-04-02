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
<%--    <input name="pic" type="text" required placeholder="Picture">--%>
    <input name="price" type="number" required placeholder="Price"/>

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
    <input name="phone" type="text" required = false placeholder="Phone" value="${phoneUser}"/>
    <input name="email" type="text" required = false placeholder="Email" value="${emailUser}"/>
    Enter rubric:
    <select name="rubric">
        <c:forEach items="${rubric}" var="rubrics">
            <option value=${rubrics.id}> ${rubrics.name} </option>
        </c:forEach>
    </select>
    <br/>
   <br/>
    <c:out value="${status}"/>

    <br/> <br/>
    <input type='submit' value='Add New Ad'/>
</form>

<form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
</form>


</body>
</html>