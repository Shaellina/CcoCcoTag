<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<script type="text/javascript">

	// ajax -> asynchronous javascript and xml

	var xhr = null;

	function load(url) {

		var rcv = document.getElementById('rcv_msg');
		console.log(url);

		if (window.ActiveXObject) { // ~ IE 10
			console.log('explorer');
			try {
				xhr = new ActiveXObject('MSxml2.XMLHTTP');
			} catch (e) {
				xhr = new ActiveXObject('Microsoft.XMLHTTP');
			}
		} else if (window.XMLHttpRequest) { // IE 10 ~ , Chrome, ...
			console.log('chrome');
			xhr = new XMLHttpRequest();
		} else {
			console.log('ajax not supported');
		}
		
		console.log('readyState : ' + xhr.readyState); // open 안 했을 때 readyState 0
		xhr.open('GET', url, true);
		console.log('readyState : ' + xhr.readyState); // open 했을 때 readyState 1
		xhr.onreadystatechange = function() { // 모두 소문자 인게 맞다.
			
			console.log('readyState : ' + xhr.readyState); // 2,3,4 가 출력 되게 된다.
			
			if(xhr.readyState == 4) {
				if(xhr.status == 200) {
					rcv.innerHTML = xhr.responseText;					
				}
			}
		}
		xhr.send(null); 
		// GET 일 때 null, POST 일 때 변수
		// 
	}
</script>

</head>
<body>
	<input type="button" value="get text" onclick="load('msg.txt')" />

	<div id="rcv_msg"></div>
	
	
	<input type="button" value="get jsp" onclick="load('msg.jsp')"/>
</body>
</html>