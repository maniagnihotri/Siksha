<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add District</title>
<style>

</style>
<script language="Javascript">
function Add()
{
	//alert("inside add method");
	
    document.Form1.action = "distView.html";
    //alert(document.Form1.action);
    document.Form1.submit();             
    return true;
}

function Update()
{
    document.Form1.action = "updateDistrict.html";
    document.Form1.submit();             // Submit the page
    return true;
}

function confirmation() {
	var answer = confirm("Deleting this District,deletes all the blocks,clusters under it! Are you sure? ");
	if (answer){
		alert("Bye bye!");
		//window.location = "http://www.google.com/";
		return true;
	}
	else
	{
		return false;
	}
	
}

</script>
</head>
<body>
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">

				<form:form name="Form1" modelAttribute="district" method="post">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="ID" />
					<table>
						<tr>
							<td><form:label path="district_name">District Name</form:label></td>
							<td><form:input path="district_name" /></td>

						</tr>

						<tr>
							<td><input type="submit" value="Add District" onClick="return Add();" /></td>
							<td><input type="submit" value="Update District" onClick="return Update();"/></td>
						</tr>
					</table>

				</form:form>
				
				<table>
				<c:forEach items="${alldistricts}" var="attName">
					<tr>
						<td>
							<c:out value="${attName.ID}"/><br/>
						</td>
						<td>
							<c:out value="${attName.district_name}"/><br/>
						</td>
						 <td><a href="updateDistrict${attName.district_name}.html">Update</a> 
                             | <a href="deleteDistrict${attName.district_name}.html" onClick="return confirmation();" >Delete</a></td>
					</tr>	
					
				</c:forEach>
				</table>
				</div>
				</div>
				<%@include file="adminBottom.jsp"%>
</body>
</html>