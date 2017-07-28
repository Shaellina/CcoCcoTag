<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CcoCcoTAG More Conveniently</title>
<link rel="shortcut icon" href="<c:url value="/resources/img/logo.ico"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/signup.css"/>" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

var check_email = false;
var check_pwd = false;

	$(document).ready(function() {
		function email_check() {
			var email = $('#email').val();
			if(check_email) {
				$('#email_check').attr('src', '<c:url value="/resources/img/check_blue.png"/>');
				$('#email_check').css('visibility','visible');
			} else {
				$('#email_check').attr('src', '<c:url value="/resources/img/check_red.png"/>');
				$('#email_check').css('visibility','visible');
			}
		}
		
		function pwd_check() {
			var pwd = $('#pwd').val();
			var pwd_confirm = $('#pwd_confirm').val();
			check_pwd = (pwd===pwd_confirm?true:false);
			if(check_pwd) {
				$('#pwd_check').attr('src', '<c:url value="/resources/img/check_blue.png"/>');
				$('#pwd_check').css('visibility','visible');
			} else {
				$('#pwd_check').attr('src', '<c:url value="/resources/img/check_red.png"/>');
				$('#pwd_check').css('visibility','visible');
			}
		}
		
		function pwd_check_visible() {
			if(check_pwd) {
				$('.pwd_check').css('visibility','visibility').css('color','green');
				$('.pwd_check').html('The password is correct.');
			} else {
				$('.pwd_check').css('visibility','visibility').css('color', 'red');
				$('.pwd_check').html('The password is different.');
			}
		}
		$('#email').change(function() {
			var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			var email = $('#email').val();
			$.getJSON('/tag/signup_check.do', {
				email : email
			}, function(data) {
				//alert(data.RESULT);
				if (data.RESULT == "True") {
					if(!email){
						alert('Check your email');
						email.focus();
					} else if(!regEmail.test(email)){
						alert('Check your email');
						email.focus();
					} else {
						check_email = true;
					}
					email_check();
				} else if (data.RESULT == "False") {
					check_email = false;
					email_check();
				} else {
					alert('return abnormal value');
				}
			})
		})

		$('#pwd').change(function() {
			let confirm_val= $('#pwd_confirm').val();
			if(confirm_val != null || confirm_val != '') {
				pwd_check();
			}
		})
		
		$('#pwd_confirm').keyup(function() {
			pwd_check();
		})
		
		$('.btn_signup').click(function() {
			email_check();
			pwd_check();
			if(check_email && check_pwd) {
				$('#signupForm').submit();
			}else{
				alert('check your email or password');
			}
		})
		$('.btn_back').click(function() {
			javascript:history.back();
		})
	})
</script>

</head>
<body>
	<div class="center">
		<form id="signupForm" action="signupAction" method="post">
			<img src="<c:url value="/resources/img/sign_up.png"/>" alt="SignIn" /></br> 
			<input type="email" id="email" class="box" name="user_email" placeholder="email" required="required" autofocus="autofocus" /> <span><img id="email_check" class="check" style="visibility: hidden;" src="<c:url value="/resources/img/check_red.png"/>" /></span> <br />
			<input type="text" class="box_none" name="user_name" placeholder="name" required="required"/> <br />
			<input type="password" id="pwd" class="box_none" name="user_pwd" placeholder="password" required="required"/> <br />
			<input type="password" id="pwd_confirm" class="box" name="user_pwd_confirm" placeholder="password confirm" required="required"/><img id="pwd_check" class="check" style="visibility: hidden;" src="<c:url value="/resources/img/check_red.png"/>" /> <br />
			<!-- <p class="pwd_check"> </p> -->
			<input type="button" class="btn_back" value="Back" />
			<input type="button" class="btn_signup" value="Sign up" />
		</form>
	</div>
</body>
</html>