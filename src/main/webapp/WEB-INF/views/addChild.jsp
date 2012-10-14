<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Child</title>
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
<link rel="stylesheet" type="text/css" media="all" href="resources/css/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="resources/js/jsDatePick.min.1.3.js"></script>

<script language="Javascript">

//document.onready = Hide(true);
window.onload = work();
	
	
	
	function work(){
		new JsDatePick({
			useMode:2,
			target:"Date",
			dateFormat:"%d-%M-%Y"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
	};
function Add()
{
	//alert("inside add method");
	
    document.Formchilddetails.action = "Childdetailsadder.html";
    //alert(document.Form1.action);
    document.Formchilddetails.submit();             
    return true;
}

/* function dropDownDistrictchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formchilddetails.action = "BlocknamesinSelectPlace.html";
    document.Formchilddetails.submit();             // Submit the page
	return true;
}

function dropDownBlockchange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formchilddetails.action = "ClustersnamesinSelectPlace.html";
    document.Formchilddetails.submit();             // Submit the page
	return true;
}

function dropDownVillagetypenameschange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formchilddetails.action = "VillageinSelectplace.html";
    document.Formchilddetails.submit();             // Submit the page
	return true;
}

function dropDownTypechange() {
	//alert("In dropDownchange() method");
    // window.location = "Blocknames.html";
    document.Formchilddetails.action = "VillagetypenamesinSelectPlace.html";
    document.Formchilddetails.submit();             // Submit the page
	return true;
} */

function Hide(hide) {
//	alert("In Hide method");
    // window.location = "Blocknames.html";
    var t = document.getElementById("Disability");
    if(hide)
    	{
    	//alert("In if Hide method");
    	t.rows[10].style.display = 'none';
    	}
    else
    	{
    	//alert("In else Hide method");
    	t.rows[10].style.display = 'block';
    	}
  //  document.Formchilddetails.action = "VillagetypenamesinSelectPlace.html";
   // document.Formchilddetails.submit();             // Submit the page
	return true;
}
</script>

</head>
<body onLoad="Hide(true);work();">
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">
			
				<form:form modelAttribute="ChildDetails" name="Formchilddetails" method="post" action="Childdetailsadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="id" />
					<table id="Disability">
						<tr><td>You are entering details to this village/town</td>
							<td>${VillageName}</td>						
						</tr>
						
						<tr>
							<td>Child Name:</td>
							<td><form:input path="child_name" /></td>
							<td><form:errors path="child_name" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Father Name:</td>
							<td><form:input path="father_name" /></td>
							<td><form:errors path="father_name" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Mother Name:</td>
							<td><form:input path="mother_name" /></td>
							<td><form:errors path="mother_name" cssClass="error" /></td>
						</tr>
						<tr>
							<td>House No:</td>
							<td><form:input path="house_no" /></td>
							<td><form:errors path="house_no" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Date Of Birth:</td>
							<td><form:input path="date_of_birth" id="Date" /></td>
							<td><form:errors path="date_of_birth" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td><form:radiobutton path="gender" value="M" />Male 
								<form:radiobutton path="gender" value="F" />Female
							</td>
							
							
						</tr>
						<tr>
							<td>Caste:</td>
							<td><form:input path="caste" /></td>
							<td><form:errors path="caste" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Caste Type:</td>
							<td><form:select path="child_name" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1" label="SC" />
								<form:option value="2" label="ST" />
								<form:option value="3" label="OBC" />
								<form:option value="4" label="General" />
								</form:select>
							</td>
							<td><form:errors path="child_name" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Is the Child Disable</td>
							<td><form:radiobutton path="isdisable" value="0" onClick="Hide(false)"/>Yes 
								<form:radiobutton path="isdisable" value="1" onClick="Hide(true)"/>No
							</td>
							
						</tr>
						
						<tr>
							<td><form:label path="disabilityid">District</form:label></td>
							<td><form:select path="disabilityid">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${DisabilityList}" var="Disability">
								<form:option value="${Disability.id}" label="${Disability.reason}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="disabilityid" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Add Child" onClick="return Add();" /></td>
							
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