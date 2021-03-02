<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc }" key="local/message" var="message"/>
<fmt:message bundle="${loc }" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc }" key="lcal.locbutton.name.en" var="en_button"/>


</head>
<body>

<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru">

	<input type="submit" value="${ru_button }" /> <br/>
</form>
<form action="Controller" method="post">
		<input type="hidden" name="local" value="en">

	<input type="submit" value="${en_button }" /> <br/>
</form>
	<c:out value = "${message }"/>


</body>
</html>