<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<table>
	<tr>
		<jsp:useBean id="personalinfo" class="com.apex.vo.PersonalInfoBean" scope="session"/>
		<td>
		First Name
		</td>
		<td>		
		<jsp:getProperty property="firstname" name="personalinfo"/>
		</td>
	</tr>
	<tr>
		<td>
		Middle Name
		</td>
		<td>
		<jsp:getProperty property="middlename" name="personalinfo"/>
		</td>
	</tr>
	<tr>
		<td>
		Middle Name
		</td>
		<td>
		<jsp:getProperty property="lastname" name="personalinfo"/>
		</td>
	</tr>
	
	<jsp:useBean id="contactinfo" class="com.apex.vo.ContactInfoBean" scope="session"/>
	<tr>
		<td>
		Street: 
		</td>
		<td>
		<jsp:getProperty property="street" name="contactinfo"/>
		</td>
	</tr>
	<tr>
		<td>
		City:
		</td>
		<td>
		<jsp:getProperty property="city" name="contactinfo"/>
		</td>
	</tr>
	<tr>
		<td>
		State:
		</td>
		<td>
		<jsp:getProperty property="state" name="contactinfo"/>
		</td>
	</tr>
	<tr>
		<td>
		Country :
		</td>
		<td>
		<jsp:getProperty property="country" name="contactinfo"/>
		</td>
	</tr>
	
	<jsp:useBean id="bankinfo" class="com.apex.vo.BankInfoBean" scope="session"/>
	
	<tr>
		<td>
		Bank Name :
		</td>
		<td>
		<jsp:getProperty property="bankname" name="bankinfo"/>
		</td>
	</tr>
	
	<tr>
		<td>
		Account Number :
		</td>
		<td>
		<jsp:getProperty property="accountnumber" name="bankinfo"/>
		</td>
	</tr>
	
	<tr>
		<td>
		SSN :
		</td>
		<td>
		<jsp:getProperty property="ssn" name="bankinfo"/>
		</td>
	</tr>
</table>
</form>

</body>
</html>