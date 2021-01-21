<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html>

<head>
	<title>Customer Registration Form</title>
	<style>
		.error {color:red}
	</style>
</head>

<body>

<i>Fill out a form. Asterisk(*) is required.</i>

<br><br>

	<form:form action="processForm" modelAttribute="customer">

		First name : <form:input path="firstName" />
		
		<br><br>
		
		Last name (*) : <form:input path="lastName" />	
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>
		
		FreePasses: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error"/> 
		
		<br><br>
		
		postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/> 
		
		<input type="submit" value="Submit" />
		
	</form:form>
	
</body>

</html>
