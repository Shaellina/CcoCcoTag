<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#speak').click(function() {
			$('#myaudio').stop();
			//$('#myaudio').attr('src','text2speechAction?&'+$('#myform').serialize());
			$('#myaudio').attr('src', '../Speaker?&' + $('#myform').serialize());
			$('#myaudio').attr('autoplay', 'autoplay');
		})
	})
</script>
</head>
<body class="container">
	<h3>text2speech sample example</h3>
	<div class="jumbotron">
		<p>텍스트의 내용은 선택한 보이스의 언어와 일치해야 합니다.</p>
	</div>
	<form id="myform" method="post">
		<div class="row">
			<div class="col-lg-12">
				<textarea rows="10" name="statement" class="form-control">The IBM® Text to Speech service provides an API that uses IBM's speech-synthesis capabilities to synthesize text into natural-sounding speech in a variety of languages, accents, and voices. 
The service supports at least one male or female voice, sometimes both, for each language. 
The audio is streamed back to the client with minimal delay.</textarea>
				<br />
			</div>
		</div>

		<div class="row">
		<div class="col-lg-12">
			<select name="voice" class="form-control">
				<c:forEach items="${voices }" var="voice">
					<option value="${voice.name}">${voice.language}:
						${voice.description}</option>
				</c:forEach>
			</select><br/> <input type="button" id="speak" value="text to speech" class="btn btn-default btn-success btn-block "/>
		</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<audio id="myaudio" style="width:100%;" controls="controls" preload="auto"></audio>
			</div>
		</div>
	</form>

</body>
</html>