<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function year_change() {
		alert(document.myform.year.value + "년");
	}

	function month_change() {
		alert(document.myform.month.value + "월");
	}
	function up_month() {
		var year = document.myform.year.value;
		var month = document.myform.month.value;
		//alert(year + " / " + month);
		if (month == 12) {
			document.myform.year.value = parseInt(year) + 1;
			document.myform.month.value = 1;
		} else {
			document.myform.month.value = parseInt(month) + 1;
		}
		//alert(year + " / " + month);
		document.myform.submit();
	}
	function down_month() {
		var year = document.myform.year.value;
		var month = document.myform.month.value;
		//alert(year + " / " + month);
		if (month == 1) {
			document.myform.year.value = parseInt(year) - 1;
			document.myform.month.value = 12;
		} else {
			document.myform.month.value = parseInt(month) - 1;
		}
		//alert(year + " / " + month);
		document.myform.submit();
	}

	function up_year() {
		var year = document.myform.year.value;
		document.myform.year.value = parseInt(year) + 1;
		document.myform.submit();
	}
	function down_year() {
		var year = document.myform.year.value;
		document.myform.year.value = parseInt(year) - 1;
		document.myform.submit();
	}

	function addMonth() {

	}
	function subMonth() {

	}
</script>

<!-- <style type="text/css">
td:nth-child(1) {
	color: red;
}

td:nth-child(7) {
	color: blue;
}
</style> -->
</head>
<body>
	<form name="myform">
		<!-- <input type="hidden" name="addMonth" value="0"> -->

		<!-- html 주석 -->
		<%-- 스크립트릿 주석 --%>
		<%
			//scriptlet
			/* 멀티라인 주석 */
			//int year = 2017;
			//int month = 6;

			int year = 0;
			int month = 0;
			//	int addMonth = 0;
			Calendar c = Calendar.getInstance();

			try {
				year = Integer.parseInt(request.getParameter("year"));
				month = Integer.parseInt(request.getParameter("month"));
				/* addMonth = Integer.parseInt(request.getParameter("addMonth"));
				c.set(year, month - 1 + addMonth, 1);
				 */
			} catch (Exception e) {
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH) + 1;
			}

			/* year = (!request.getParameter("year").isEmpty()) ? Integer.parseInt(request.getParameter("year"))
					: c.get(Calendar.YEAR);
			month = (!request.getParameter("month").isEmpty()) ? Integer.parseInt(request.getParameter("month"))
					: c.get(Calendar.MONTH); */
			c.set(year, month - 1, 1);

			int week = c.get(Calendar.DAY_OF_WEEK);
			int end_day = c.getActualMaximum(Calendar.DATE);
		%>

		<table style="width: 220px">
			<caption>
				<span onclick="down_year()" style="cursor: pointer;">◁</span> <span
					onclick="down_month()" style="cursor: pointer;">◀</span> <select
					name="year" onchange="document.myform.submit()">
					<%-- option으로 multiple 속성을 줄 수 있다. 여러 개를 보면서 여러 개 선택이 가능하다. --%>
					<%
						for (int y = year - 5; y < year + 5; y++) {
							//out.println("<option>" + y + "</option>");
					%>
					<option <%=year == y ? "selected = 'selected'" : ""%>><%=y%></option>
					<%
						}
					%>
				</select>년 <select name="month" onchange="document.myform.submit()">
					<%
						for (int m = 1; m < 13; m++) {
					%>
					<option <%=month == m ? "selected='selected'" : ""%>><%=m%></option>
					<%-- <option <%=month+1 == m ? " selected " : ""%>><%=m%></option> 도 된다.
				--%>
					<%
						}
					%>
				</select>월<span onclick="up_month()" style="cursor: pointer;">▶</span><span
					onclick="up_year()" style="cursor: pointer;">▷</span>
			</caption>
			<tr>
				<td style="color:red;">일</td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td style="color:blue;">토</td>
			</tr>
			<tr>
				<%
					for (int d = 1; d < week; d++) {
						out.print("<td></td>");
					}
					for (int d = 1, w = week; d <= end_day; d++, w++) {
						out.print("<td" + (w % 7 == 1 ? " style=color:red; " : w % 7 == 0 ? " style=color:blue; " : "") + ">"
								+ d + "</td>");
						if (w % 7 == 0)
							out.println("</tr><tr>");
					}
				%>
			</tr>
		</table>
	</form>
</body>
</html>