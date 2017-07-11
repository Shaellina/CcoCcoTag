<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	// $(); 이 상태가 $('document').ready(); 된 상태 

	$(function() {
		$('#btnText').click(function() {
			$('#rcv_msg').load('msg.txt');
		})
		$('#btnJsp').click(function() {
			$('#rcv_msg').load('msg.jsp');
		})
	})
</script>

</head>
<body>
	<input type="button" id="btnText" value="get text" />
	<input type="button" id="btnJsp" value="get jsp" />
	<div id="rcv_msg"></div>
</body>
</html>