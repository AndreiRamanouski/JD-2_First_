<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are logged in</title>
<link rel="stylesheet" href="style.css">

</head>
<body class="body">
 <a href="Controller?command=logout"><p align="left">Logout</p></a>

  
  
  <div class = 'news'>
	<c:set var="user" value="${requestScope.user }"/>
	<c:forEach var="n" items="${requestScope.news }">
		<tr>
			<td>
				<p align="right">
				<c:out value="${n.date }" />
				</p>
				<h2>
				<c:out value="${n.title }" /> 
				<br />
				</h2>
				
				<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
				<c:out value="${n.brief }" />
				
				 <a href="Controller?command=readWholeNews&newsaction=${n.id }">continue reading</a>
				</h5>
			</td>
		</tr>
		</c:forEach>

	</div>
</body>
</html>