<%@ page import="data.Ad" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type='text/css'>

                .br1{border-radius:35% 0 0 0;}
                .br2{border-radius:0 35% 0 0;}

TABLE#maintable { border-collapse: collapse; border-radius:35px;}
TABLE#bottontable TR, TH {border-radius:35px; }
TABLE#maintable  TH  {  padding: 3px;border: 1px solid black;  border-radius:35px; }
TR, TD first-of-type {  border-top-left-radius:35px; border-bottom-left-radius:45px;  }
TH {background: #b0e0e6;}

                #bold1{
                    font-weight: bold;
                }

                #bold2{
                    font-weight: bold;
                }
                #bold3{
                    font-weight: bold;
                }

</style>

    <title>${title}</title>

</head>
<body>
<center>
    <h1>OLX</h1>
</center>

<table id="maintable" width="80%" border="1" align="center">

    <tr>
        <th>NAME</th>
        <th>RUBRIC</th>
        <th>PRICE</th>
        <th>DESCRIPTION</th>
        <th>PICTURE</th>
        <th>CITY</th>
        <th>PHONE</th>
        <th>EMAIL</th>
    </tr>
    <c:forEach items="${ads}" var="ad">
        <tr>
            <td>${ad.name}</td>
            <td>${ad.rubric}</td>
            <td><h2>${ad.price}</h2> <h4>USD</h4></td>
            <td>${ad.descr}</td>
            <td><img style='width: 100px;' src='${ad.pic}' alt='No Picture'/></td>
            <td>
                <a href='main?type=${ad.city}'>

            <c:forEach items="${adCity}" var="city">
                    <c:choose>
                    <c:when test="${ad.city==city.id}">
                    <p>  ${city.name}</p>
                     </c:when>
                    </c:choose>
                </c:forEach>
            </td>
            <td>${ad.phone}</td>
            <td>${ad.email}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<c:if test="${empty sessionScope.authenticated}">
<table width="80%"  align="center">

    <tr>

        <th><form action=${pathAuth} method='GET' >
            <input type='submit' id='bold2'   class='buttonEnabled' value='Authorization'/>
        </form>
        </th>
        <th><form action=${pathReg} method='GET' >
            <input type='submit' id='bold1'   class='buttonEnabled' value='Create new login'/>
        </form>
        </th>
    </tr>
</table>
</c:if>

<c:if test="${not empty sessionScope.authenticated}">
    <form action=${pathAddAd} method='get'>
        <input type='submit' value='Add Ad'>
    </form>
</c:if>
<br/>
<form action=${pathMain} method='GET' >
    <input type='submit' id='bold3'   class='buttonEnabled' value='Reset All Filters'/>
</form>
</body>
</html>