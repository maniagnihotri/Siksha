<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Welcome ${user}</title>
</head>
<body>
	<%@include file="top.jsp" %>

	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">
				<h1>
					Hello
					<c:out value="${user}"></c:out>
				</h1>
<c:if test="${not empty message}">
				<P>${message}.</P>
				</c:if>

			</div>
		</div>

		<%@include file="adminBottom.jsp" %>
</body>
</html>
