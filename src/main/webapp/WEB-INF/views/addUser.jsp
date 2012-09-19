<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add-User Page</title>
</head>
<body>
<%@include file="top.jsp" %>
<form:form method="post" action="userAdder.html">
 
    <table>
    <tr>
        <td><form:label path="firstname">FirstName</form:label></td>
        <td><form:input path="firstname" /></td> 
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">E-Mail</form:label></td>
        <td><form:input path="email" /></td> 
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone</form:label></td>
        <td><form:password path="telephone" /></td>
    </tr>
    <tr>
        <td><form:label path="status">status</form:label></td>
        <td><form:input path="status" /></td> 
    </tr>
    <tr>
        <td><form:label path="userType">userType</form:label></td>
        <td><form:password path="userType" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Login"/>
        </td>
    </tr>
</table>  
     
</form:form>
<%@include file="bottom.jsp" %>
</body>
</html>