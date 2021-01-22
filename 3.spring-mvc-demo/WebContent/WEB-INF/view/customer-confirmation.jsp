<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE Html>

<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>
	
The Customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Postal code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}

<br><br>
</body>

</html>