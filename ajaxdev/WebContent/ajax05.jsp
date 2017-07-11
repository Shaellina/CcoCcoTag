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
	$(function() {
		$('#btnClass').click(function() {
			$.getScript('script.js');
		});
	});
</script>
</head>
<body>
	<input type="button" id="btnClass" value="get" />
	<hr />
	<ul type="square">
		<div id="rcv_msg"></div>
	</ul>
</body>
</html>
