<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome ${user}</title>
</head>
<body>
<jsp:include page="top.jsp" />

			<div id="container" class="box">

				<div id="obsah" class="content box">
					<div class="in">
<h1>
	Hello <c:out value="${user}"></c:out>  
</h1>

<P>  You have logged in at ${serverTime}. </P>

</div>
				</div>

		<jsp:include page="bottom.jsp" />
</body>
</html>
