<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are reading the news</title>
<link rel="stylesheet" href="style.css">

</head>
<body class="body">
 <a href="Controller?command=logout"><p align="left">Logout</p></a>

  
  
  <div class = 'news'>
	<c:set var="news" value="${requestScope.news}"/>
	
		<tr>
			<td>
				<p align="right">
				<c:out value="${news.date }" />
				</p>
				<h2>
				<c:out value="${news.title }" /> 
				<br />
				</h2>
				
				<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
				<c:out value="${news.brief }" /> <br/>
				<c:out value="${news.content }" />
				
				<c:if test="${sessionScope.role eq \"adm\" }" >
				<a href="Controller?command=edit&newsaction=${news.id }">edit</a>
				</c:if>
			
				 
				</h5>
				<a href="Controller?command=gotomainpage" align="center">Back</a>
			</td>
		</tr>
		
	
	</div>
</body>
</html>