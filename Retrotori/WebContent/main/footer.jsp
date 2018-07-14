<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Footer</title>
	</head>
<body>
<div id="wrap">
	<div id="footer">
		<div class="col1">
			<img class="footerLogo" src="${conPath }/img/logo.png" alt="logo" />
		</div>
		<div class="col2"></div>
		<div class="col3"></div>
		
	</div>
	<div>
		<h4>Copyright LEO Portfolio All right Reserved</h4>
	</div>
</div>
</body>
</html>