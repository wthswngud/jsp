<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		//4가지 파라미터를 받아서, 4개를 영역에 속성으로 넣어준다.
		//속성으로 저장 : scope객체.setAttribute("속성명", 속성(객체));
		//scope 객체 : pageContext, request, session, application
		
		pageContext.setAttribute("pageAttribute", request.getParameter("pageParam"));
		request.setAttribute("request", request.getParameter("requestParam"));
		session.setAttribute("session", request.getParameter("sessionParam"));
		application.setAttribute("application", request.getParameter("applicationParam"));
		
		
		request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
	%>
	
	<%=	pageContext.getAttribute("pageAttribute")%>
	<%= request.getAttribute("request")%>