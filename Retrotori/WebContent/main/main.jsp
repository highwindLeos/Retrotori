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
	<title>Main</title>
	</head>
<body>
<jsp:include page="head.jsp" />
<div id="main">	
	<div id="left">
		<div id="notice">
			<table id="notoceTable">
				<tr>
					<td>번호</td>
					<td>공지내용</td>
				</tr>
				<c:if test="${empty NoticeNewList }">
				<tr>
					<td>공지사항이 없습니다.</td>
				</tr>
				</c:if>
				<c:if test="${not empty NoticeNewList }">
				<c:forEach var="notice" items="${NoticeNewList }" >
				<tr>
					<td>${notice.nNum }</td>
					<td><a href="${conPath }/notice.do">${notice.nContent }</a></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="space"></div>
		<div id="freeboard">
			<table id="freeboardTable">
				<tr>
					<td>번호</td>
					<td>게시판내용</td>
				</tr>
				<c:if test="${empty BoardNewList }">
				<tr>
					<td>게시글이 없습니다.</td>
				</tr>
				</c:if>
				<c:if test="${not empty BoardNewList }">
				<c:forEach var="board" items="${BoardNewList }" >
				<tr>
					<td>${board.bNum }</td>
					<td><a href="${conPath }/boardContentView.do?bNum=${board.bNum }">${board.bContent }</a></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
	<div id="right">
		
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>