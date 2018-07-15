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
		<link href="${conPath }/css/profile.css" rel="stylesheet">
		<title>프로파일</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
<table id="profile">
	<tr>
		<td>
			<img id="profileLogo" src="${conPath }/memberPhoto/${Mdto.mPhoto }" alt="회원사진" />
			<c:if test="${sessionMdto.mId != Mdto.mId }">
				<c:set var="isFollowing" value="1" />
				<button onclick="location.href = '${conPath}/Follow.do?mId=${Mdto.mId }'">팔로우 하기</button>
			</c:if>
		</td>
		<td class="relative">
			<table id="pesonalInfo">
				<tr>
					<td><h3><i class="fas fa-user-circle"></i></h3> Name</td>
					<td><h2>${Mdto.mName }</h2></td>
					<td><h3><i class="fas fa-user-circle"></i></h3> Grade</td>
					<td><h2>${Mdto.mName } 등급</h2></td>
				</tr>
				<tr>
					<td><h3><i class="fas fa-id-card"></i></h3> ID</td>
					<td><h5>${Mdto.mId }</h5></td>
					<td><h3><i class="fas fa-heart"></i></h3> Follow/팔로우</td>
					<td><h5><fmt:formatNumber value="${followCnt }" pattern="#,###,###" /></h5>명</td>
				</tr>
				<tr>
					<td><h3><i class="fab fa-pinterest-p"></i></h3> Point</td>
					<td><h5>${Mdto.mPoint }</h5>point</td>
					<td><h3><i class="far fa-heart"></i></i></h3> Follower/팔로워</td>
					<td><h5><fmt:formatNumber value="${followerCnt }" pattern="#,###,###" /></h5>명</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<h4 class="center">팔로우 (Follow List)</h4>
		</td>
	</tr>
	<c:if test="${empty followDtos }">
	<tr>
		<td class="center">
			<h3 class="marginContent">현제 팔로우 하는 회원은 없습니다.</h3>
		</td>
	</tr>
	</c:if>
	<c:forEach items="${followDtos }" var="fDtos">
	<tr>
		<td class="center">
			<table class="followTable">
				<tr>
					<td>
						<a class="boldCoral" href="${conPath }/profileView.do?mId=${fDtos.fId }">
							<img class="followPhoto" alt="followPhoto" src="${conPath }/memberPhoto/${fDtos.mPhoto }">
						</a>
					</td>
					<td><h4>${fDtos.fId }</h4></td>
					<td><h4>${fDtos.mName }</h4></td>
				</tr>
			</table>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td>
			<h4 class="center">팔로워 (Follower List)</h4>			
		</td>
	</tr>
	<c:if test="${empty followerDtos }">
	<tr>
		<td class="center">
			<h3 class="marginContent">현제 팔로워가 없습니다.</h3>
		</td>
	</tr>
	</c:if>
	<c:forEach items="${followerDtos }" var="ferDtos">
	<tr>
		<td class="center">
			<table class="followTable">
				<tr>			
					<td>
						<a class="boldCoral" href="${conPath }/profileView.do?mId=${ferDtos.mId }">
							<img class="followPhoto" alt="followerPhoto" src="${conPath }/memberPhoto/${ferDtos.mPhoto }">
						</a>
					</td>
					<td><h4>${ferDtos.mId }</h4></td>
					<td><h4>${ferDtos.mName }</h4></td>		
				</tr>
			</table>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
<jsp:include page="../main/footer.jsp" />	
</body>
</html>