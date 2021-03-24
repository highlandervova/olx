<%@ page import="data.Ad" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
                #bold4{
                    font-weight: bold;
                }
                #bold5{
                    font-weight: bold;
                }
                #bold6{
                    font-weight: bold;
                }

</style>

    <title>${title}</title>

</head>
<body>
<center>
    <h1>OLX</h1>
</center>
<c:if test="${not empty sessionScope.authenticated}">
    <table align="center">
        <tr>
            <td width="150"><b>NAME</b></td>
            <td width="150"><b>RUBRIC</b></td>
            <td width="150"><b>DESCRIPTION</b></td>
            <td width="40"></td>
            <td width="150"><b>CITY</b></td>
            <td width="150"><b>FAVORITE</b></td>
            <tr>
        <td></td>
        <td>
<%--            prepeare for Search UserAd's--%>
<%--            User ad's:--%>
<%--            <form method='GET'>--%>
<%--                <select name='usersearch'>--%>
<%--&lt;%&ndash;                    <option value=${Users.id}> My ad's </option>&ndash;%&gt;--%>
<%--                    <c:forEach items="${UsersAds}" var="usAds">--%>
<%--                        <option value=${usAds.id}> ${usAds.login} </option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--                <input type='submit' class='buttonEnabled' name='SearchUsr' value='Search by usersAds' />--%>
<%--            </form>--%>
        </td>
        <td>
        <form  method='GET' >
            <textarea id="w3review" name="descrsearch" rows="1" cols="19"></textarea>
            <br/>
            <input type='submit' class='buttonEnabled' name='SearchDescrButt' value='Search by descr'/>
        </form>
        </td>
        <td>
        </td>
            <td>
            Enter city:
                <form method='GET'>
                    <select name='citysearch'>
                        <c:forEach items="${adCity}" var="cityS">
                            <option value=${cityS.id}> ${cityS.name} </option>
                        </c:forEach>
                    </select>
                    <input type='submit' class='buttonEnabled'  value='Search by city' />
                </form>
            </td>
        <td>
            <form  method='GET' >
                <input type='submit' class='buttonEnabled' name='favorsearch' value='Only Favorite'/>
            </form>
        </td>
        </tr>
    </table>
</c:if>

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
        <th>DATE</th>
        <th>FAVORITE</th>
    </tr>

    <c:choose>
        <c:when test="${notTop=='0'}">


    <c:forEach items="${topAds}" var="adTop">
        <tr>
            <td>
                <a href="${pathEdit}?adId=${adTop.id}">${adTop.name}</a>
            </td>
            <td>${adTop.rubric}</td>
            <td><h2>${adTop.price}</h2> <h4>USD</h4></td>
            <td>${adTop.descr}</td>
            <td><img style='width: 100px;' src='${adTop.pic}' alt='No Picture'/></td>
            <td>
                <a href='main?type=${adTop.city}'>

                    <c:forEach items="${adCity}" var="city">
                    <c:choose>
                    <c:when test="${adTop.city==city.id}">
                    <p>  ${city.name}</p>
                    </c:when>
                    </c:choose>
                    </c:forEach>
            </td>
            <td>${adTop.phone}</td>
            <td>${adTop.email}</td>
            <td>
                <c:set var="dtAds" value="${adTop.date}"/>
                <%
                    java.util.Date dateAd=(java.util.Date) pageContext.getAttribute("dtAds");
                    String today = new SimpleDateFormat("dd-MM-yyyy").format(dateAd);
                    out.print(today);
                %>
            </td>
            <td>
                <c:choose>
                    <c:when test="${adTop.favor==1}">
                        <img style='width: 25px;' src='http://i.piccy.info/i9/bdfebd1d105afe669c3904391b4d2b2b/1616363027/19124/1415872/star.jpg' alt='YES'/>
                    </c:when>
                </c:choose>

            </td>
        </tr>
    </c:forEach>

        </c:when>
    </c:choose>

    <c:forEach items="${ads}" var="ad">
        <tr>
            <td>
                <a href="${pathEdit}?adId=${ad.id}">${ad.name}</a>
            </td>
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
            <td><c:set var="dtAds" value="${ad.date}"/>
                <%
                    java.util.Date dateAd=(java.util.Date) pageContext.getAttribute("dtAds");
                    String today = new SimpleDateFormat("dd-MM-yyyy").format(dateAd);
                    out.print(today);
                %>
            </td>
            <td>
                <c:choose>
                    <c:when test="${ad.favor==1}">
                        <img style='width: 25px;' src='http://i.piccy.info/i9/bdfebd1d105afe669c3904391b4d2b2b/1616363027/19124/1415872/star.jpg' alt='YES'/>
                    </c:when>
                </c:choose>

            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<c:if test="${empty sessionScope.authenticated}">
<table width="80%"  align="center">

    <tr>

        <th><form action=${pathAuth} method='GET' >
            <input type='submit' id='bold2'   class='buttonEnabled' value='Login'/>
        </form>
        </th>
        <th><form action=${pathReg} method='GET' >
            <input type='submit' id='bold1'   class='buttonEnabled' value='Register'/>
        </form>
        </th>
    </tr>
</table>
</c:if>

<c:if test="${not empty sessionScope.authenticated}">
    <table width="80%"  align="center">

        <tr>

            <th><form action=${pathAddAd} method='GET' >
                <input type='submit' id='bold3'   class='buttonEnabled' value='Add Ad'/>
            </form>
            </th>
            <th><form action=${editU} method='GET' >
                <input type='submit' id='bold4'   class='buttonEnabled' value='Edit Account'/>
            </form>
            </th>
            <th><form action=${pathMain} method='GET' >
                <input type='submit' id='bold6'   class='buttonEnabled' name='logoff' value='Log off'/>
            </form>
            </th>

        </tr>
    </table>
</c:if>
<br/>
<form action=${pathMain} method='GET' >
    <input type='submit' id='bold5'   class='buttonEnabled' value='Reset All Filters'/>
</form>
</body>
</html>