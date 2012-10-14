<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Place</title>
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
	
    document.Formselectplace.action = "SelectPlace.html";
    //alert(document.Form1.action);
    document.Formselectplace.submit();             
    return true;
}

function dropDownDistrictchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formselectplace.action = "BlocknamesinSelectPlace.html";
    document.Formselectplace.submit();             // Submit the page
	return true;
}

function dropDownBlockchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formselectplace.action = "ClustersnamesinSelectPlace.html";
    document.Formselectplace.submit();             // Submit the page
	return true;
}

function dropDownVillagetypenameschange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formselectplace.action = "VillageinSelectplace.html";
    document.Formselectplace.submit();             // Submit the page
	return true;
}

function dropDownTypechange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formselectplace.action = "VillagetypenamesinSelectPlace.html";
    document.Formselectplace.submit();             // Submit the page
	return true;
}
</script>

</head>
<body>
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">

				<form:form modelAttribute="PlaceHelper" name="Formselectplace" method="post" action="SelectPlace.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					
					<table>
						<tr>
							<td><form:label path="district_id">District</form:label></td>
							<td><form:select path="district_id" onChange="return dropDownDistrictchange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${DistrictNameList}" var="District">
								<form:option value="${District.ID}" label="${District.district_name}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="district_id" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="block_id">Block</form:label></td>
							<td><form:select path="block_id" onChange="return dropDownBlockchange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${BlockNameList}" var="Block">
								<form:option value="${Block.block_id}" label="${Block.block_name}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="block_id" cssClass="error" /></td>
							
						</tr>
						<tr>
							<td><form:label path="cluster_id">Cluster</form:label></td>
							<td><form:select path="cluster_id">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${ClustersNameList}" var="Clusters">
								<form:option value="${Clusters.cluster_id}" label="${Clusters.cluster_name}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="cluster_id" cssClass="error" /></td>
							
						</tr>
						<tr>
							<td><form:label path="type_id">Type</form:label></td>
							<td><form:select path="type_id" onChange="return dropDownTypechange();">
							<form:option value="-1" label="--- Select ---" /> 
								<form:option value="1" label="Panchayat" />	
								<form:option value="2" label="Town" />
							</form:select></td>
							<td><form:errors path="type_id" cssClass="error" /></td>
							
						</tr>
						<tr>
							<td><form:label path="villagetypenames_id">Kshetra</form:label></td>
							<td><form:select path="villagetypenames_id" onChange="return dropDownVillagetypenameschange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${VillagetypenamesList}" var="villagetypenames">
								<form:option value="${villagetypenames.id}" label="${villagetypenames.name}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="villagetypenames_id" cssClass="error" /></td>
							
						</tr>
						<tr>
							<td><form:label path="village_id">Village/Ward</form:label></td>
							<td><form:select path="village_id">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${VillageList}" var="village">
								<form:option value="${village.id}" label="${village.name}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="villagetypenames_id" cssClass="error" /></td>
							
						</tr>
						
						<tr>
							<td><input type="submit" value="Add Block" onClick="return Add();" /></td>
							
						</tr>
					</table>

				</form:form>
				<!--  c:if test="${not empty requestScope.BlockList}"-->  
   

			
				<!--  /c:if-->
				</div>
				</div>
				<%@include file="bottom.jsp"%>
</body>
</html>