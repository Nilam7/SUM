<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean class="com.examples.Summ" id="data" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
<jsp:getProperty property="bad" name="data"/>
<form action="Summation" method = "post">
<input type = "text" name="values" value="<jsp:getProperty name="data" property="values"/>">
<input type="submit">
</form>
</body>
</html>