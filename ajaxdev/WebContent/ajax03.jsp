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
		/* $('#btnText').click(function() {
			$('#rcv_msg').load('msg.txt');
		})
		$('#btnJsp').click(function() {
			$('#rcv_msg').load('msg.jsp');
		}) */
		$('#btnText').click(function() {
			// method chain 방식 코딩			
			$.get('msg.txt').done(function(data) {
				alert(data)
			});
		})
		$('#btnJsp').click(function() {
			// method chain 방식 코딩			
			/* $.get('iam.jsp', {
				'name' : $('#name').val()
			}).done(function(data) {
				alert(data)
			}); */
			// 위와 같이 json 방식으로 전송하게 된다면 request.getParameter로 받을 수 있다.
			$.post('iam.jsp', {
				'name' : $('#name').val()
			}).done(function(data) {
				alert(data)
			});
		})
	})
</script>

</head>
<body>
	<input type="button" id="btnText" value="get text" />
	<hr />
	<input type="text" id="name" />

	<input type="button" id="btnJsp" value="get jsp" />
	<div id="rcv_msg"></div>
</body>
</html>