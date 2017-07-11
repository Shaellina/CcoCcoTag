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
		$('#btnJsp').click(function() {
			$.ajax({
				method : 'GET',
				url : 'iam.jsp',
				data : {
					name : $('#name').val()
				}
			}).done(function(data) {
				//alert(data)
				$('#rcvMsg').append(data);
			//$('#rcvMsg').val(data);
			})
		})

	})
</script>

</head>
<body>
	<input type="text" id="name" />
	<input type="button" id="btnJsp" value="get jsp" />
	<div id='rcvMsg'></div>
</body>
</html>