<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CcoCcoTAG More Conveniently</title>
<link rel="shortcut icon" href="<c:url value="/resources/img/logo.ico"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/user.css"/>" />

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var isEmail = false;
		$('#btn_login').click(function() {
			var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			var email = $('#email').val();
			if(!regEmail.test(email)){
				isEmail = false;
				alert('Check your email');
				email.focus();
			} else {
				isEmail = true;
			}
			if(isEmail) {
				$('#loginForm').submit();
			}
		})
	})
</script>

</head>
<body>
	<div class="center">
		<form id="loginForm" action="loginAction" method="post">
			<img src="<c:url value="/resources/img/login.png"/>" alt="SignIn" /></br> 
			<input type="email" id="email" class="login" name="user_email" placeholder="email" style="margin-top: 20px;" autofocus="autofocus" required="required"/></br> 
			<input type="password" class="login" name="user_pwd" placeholder="password" required="required"/></br> 
			<input type="submit" id="btn_login" class="btn_login" value="Login" />
		</form>
		<p>
			Want be our member? click <a href="signup" align="left">HERE</a>
		</p>
	</div>
</body>

</html>