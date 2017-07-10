<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<table>
		<caption>게시물 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${article.no }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${article.name }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${article.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${article.content }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${article.regDate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${article.viewCount }</td>
		</tr>
	</table>
	<br />
	<a href="list">리스트</a>
	<a href="update">수정</a>
	<a href="delete">삭제</a>
	</form>
</body>
</html>