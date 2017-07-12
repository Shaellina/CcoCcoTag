<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<style type="text/css">
table.type08 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type08 thead th {
	padding: 10px;
	font-weight: bold;
	border-top: 1px solid #ccc;
	border-right: 1px solid #ccc;
	border-bottom: 2px solid #c00;
	background: #dcdcd1;
}

table.type08 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	background: #ececec;
}

table.type08 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

a {
	text-decoration: none;
}

a:ENABLED {
	color: #3f3f3f;
}

a:ACTIVE {
	color: #3f3f3f;
	text-shadow: navy;
}

a:HOVER {
	color: #3f3f3f;
	font-style: oblique;
}
</style>
</head>
<body>
	<table class="type08">
		<caption>게시물 리스트</caption>
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
				<td colspan="5" align="center"><a
					href="pagelist?page=${cur-11 < 1? 1: cur-11 }"> ◁◁ </a> <c:forEach
						items="${pages}" var="page">
						<c:if test="${page != cur}">
							<a href="pagelist?page=${page}">${page}</a>
						</c:if>
						<c:if test="${page == cur }">
							<a>${page}</a>
						</c:if>
					</c:forEach> <a href="pagelist?page=${cur+11 > end-1? end-1: cur+11 }"> ▷▷
				</a></td>
			</tr>
		</tbody>
	</table>
	<br />
	<a href="insert">글쓰기</a>
	<br />
</body>
</html>