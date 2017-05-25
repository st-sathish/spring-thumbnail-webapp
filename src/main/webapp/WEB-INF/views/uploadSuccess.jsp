<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload Success</title>
</head>
<body>
	<h4>Upload success</h4>
	<h4>The product has been saved.</h4>
    <p>Following files are uploaded successfully.</p>
    <ol>
    <c:forEach items="${fileUpload.images}" var="image">
        <li>${image.originalFilename}
        	<img width="100" src="<c:url value="/image/"/>${image.originalFilename}"/>
        </li>
    </c:forEach>
    </ol>
</body>
</html>