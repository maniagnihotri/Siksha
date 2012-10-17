<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Education</title>
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

function Add()
{
	//alert("inside add method");
	
    document.Formedudetails.action = "Childdetailsadder.html";
    //alert(document.Form1.action);
    document.Formedudetails.submit();             
    return true;
}



function Hide(hide) {
    var t = document.getElementById("Disability");
    if(hide)
    	{
    	t.rows[10].style.display = 'none';
    	}
    else
    	{
	   	t.rows[10].style.display = 'block';
    	}
  return true;
}
</script>

</head>
<body onLoad="Hide(true);">
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">
			
				<form:form modelAttribute="EducationalDetails" name="Formedudetails" method="post" action="Childdetailsadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="id" />
					<form:hidden path="child_id" value="${Child.id}" />
					<table id="Disability">
						<tr><td>You are entering details Of this</td>
							<td>${Child.child_name}</td>						
						</tr>
						
						<tr>
							<td>Class RollNo:</td>
							<td><form:input path="roll_no" /></td>
							<td><form:errors path="roll_no" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><form:label path="class_id">Class</form:label></td>
							<td><form:select path="class_id" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1" label="First" />
								<form:option value="2" label="Second" />
								<form:option value="3" label="Third" />
								<form:option value="4" label="Fourth" />
								<form:option value="5" label="Fifth" />
								<form:option value="6" label="Sixth" />
								<form:option value="7" label="Seventh" />
								<form:option value="8" label="Eight" />
								<form:option value="9" label="Ninth" />
								<form:option value="10" label="Tenth" />
								<form:option value="11" label="KG 1" />
								<form:option value="12" label="KG II" />
								<form:option value="13" label="Arun" />
								<form:option value="14" label="Uday" />
								<form:option value="15" label="Nursery" />
								
								</form:select>
							</td>
							<td><form:errors path="class_id" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><form:label path="school_id">School</form:label></td>
							<td><form:select path="school_id">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${SchoolList}" var="School">
								<form:option value="${School.id}" label="${School.reason}" /> 	
							</c:forEach>
							</form:select></td>
							<td><form:errors path="school_id" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="left_school_at">Left School At</form:label></td>
							<td><form:select path="left_school_at" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1" label="First" />
								<form:option value="2" label="Second" />
								<form:option value="3" label="Third" />
								<form:option value="4" label="Fourth" />
								<form:option value="5" label="Fifth" />
								<form:option value="6" label="Sixth" />
								<form:option value="7" label="Seventh" />
								<form:option value="8" label="Eight" />
								<form:option value="9" label="Ninth" />
								<form:option value="10" label="Tenth" />
								<form:option value="11" label="KG 1" />
								<form:option value="12" label="KG II" />
								<form:option value="13" label="Arun" />
								<form:option value="14" label="Uday" />
								<form:option value="15" label="Nursery" />
								
								</form:select>
							</td>
							<td><form:errors path="left_school_at" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="irregularity">Reason</form:label></td>
							<td><form:select path="irregularity" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1"	label="Regular"/>
								<form:option value="2"	label="Shepherding "/>
								<form:option value="3"	label="Baby Sitting"/>
								<form:option value="4"	label="Home Related Work"/>
								<form:option value="5"	label="Failed a class"/>
								<form:option value="6"	label="Disability Introduced"/>
								<form:option value="7"	label="Over Aged"/>
								<form:option value="8"	label="Orphan"/>
								<form:option value="9"	label="Main Earner of family"/>
								<form:option value="10" label="Becoming Labourer"/>
								<form:option value="11" label="Fear of studying"/>
								<form:option value="12" label="Fear of Teacher"/>
								<form:option value="13" label="School is far off"/>
								<form:option value="14" label="Health Issue"/>
								<form:option value="15" label="Accident"/>
								<form:option value="16" label="Lack of knowlegede in parents"/>
								<form:option value="17" label="Others"/>
								
								</form:select>
							</td>
							<td><form:errors path="irregularity" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="age_class_id">Class</form:label></td>
							<td><form:select path="age_class_id" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1" label="First" />
								<form:option value="2" label="Second" />
								<form:option value="3" label="Third" />
								<form:option value="4" label="Fourth" />
								<form:option value="5" label="Fifth" />
								<form:option value="6" label="Sixth" />
								<form:option value="7" label="Seventh" />
								<form:option value="8" label="Eight" />
								<form:option value="9" label="Ninth" />
								<form:option value="10" label="Tenth" />
								<form:option value="11" label="KG 1" />
								<form:option value="12" label="KG II" />
								<form:option value="13" label="Arun" />
								<form:option value="14" label="Uday" />
								<form:option value="15" label="Nursery" />
								
								</form:select>
							</td>
							<td><form:errors path="age_class_id" cssClass="error" /></td>
						</tr>
						
						
						<tr>
							<td>Caste Type:</td>
							<td><form:select path="age_class_id" >
								<form:option value="-1" label="--- Select ---" />
								<form:option value="1" label="First" />
								<form:option value="2" label="Second" />
								<form:option value="3" label="Third" />
								<form:option value="4" label="Fourth" />
								<form:option value="5" label="Fifth" />
								<form:option value="6" label="Sixth" />
								<form:option value="7" label="Seventh" />
								<form:option value="8" label="Eight" />
								<form:option value="9" label="Ninth" />
								<form:option value="10" label="Tenth" />
								<form:option value="11" label="KG 1" />
								<form:option value="12" label="KG II" />
								<form:option value="13" label="Arun" />
								<form:option value="14" label="Uday" />
								<form:option value="15" label="Nursery" />
								
								</form:select>
							</td>
							<td><form:errors path="casteid" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Is the Child Disable</td>
							<td><form:radiobutton path="isdisable" value="0" onClick="Hide(false)"/>Yes 
								<form:radiobutton path="isdisable" value="1" onClick="Hide(true)"/>No
							</td>
							
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