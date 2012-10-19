<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Cluster</title>
<style>

</style>

<script language="Javascript">
function Add()
{
	//alert("inside add method");
	
    document.Formclusters.action = "Clustersadder.html";
    //alert(document.Form1.action);
    document.Formclusters.submit();             
    return true;
}

function Update()
{
    document.Formclusters.action = "updateClusters.html";
    document.Formclusters.submit();             // Submit the page
    return true;
}

function confirmation() {
	var answer = confirm("Deleting this Cluster,deletes all the areas under it! Are you sure? ");
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
    document.Formclusters.action = "Blocknamesincluster.html";
    document.Formclusters.submit();             // Submit the page
	return true;
}

function dropDownBlockchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formclusters.action = "Clusternames.html";
    document.Formclusters.submit();             // Submit the page
	return true;
}
</script>

</head>
<body>
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">

				<form:form modelAttribute="clusters" name="Formclusters" method="post" action="Clustersadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="cluster_id" />
					<table>
						<tr>
							<td><form:label path="district_id">District</form:label></td>
							<td><form:select path="district_id" onChange="return dropDownDistrictchange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${DistrictNameList}" var="District">
								<form:option value="${District.ID}" label="${District.district_name}" /> 	
							</c:forEach>
							</form:select></td>
							
						</tr>
						<tr>
							<td><form:label path="block_id">Block</form:label></td>
							<td><form:select path="block_id" onChange="return dropDownBlockchange();">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${BlockNameList}" var="Block">
								<form:option value="${Block.block_id}" label="${Block.block_name}" /> 	
							</c:forEach>
							</form:select></td>
							
							
						</tr>
						<tr>
							<td>Cluster Name :</td>
							<td><form:input path="cluster_name" /></td>
							
						</tr>
						<tr>
							<td><input type="submit" value="Add Cluster" onClick="return Add();" /></td>
							<td><input type="submit" value="Update Cluster" onClick="return Update();"/></td>
						</tr>
					</table>

				</form:form>
				<!--  c:if test="${not empty requestScope.BlockList}"-->  
   

				<table>
				<c:forEach items="${ClustersList}" var="attName">
					<tr>
						<td>
							<c:out value="${attName.cluster_id}"/><br/>
						</td>
						<td>
							<c:out value="${attName.cluster_name}"/><br/>
						</td>
						 <td><a href="updateClusters${attName.cluster_id}.html">Update</a> 
                             | <a href="deleteClusters${attName.cluster_id}.html" onClick="return confirmation();" >Delete</a></td>
					</tr>	
					
				</c:forEach>
				</table>
				<!--  /c:if-->
				</div>
				</div>
				<%@include file="adminBottom.jsp"%>
</body>
</html>