<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Education</title>
<style>
</style>
<link rel="stylesheet" type="text/css" media="all" href="resources/css/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="resources/js/jsDatePick.min.1.3.js"></script>

<script language="Javascript">

function Add()
{
	//alert("inside add method");
	
    document.Formedudetails.action = "Edudetailsadder.html";
    //alert(document.Form1.action);
    document.Formedudetails.submit();             
    return true;
}



function Hide(hide) {
    var t = document.getElementById("Disability");
    if(hide == "Regular")
    {
    	t.rows[6].style.display = 'none';
    	t.rows[5].style.display = 'none';
    }
    else
    {
    	t.rows[6].style.display = 'block';
	   	t.rows[5].style.display = 'block';
    }
    
    
  return true;
}

function isNumberKey(evt) 
{ 
   var charCode = (evt.which) ? evt.which : event.keyCode; 
   if (charCode != 46 && charCode > 31  
     && (charCode < 48 || charCode > 57)) 
      return false; 

   return true; 
} 
</script>

</head>
<body onLoad="Hide('Regular');">
	<%@include file="top.jsp"%>
	<div id="container" class="box">

		<div id="obsah" class="content box">
			<div class="in">
			
				<form:form modelAttribute="EducationalDetails" name="Formedudetails" method="post" action="Childdetailsadder.html">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<form:hidden path="id" />
					<form:hidden path="help_child_id" value="${Child.id}" />
					
					<table id="Disability">
						<tr>
							<td>Status of Child:</td>
							<td><form:select path="regularityType" onChange="return Hide(this.options[this.selectedIndex].value)">
								<form:option value="-1" label="--- Select ---" />
								<form:option value="Regular" label="Regular" />
								<form:option value="Irregular" label="Irregular" />
								<form:option value="LeftOut" label="LeftOut" />
								<form:option value="Not Entered School" label="Not Entered School" />
								</form:select>
							</td>
							
						</tr>
						<tr><td>You are entering details Of this</td>
							<td>${Child.child_name}</td>						
						</tr>
						
						<tr>
							<td>Class RollNo:</td>
							<td><form:input path="roll_no" onkeypress="return isNumberKey(event)" /></td>
							<td><form:errors path="roll_no" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><form:label path="help_class_id">Class</form:label></td>
							<td><form:select path="help_class_id" >
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
							
						</tr>
						
						<tr>
							<td><form:label path="help_school_id">School</form:label></td>
							<td><form:select path="help_school_id">
							<form:option value="-1" label="--- Select ---" /> 
							<c:forEach items="${SchoolList}" var="School">
								<form:option value="${School.id}" label="${School.name},${School.school_category.school_category} " /> 	
							</c:forEach>
							</form:select></td>
							
						</tr>
						<tr>
							<td><form:label path="help_left_school_at">Left School At</form:label></td>
							<td><form:select path="help_left_school_at" >
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
							
						</tr>
						<tr>
							<td><form:label path="help_irregularity_id">Reason</form:label></td>
							<td><form:select path="help_irregularity_id" >
								<form:option value="-1" label="--- Select ---" />
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
							
						</tr>
						<tr>
							<td><form:label path="help_age_class_id">According to Age child should be at</form:label></td>
							<td><form:select path="help_age_class_id" >
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
							
						</tr>
						
						
						
						
						
						
						
						<tr>
							<td><input type="submit" value="Add Educational Details" onClick="return Add();" /></td>
							
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