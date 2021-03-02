<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are about to change the news</title>
<link rel="stylesheet" href="style.css">
<style>
.title{
align:right;
width:700px;
height:20px;
}
.brief{
width:700px;
height:50px;
}
.content{
width:700px;
height:250px;
}
</style>
</head>
<body class="body">

<p align="left">
 <a href="Controller?command=logout">Logout</a>
<a href="Controller?command=gotomainpage" >Back</a>
  </p>
  
  <div class = 'news'>
	<c:set var="news" value="${requestScope.news}"/>
	
	<form action="Controller" method="get">
	<input  type="hidden" name='command' value="newsUpdate">
	<input  type="hidden" name='newsaction' value="${news.id }">
	Change title:<br />
	<input class="title"  type='text' name="title" value="${news.title }"/> <br />
	Change brief:<br />
	<textarea class="brief" name="brief">${news.brief }</textarea><br />
	Change content:<br />
	<textarea class="content" name="content">${news.content }</textarea><br />
	<input  type='submit' value="Отправить" /> <br />
	<br />
	
	</form>
		

	</div>
</body>
</html>