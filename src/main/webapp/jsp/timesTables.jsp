<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		border:1px solid black;
		margin: 10px;
	}
</style>
</head>
<body>
<!-- localhost/jsp/jsp/timesTables.jsp -->
<!-- 9*9단 출력 (2~9단) -->
<!-- 인자로 받은 수만큼 구구단 출력 -->
	<%String param1 = request.getParameter("i"); %>
	<%String param2 = request.getParameter("j"); %>
	<table>
	
		<%for(int i=1; i<Integer.parseInt(param2)+1; i++){%>
			<tr>
			<%for(int j=2; j<Integer.parseInt(param1)+1; j++){ %>
				<td>
				<%=j+"*"+i+" = " + (i*j)%>
				</td>
			<%}%>
			</tr>
		<%}%>
	</table>
</body>
</html>