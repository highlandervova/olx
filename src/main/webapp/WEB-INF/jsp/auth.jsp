<%@ page import="data.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <style type='text/css'>

        #bold0{
            font-weight: bold;
        }
        #bold1{
            font-weight: bold;
        }
    </style>
    <title>${title}</title>
    <br/>
    <h2>Authorization page</h2>
<br/>
</head> <body>

<br/>
    <form action=${pathAuth}  method='POST'>
    Enter Login: <input type='text'     name='login'>
    Enter Pass:  &nbsp <input type='password' name='pass'>

    <br/>
    <br/>
        <input type='submit'  id='bold0'   class='buttonEnabled' value='Authorization'>
    </form>

    <br/>
    <br/>

</body>
</html>