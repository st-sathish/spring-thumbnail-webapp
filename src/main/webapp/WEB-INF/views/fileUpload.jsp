<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 	<div id="global">
        <form:form commandName="upload" action="upload" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Pick Images Legend</legend>
                <p>
                    <label for="image">Pic Images: </label> 
                    <input type="file" name="images" multiple="multiple"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4"> 
                    <input id="submit" type="submit" tabindex="5" value="Upload">
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>