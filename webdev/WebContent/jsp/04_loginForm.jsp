<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<script>
	function input_check() {
		console.log('run input_check');
		var f = document.myform;
		console.log('user_id : ' + f.id.value);
		console.log('user_pw : ' + f.pw.value);
		console.log('------------------------');
		console.log('user_id : ' + document.getElementById('userid').value);
		console.log('user_pw : ' + document.getElementById('userpw').value);
		
		var user_id = document.getElementById('userid').value;
		var user_pw = document.getElementById('userpw').value;
		if(user_id === '') {
			alert('아이디를 입력하세요');
			return;
		} 
		if(user_pw === '') {
			alert('비밀번호를 입력하세요');
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<form name="myform" action="04_testLogin.jsp" method="post">
		아이디 : <input type="text" id="userid" name="id" autofocus="autofocus" /> <br />
		암&nbsp;&nbsp;&nbsp;호 : <input type="password" id="userpw" name="pw" /><br /> 
		<input type="button" value="로그인"  onclick="input_check()"/>
	</form>
</body>
</html>