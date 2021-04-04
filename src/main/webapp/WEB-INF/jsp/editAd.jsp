<%@ page import="data.Ad" %>
<%@ page import="data.User" %>
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
<%--        <input name="pic" type="text" required placeholder="Picture" value="${ad.pic}"/><br/>--%>

        <input name="price" type="number" required placeholder="Price" value="${ad.price}"/><br/>
        Enter rubric:
        <select name="rubric">
            <c:forEach items="${rubrics}" var="rubricAds">
                <c:choose>
                    <c:when test="${rubricAds.id==rubricAd}" >
                        <option value=${rubricAds.id}> ${rubricAds.name} </option>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:forEach items="${otherRubrics}" var="rubrics">
                <option value=${rubrics.id}> ${rubrics.name} </option>
            </c:forEach>
        </select>
        <br/>

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
      <br/>
        <div>

                <a href="${pathUpload}?id=${ad.id}">UPLOAD FILE</a>

        </div>
        <br/>
<%--        <input type='submit' class='buttonEnabled' name='uploadfile' value='UPLOAD' />--%>


        <input type="hidden" name="edit" value="true"/>
        <input type='submit' value='Edit Ad'/><br/>
    </form>

    <form action="${pathEdit}" method='post'>
        <input type="hidden" value="${ad.id}" name="id"/>
        <input type="hidden" name="delete" value="true"/>
        <input type='submit' value='Delete Ad'/>
    </form>

      <form action="${pathEdit}" method='post' >


        <input type="hidden" value="${ad.id}" name="id"/>

        <input type="hidden" name="setTop" value="true"/>

        <input type='submit' value='Top Ad'/>
    </form>


    <c:choose>
        <c:when test="${FavorYes!='1'}" >
            <form action="${pathEdit}" method='post'>
                <input type="hidden" value="${ad.id}" name="id"/>
<%--                <input type="hidden" value="" name="file"/>--%>
                <input type="hidden" name="setFavor" value="true"/>
                <input type='submit' value='Favorite Ad'/>
            </form>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${FavorYes=='1'}" >
            <form action="${pathEdit}" method='post'>
                <input type="hidden" value="${ad.id}" name="id"/>
<%--                <input type="hidden" value="" name="file"/>--%>
                <input type="hidden" name="delFavor" value="true"/>
                <input type='submit' value='Delete Favorite'/>
            </form>
        </c:when>
    </c:choose>

</c:if>
<c:if test="${!edit}">
    ${ad.name}<br/>
    ${ad.descr}<br/>
<%--    <img src="${ad.pic}" alt="No Picture"/><br/>--%>
    <img src="olx_war/adImage/imageDisplay?adId=${ad.id}" width="120" height="150" alt="No image" />
    ${ad.price}&nbsp;USD<br/>
    ${ad.phone}<br/>
    ${ad.city}<br/>
    ${ad.email}<br/>
</c:if>



<c:if test="${user != null}">
    <c:if test="${messages != null}">
        <div>
            <h1>Messages:</h1>
            <c:forEach items="${messages}" var="m">
                <c:if test="${user.id == m.toUserId}">Income:</c:if>
                 <c:if test="${user.id == m.fromUserId}">Out:</c:if>
                <h3>${m.message}</h3>
            </c:forEach>
            <form action="${pathEdit}" method='post'>
                <input type="hidden" name="id" value="${ad.id}">
<%--                <input type="file" value="" name="file"/>--%>
                <input type="text" name="message"/>
                <input type="submit" value="Send">
            </form>
        </div>
    </c:if>
</c:if>

<form action=${pathMain}  method='GET'>
    <input type='submit' value='To Main Page'>
</form>

</body>
</html>