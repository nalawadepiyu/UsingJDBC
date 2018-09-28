<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Object obj = request.getAttribute("error");
	String errorMsg = "";
	if(obj != null){
		errorMsg = (String) obj;
%>
<%= errorMsg %>
<%} %>

<form method="post" action="/UsingJDBC/ContactInfo">
  Street name: 
  <input type="text" name="street">
  <br>
  <br>
  City name:
  <input type="text" name="city">
  <br>
  <br>
  State name:
  <input type="text" name="state">
  <br>
  <br>
   Country name:
  <input type="text" name="country">
  <br>
  <br>
  <input type = "submit" value = "Submit"/>
</form>

</body>

</body>
</html>