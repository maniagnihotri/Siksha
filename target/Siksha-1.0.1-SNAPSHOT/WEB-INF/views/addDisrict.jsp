<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add District</title>
</head>
<body>
<form:form method="post" action="distadder.html">
 
    <table>
    <tr>
        <td><form:label path="districtname">District Name</form:label></td>
        <td><form:input path="districtname" /></td> 
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Add District"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>