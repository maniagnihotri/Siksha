<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Block</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<script language="Javascript">
function Add()
{
	//alert("inside add method");
	
    document.Formblock.action = "Blockadder.html";
    alert(document.Form1.action);
    document.Formblock.submit();             
    return true;
}

function Update()
{
    document.Formblock.action = "updateBlock.html";
    document.Formblock.submit();             // Submit the page
    return true;
}

function confirmation() {
	var answer = confirm("Deleting this District,deletes all the blocks,clusters under it! Are you sure? ");
	if (answer){
		//alert("Bye bye!");
		//window.location = "http://www.google.com/";
		return true;
	}
	else
	{
		return false;
	}
}
function dropDownchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formblock.action = "Blocknames.html";
    document.Formblock.submit();             // Submit the page
	return true;
}

</script>

</head>
<body>
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">

				<form:form modelAttribute="block" name="Formblock" method="post" action="Blockadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="block_id" />
					
					<table>
						<tr>
							<td><form:label path="district_id">District</form:label></td>
							<td><form:select path="district_id" onChange="return dropDownchange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${DistrictNameList}" var="District">
								<form:option value="${District.ID}" label="${District.district_name}" /> 	
							</c:forEach>
							</form:select></td>
							
							
							<td><form:errors path="district" cssClass="error" /></td>
						</tr>
						<tr>
							<td>BlockName :</td>
							<td><form:input path="block_name" /></td>
							<td><form:errors path="block_name" cssClass="error" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Block" onClick="return Add();" /></td>
							<td><input type="submit" value="Update Block" onClick="return Update();"/></td>
						</tr>
					</table>

				</form:form>
				<!--  c:if test="${not empty requestScope.BlockList}"-->  
   

				<table>
				<c:forEach items="${BlockList}" var="attName">
					<tr>
						<td>
							<c:out value="${attName.block_id}"/><br/>
						</td>
						<td>
							<c:out value="${attName.block_name}"/><br/>
						</td>
						   <td><a href="updateBlock${attName.block_id}.html">Update</a> 
                             | <a href="deleteBlock${attName.block_id}.html" onClick="return confirmation();" >Delete</a></td> 
					</tr>	
					
				</c:forEach>
				</table>
				<!--  /c:if-->
				</div>
				</div>
				<%@include file="bottom.jsp"%>
</body>
</html>