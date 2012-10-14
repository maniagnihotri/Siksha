<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head><title>Login Page</title></head>
<style>
.errorblock {
color: #ff0000;
background-color: #ffEEEE;
border: 3px solid #ff0000;
padding: 8px;
margin: 16px;
}
</style>
<html>
<body onload='document.command.j_username.focus();'>
			<%@include file="top.jsp" %>
			
<c:if test="${not empty error}">
<div class="errorblock">
Login error : Please try again.<br />Root Cause:
${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
</c:if>



			<div id="container" class="box">

				<div id="obsah" class="content box">
					<div class="in">

						<form:form action="j_spring_security_check" method='POST'>

							<table>
								<tr>
									<td><form:label path="j_username">User Name</form:label></td>
									<td><form:input path="j_username" tabindex="1" ></form:input></td>
								</tr>
								<tr>
									<td><form:label path="j_password">Password</form:label></td>
									<td><form:password path="j_password" tabindex="2" /></td>
								</tr>
								<!--tr>
									<td>Password:</td>
									<td><input type='password' name='j_password' /></td>
								</tr-->
								<tr>
									<td colspan="2"><form:checkbox path="_spring_security_remember_me" name="_spring_security_remember_me"/>
									<form:label path="_spring_security_remember_me">Remember me on this computer</form:label></td>
								</tr>
								
								<tr>
									<td colspan="2"><input type="submit" value="Login" /></td>
								</tr>
							</table>

						</form:form>


					</div>
				</div>

			<%@include file="bottom.jsp" %>
</body>
</html>