<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div{
		margin: 0px auto;
		border : 2px solid skyblue;
		width : 450px;
		height: auto;
	}
</style>
</head>
<body>
	<div>
	<h2>pageContext</h2>
	<%
		out.write("pageContext.getOut().equals(out) : " + pageContext.getOut().equals(out)+"<br>");
		out.write("pageContext.getPage().equals(page) : " + pageContext.getPage().equals(page)+"<br>");
		out.write("pageContext.getRequest().equals(request) : " + pageContext.getRequest().equals(request)+"<br>");
		out.write("pageContext.getSession().equals(session) : " + pageContext.getSession().equals(session)+"<br>");
		out.write("pageContext.getServletContext().equals(application) : " + pageContext.getServletContext().equals(application)+"<br>");
		out.write("pageContext.getResponse().equals(response) : " + pageContext.getResponse().equals(response) + "<br>");
	%>
	
	</div>
</body>
</html>