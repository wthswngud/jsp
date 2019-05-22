<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("userId : " + request.getParameter("userId"));
		RequestDispatcher rd =  request.getRequestDispatcher("/jsp/requestDispatchTarget.jsp");
		
		rd.forward(request, response);
	%>
	requestDispatchProcess.jsp
</body>
</html>