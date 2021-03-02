<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Logination Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body class='body'>
	
 <header>
	<form class='forma' action="Controller" method="post">
	

	<input class='input' type="hidden" name='command' value="logination">
	Enter login:<br />
	<input class='input' type='text' name="login" value='' /> <br />
	Enter password:<br />
	<input class='input' type='password' name='password' value="" /> <br />
	<input class='input-words' type='submit' value="Отправить" /> <br />
	<br />
	</form>
</header>


</body>
</html>