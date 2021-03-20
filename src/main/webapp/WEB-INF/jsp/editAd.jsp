<%@ page import="data.Ad" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<c:if test="${edit}">
    <form action="${pathEdit}" method='post'>
        <input type="hidden" value="${ad.id}" name="id"/>
        <input name="name" type="text" required placeholder="Name" value="${ad.name}"/><br/>
        <input name="descr" type="text" required placeholder="Description" value="${ad.descr}"/><br/>
        <input name="pic" type="text" required placeholder="Picture" value="${ad.pic}"/><br/>
        <input name="price" type="number" required placeholder="Price" value="${ad.price}"/><br/>
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
         <br/>
        <input name="phone" type="text" required placeholder="Phone" value="${ad.phone}"/><br/>
        <input name="email" type="text" required placeholder="Email" value="${ad.email}"/><br/>
        <input type="hidden" name="edit" value="true"/>
        <input type='submit' value='Edit Ad'/><br/>
    </form>
    <form action="${pathEdit}" method='post'>
        <input type="hidden" value="${ad.id}" name="id"/>
        <input type="hidden" name="delete" value="true"/>
        <input type='submit' value='Delete Ad'/>
    </form>
</c:if>
<c:if test="${!edit}">
    ${ad.name}<br/>
    ${ad.descr}<br/>
    <img src="${ad.pic}" alt="No Picture"/><br/>
    ${ad.price}&nbsp;USD<br/>
    ${ad.phone}<br/>
    ${ad.city}<br/>
    ${ad.email}<br/>
</c:if>

<form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
</form>

</body>
</html>