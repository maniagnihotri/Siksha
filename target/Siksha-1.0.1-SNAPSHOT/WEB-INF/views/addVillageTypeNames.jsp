<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Cluster</title>
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
	
    document.Formvillagetypenames.action = "VillageTypeNamesadder.html";
    //alert(document.Form1.action);
    document.Formvillagetypenames.submit();             
    return true;
}

function Update()
{
    document.Formvillagetypenames.action = "updateVillageTypeNames.html";
    document.Formvillagetypenames.submit();             // Submit the page
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
function dropDownDistrictchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formvillagetypenames.action = "Blocknamesinvillagetype.html";
    document.Formvillagetypenames.submit();             // Submit the page
	return true;
}

function dropDownBlockchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formvillagetypenames.action = "Clustersnamesinvillagetype.html";
    document.Formvillagetypenames.submit();             // Submit the page
	return true;
}

function dropDownClusterschange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formvillagetypenames.action = "villagetype.html";
    document.Formvillagetypenames.submit();             // Submit the page
	return true;
}

function dropDownTypechange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formvillagetypenames.action = "Villagetypenames.html";
    document.Formvillagetypenames.submit();             // Submit the page
	return true;
}
</script>

</head>
<body>
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">

				<form:form modelAttribute="VillageTypeNames" name="Formvillagetypenames" method="post" action="Clustersadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="id" />
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
								<form:option value="1" label="Select ---" />	
								<form:option value="2" label="--- Select" />
							</form:select></td>
							<td><form:errors path="type_id" cssClass="error" /></td>
							
						</tr>
						<tr>
							<td>Name :</td>
							<td><form:input path="name" /></td>
							<td><form:errors path="name" cssClass="error" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Block" onClick="return Add();" /></td>
							<td><input type="submit" value="Update Block" onClick="return Update();"/></td>
						</tr>
					</table>

				</form:form>
				<!--  c:if test="${not empty requestScope.BlockList}"-->  
   

				<table>
				<c:forEach items="${VillageTypeNamesList}" var="attName">
					<tr>
						<td>
							<c:out value="${attName.id}"/><br/>
						</td>
						<td>
							<c:out value="${attName.name}"/><br/>
						</td>
						 <td><a href="updateVillageTypeNames${attName.id}.html">Update</a> 
                             | <a href="deleteVillageTypeNames${attName.id}.html" onClick="return confirmation();" >Delete</a></td>
					</tr>	
					
				</c:forEach>
				</table>
				<!--  /c:if-->
				</div>
				</div>
				<%@include file="bottom.jsp"%>
</body>
</html>