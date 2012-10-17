<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head><link rel="shortcut icon" href="resources/img/leaf.gif" /> </head></head>
<div id="nav" class="box">
        <ul>
          <li><a href="home.html">Home<br /><span>Main page</span></a></li>
          <li><a href="children.htm">Children<br /><span>Child Accounting</span></a></li>
          <li><a href="/">Teacher<br /><span>Teacher Accounting</span></a></li>
          <c:if test="${not empty user}">
				<li><a href="j_spring_security_logout">Logout<br /><span>${user}</span></a></li>	</c:if>	
				</ul>
			
        <hr class="noscreen" />
      </div> 