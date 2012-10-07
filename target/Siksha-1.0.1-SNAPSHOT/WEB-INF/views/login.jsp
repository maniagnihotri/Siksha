
<head><title>Login Page</title></head>
<html>
<body>
			<%@include file="top.jsp" %>

			<div id="container" class="box">

				<div id="obsah" class="content box">
					<div class="in">

						<form:form method="post" action="tryLogin.html">

							<table>
								<tr>
									<td><form:label path="firstname">User Name</form:label></td>
									<td><form:input path="firstname" tabindex="1" /></td>
								</tr>
								<tr>
									<td><form:label path="password">Password</form:label></td>
									<td><form:password path="password" tabindex="2" /></td>
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