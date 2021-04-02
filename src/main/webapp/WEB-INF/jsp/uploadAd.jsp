<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <style type='text/css'>
        #bold0{
            font-weight: bold;
        }
    </style>
    <title>${title}</title>
    <br/>
    <h2>upload page</h2>
    <br/>
</head> <body>

<br/>
<br/><br/>

<form  method='post' enctype = 'multipart/form-data'>
    <input type="hidden" value="${ad.id}" name="id"/>




    <br/>
    <br/>


    <div>
        <label for="image_uploads">Choose images to upload (PNG, JPG)</label>
        <input type="file" id="image_uploads" name="file"  multiple>
    </div>

    <input type='submit' class='buttonEnabled' name='uploadfile' value='UPLOAD' />
</form>


<br/>
<br/>

</body>
</html>