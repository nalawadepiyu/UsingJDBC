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

  <form method="post" action="/UsingJDBC/BankInfoServlet">
  Bank Name: 
  <input type="text" name="bankname">
  <br>
  <br>
  Account Number:
  <input type="text" name="accountnumber">
  <br>
  <br>
 SSN:
  <input type="text" name="ssn">
  <br>
  <br>
  <input type = "submit" value = "Submit"/>
</form>


</body>
</html>