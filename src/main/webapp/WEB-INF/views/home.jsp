<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello <c:out value="${user}"></c:out>  
</h1>

<P>  You have logged in at ${serverTime}. </P>
</body>
</html>
