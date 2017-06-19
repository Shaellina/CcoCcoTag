<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function go() {
		let y = document.getElementsByName('year')[0].value
		let m = document.getElementsByName('month')[0].value

		alert(y + ", " + m)
	}
</script>

</head>
<body>
	<%
		//scriptlet
		Calendar cal = Calendar.getInstance();
		int year = 2017, month = 6;
		cal.set(year, month - 1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int lastWeek = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	%>
	<table>
		<tr>
			<td>일</td>
			<td>월</td>
			<td>화</td>
			<td>수</td>
			<td>목</td>
			<td>금</td>
			<td>토</td>
		</tr>
		<tr>
			<%
				for (int i = 1; i < week; i++) {
					out.println("<td></td>");
				}
				for (int d = 1; d <= lastDay; d++) {
					out.println("<td>" + (d < 10 ? "&nbsp" + d : d) + "</td>");
					out.println(cal.get(Calendar.DAY_OF_WEEK) % 7 == 0 ? "<tr/><tr>" : "");
					// 				out.print(d < 10 ? " " + d + " " : d + " ");
					// 				out.print( "\n" : "");
					cal.add(Calendar.DATE, 1);
				}
			%>
		
	</table>


	<form action="" name="in">
		<input type="text" name="year" value="${y} " /><br /> <input
			type="text" name="month" value="${m} " /><br /> <input
			type="button" onclick="go()" value="go" />
	</form>

</body>
</html>