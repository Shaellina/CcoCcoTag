<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<form action="uploads.do" method="post" enctype="multipart/form-data">
		글쓴이 <input type="text" name="name" /><br/>
		제목   <input type="text" name="title" /><br/>
		<input type="file" name="uploadFile" /> <input type="submit" value="전송" />
	</form>
</body>
</html>