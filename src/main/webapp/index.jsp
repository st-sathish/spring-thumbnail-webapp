<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 	<div>
		<h3> Choose File to Upload in Server </h3>
		<form action="upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file" multiple />
			<input type="submit" value="upload" />
		</form>
	</div>
</body>
</html>