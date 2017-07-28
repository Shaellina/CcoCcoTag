<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CcoCcoTAG More Conveniently</title>
<link rel="shortcut icon" href="<c:url value="/resources/img/logo.ico"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/detail.css"/>" /> 
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn_delete').click(function() {
			var input = confirm("지우시겠습니까?");
			if(input) {
				$('#deleteForm').submit();
			}else {
			}
		})
	})
	
	
::-webkit-scrollbar {width: 12px; height: 12px;  }
::-webkit-scrollbar-button:start:decrement, 
::-webkit-scrollbar-button:end:increment {display: block; width: 12px;height: 12px; background: url() rgba(0,0,0,.05);}
::-webkit-scrollbar-track {     background: rgba(0,0,0,.05); }
::-webkit-scrollbar-thumb {  background: rgba(0,0,0,.1);  }

출처: http://romeo1052.tistory.com/1797 [놀다가세여]
</script>

</head>

<body style="margin:0; background-color: #2F3540;">

<div id="sidebar">
	<form action="upload" method="post">
	<img src = "<c:url value="/resources/img/logo.gif"/>" class="logo"/><br/>
	<h1 class="welcome"><b>Hello,</br> ${userName}</b></h1>
	<input type="submit" value="+UPLOAD" class="upload"/><br/>
	</form>
	
	<%--<form action="searchAction" method="post"><select class="tag">
			<option value="tag">tag</option>
			<option value="title">title</option>
			<option value="both">both</option>
		</select>
		 <input type="text" name="both" id="searchbox" placeholder="Enter what you want" autofocus="autofocus" />
		<button class="search" onclick=""><img src="<c:url value="/resources/img/search.png"/>" class="search"/></button> 
		</form>--%>
	
	<form action="logout" method="post">
		<input type="submit" value="LOGOUT" class="logout"/>
	</form>
</div>
	<div id="content">
		
		<div class="item_out">
		<table class="item">
        <tr><td colspan="3"><hr noshade class="index"></td></tr>
        <tr>
        <th colspan="3" class="table_img">
            <img src="download.do?fileName=${file.thumbnail}" alt="thumbnail image" class="thumbnail_img"/>
        </th>
        </tr>
            <tr>
                <td colspan="3" class="txt_cate">${file.category }</td> 
            </tr>
            <tr>
                <td colspan="3" class="txt_title"><b>${file.title }</b></td>    
            </tr>
            <tr>
                <td colspan="3" class="txt_descript">${file.description }</td>
            </tr>
            <tr>
            <td colspan="3" class="btn_tag">
         		<c:if test="${not empty file.tagList}">
           	 		<c:forEach items="${file.tagList}" var="tag">
           	 	    	<input type="button" class = "btn_tag" value="#${tag.name}"/>
          	 		</c:forEach>
            	</c:if>
            </td>
            </tr>
            <tr>
            <td colspan="3" class="analysis_img"><img src="download.do?fileName=${file.wordCloud}" class="analysis_img"/></td></tr>
            <tr>
                <td class="btn_set_left"></td>
                <td class="btn_set_mid">
                <form action="list" method="post">
                    <input type="submit" class="btn_list" value="List"/>
                </form>
                </td>
                <td class="btn_set_right">
                <form id="deleteForm" action="delete?id=${file.id}" method="post">
                <button type="button" id="btn_delete" class="btn_delete" value=" ">
                    <img src="<c:url value="/resources/img/delete-button.png"/>" alt="delete_button" class="delete_img"/>
                </button>
                </form>
                </td>
            </tr>
        </table>
		</div>
	</div>	
</body>
</html>