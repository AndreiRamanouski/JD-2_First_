<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>First</title>
<link rel="stylesheet" href="style.css">
<style>
.p{
text-align:left;
}
</style>

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.message" var="message"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

</head>
<body class='body'>

<c:out value = "${message }"/>
<form  action="Controller" method="post">
		
		<input type="hidden" name="local" value="ru">

	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
		<input type="hidden" name="local" value="en">

	<input type="submit" value="${en_button}" /> <br/>
	
</form>
	
	
 <header>
 	
	<p class="p"><a href="Controller?command=registration">Registration</a> 
	 <a href="Controller?command=loginationPage">Logination</a></p>
	
	<font color="green" >	<%
	String message = (String) request.getParameter("message");
	if( message != null){
		out.write(message);
		}
	%>
	</font>
	
	
	
	<div class = 'news'>
	
	
	
	<c:forEach var="n" items="${requestScope.news }">
		<tr>
			<td>
				<h2>
				<c:out value="${n.title }" /> 
				<br />
				</h2>
				<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
				<c:out value="${n.brief }" />
				
				</h5>
			</td>
		</tr>
		</c:forEach>
	


	</div>
	
</header>


</body>
</html>