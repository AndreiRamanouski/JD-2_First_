<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Registration</title>
</head>
<body class='body'>
  
 <header >

	
	<form class='forma' action="Controller" method="post">
	<input class='input' type="hidden" name='command' value="savenewuser">
	Enter name:<br />
	<input class='input' type='text' name="login" value='' /> <br />
	Enter surname:<br />
	<input class='input' type='text' name='password' value="" /> <br />
	<input class='input-words' type='submit' value="Registrate" /> <br />
	<br />
	<br />
	<br />
	
<a href="Controller?command=savenewuser">SaveNewUser</a> 
	</form>

	
	
	
</header>
</body>
</html>