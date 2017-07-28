<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CcoCcoTAG More Conveniently</title>
<link rel="shortcut icon" href="<c:url value="/resources/img/logo.ico"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/upload.css"/>"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#btn_upload').click(function() {
		//var _lastVideoDot = video.lastIndexOf('.');
		//var _lastThumbnailDot = thumbnail.lastIndexOf('.');
		var video = $('#video_file').val();
		//var _videoExt = video.substring(video.lastIndexOf('.'), video.length).toLowerCase();
		var thumbnail = $('#thumbnail_file').val();
		//var _thumbnailExt = thumbnail.substring(thumbnail.lastIndexOf('.'), thumbnail.length).toLowerCase();
		//alert(thumbnail);
		//alert(video);
		if(thumbnail.trim() == ''){
			alert('check your input thumbnail file');
		}else if(video.trim() == '') {
			alert('check your input video file');
		} else{ 
			alert('submit success');
			$('#uploadForm').submit();
		}
	})
	
	$('.btn_back').click(function() {
			javascript:history.back();
		})
})
</script>

</head>
<body>
	<div id="header">
    <div style="float:right; margin-right:50px;">
    <table><tr>
        Hello, ${userName}
        <form action="logout" method="get">
        	<input type="submit" value="LOGOUT" class="logout"/>
        </form>
    </tr></table>
    </div>
</div>
<div class="center">
    <form id="uploadForm" action="upload.do" method="post" enctype="multipart/form-data">
        <div style="text-align: center; margin-bottom: 20px;"><img src="<c:url value="/resources/img/upload.png"/>" alt="Upload" /></div>
        <table class="table_upload">
            <tr>
                <td class="label">Thumbnail</td>
                <td>
                    <div class="file_input_div">
                    <input type="file" id="thumbnail_file" name="uploadThumbnailFile" class="file_input_btn" onchange="javascript:
                            document.getElementById('fileName1').value=this.value"/>
                    <img src="<c:url value="/resources/img/file_input.png"/>" class="file_input_img"/>
                    </div>
                    <input type="text" id="fileName1" class="file_input_textbox" readonly="readonly" value="No file Choosen">
                </td> 
            </tr>
            <tr>
                <td class="label">Video/Audio</td>
                <td>
                    <div class="file_input_div">
                    <input type="file" id="video_file" name="uploadVideoFile" class="file_input_btn" onchange="javascript:
                            document.getElementById('fileName2').value=this.value"/>
                    <img src="<c:url value="/resources/img/file_input.png"/>" class="file_input_img"/>
                    </div>
                    <input type="text" id="fileName2" class="file_input_textbox" readonly="readonly" value="No file Choosen">
                </td>
            </tr>
            <tr>
                <td class="label">Description</td>
                <td>
                    <input type="text" name="title" placeholder="title" class="title_textbox"/>
                    <select name="category" class="title_select">
                        <option value="movie">movie</option>
                        <option value="automobile">automobile</option>
                        <option value="music">music</option>
                        <option value="animal">animal</option>
                        <option value="sports">sports</option>
                        <option value="travel">travel</option>
                        <option value="game">game</option>
                        <option value="blog">blog</option>
                        <option value="comedy">comedy</option>
                        <option value="entertain">entertain</option>
                        <option value="news">news</option>
                        <option value="howto">howto</option>
                        <option value="education">education</option>
                        <option value="tech">tech</option>
                        <option value="activism">activism</option>
                    </select>
                </td>
            </tr>
            <tr>
            <td><td>
            <textarea rows="10" cols="68" name="description" class="descript" placeholder="write more details about your video"></textarea>
            </td></td>
            </tr>
        </table>
        <div style="text-align: center; padding-left: 50px">
        <input type="button" class="btn_back" value="Back" />
        <input type="button" id="btn_upload" class="btn_upload" value="Upload"/>
        </div>
    </form>
</div>
</body>
</html>