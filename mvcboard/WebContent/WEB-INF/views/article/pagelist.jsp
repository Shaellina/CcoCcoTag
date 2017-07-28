<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="container">
<h2 class="text-center">게시물 리스트</h2>
	
	<table class="table">
<%-- 		<caption>게시물 리스트</caption> --%>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="vo">
				<tr>
					<td>${vo.no }</td>
					<td><a id="detail" href="detail?no=${vo.no }">${vo.title }</a></td>
					<td>${vo.name }</td>
					<td>${vo.regDate }</td>
					<td>${vo.viewCount }</td>
				</tr>
			</c:forEach>
			
			<tr>
			
				<td colspan="5" align="center"> <ul class="pagination"><li class="active"><a
					href="pagelist?page=${cur-11 < 1? 1: cur-11 }"> ◁◁ </a></li></ul> <ul class="pagination"><c:forEach
						items="${pages}" var="page">
						<c:if test="${page != cur}">
							<li><a href="pagelist?page=${page}">${page}</a></li>
						</c:if>
						<c:if test="${page == cur }">
							<li class="active"><a>${page}</a></li>
						</c:if>
					</c:forEach></ul> <ul class="pagination"><li class="active"><a href="pagelist?page=${cur+11 > end-1? end-1: cur+11 }"> ▷▷
				</a></li></ul></td>
			
			</tr>
		</tbody>
	</table>
	</div>
	<br />
	<a href="insert">글쓰기</a>
	<br />
	</div>
</body>
</html>