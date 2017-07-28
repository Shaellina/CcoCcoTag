<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CcoCcoTAG More Conveniently</title>
<link rel="shortcut icon" href="<c:url value="/resources/img/logo.ico"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/list.css"/>" />
<script type="text/javascript">
::-webkit-scrollbar {width: 12px; height: 12px;  }
::-webkit-scrollbar-button:start:decrement, 
::-webkit-scrollbar-button:end:increment {display: block; width: 12px;height: 12px; background: url() rgba(0,0,0,.05);}
::-webkit-scrollbar-track {     background: rgba(0,0,0,.05); }
::-webkit-scrollbar-thumb {  background: rgba(0,0,0,.1);  }
</script>
</head>
<body style="margin: 0; background-color: #2F3540;">
	<div id="sidebar">
		<form action="upload" method="get">
			<img src="<c:url value="/resources/img/logo2.gif"/>" class="logo" /><br />
			<h1 class="welcome">
				<b>Hello,</br> ${userName}
				</b>
			</h1>
			<input type="submit" value="+UPLOAD" class="upload" /><br />
		</form>

		<%-- <form action="searchAction" method="get">
			<select name="search_option" class="tag">
				<option value="both">both</option>
				<option value="tag">tag</option>
				<option value="title">title</option>
			</select> <input type="text" name="search_word" id="searchbox"
				placeholder="Enter what you want" autofocus="autofocus" />
			<button class="search" onclick=""> 
				<img src="<c:url value="/resources/img/search.png"/>" class="search" />
			</button>
		</form>--%>

		<form action="logout" method="get">
			<input type="submit" value="LOGOUT" class="logout" />
		</form>
	</div>


	<div id="content">
		
		<c:forEach items="${fileList}" var="file">
		<div id="item">
			<a href="detail?id=${file.id}" style="text-decoration: none">
				<table class="item">
					<tr>
						<td><hr noshade class="index"></td>
					</tr>
					<tr>
						<td><img src="download.do?fileName=${file.thumbnail}" width="330" height="220"></td>
					</tr>
					<tr>
						<td class="detail" style="font-size: 13pt; color: #F2EDE4;"><b>${file.title}</b></td>
					</tr>
					<tr>
						<td class="detail" style="font-size: 10pt; color: #D9D1C7;">
							<c:if test="${not empty file.tagList}">
								<c:forEach items="${file.tagList}" var="tag" varStatus="status">
									${tag.name}<c:if test="${not status.last }">, </c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
				</table>
			</a>
		</div>
		</c:forEach>
	</div>
</body>
</html>