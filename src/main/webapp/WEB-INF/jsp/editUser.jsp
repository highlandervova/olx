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
    Enter Login: <input type='text'     name='login'>
    Enter old password:  &nbsp <input type='password' name='oldPass'>
    <br/> <br/>
    Enter new password: <input type='password' name='pass1'>
    Enter new password again: <input type='password' name='pass2'>
    <br/> <br/>
    Enter City: &nbsp  <input type='text'  name='city'>
    Enter Phone: <input type='text' name='phone'>
    Enter Email: <input type='text' name= 'email'>
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
