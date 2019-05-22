<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
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
	out.write("application.getContextPath()"+application.getContextPath() + "<br>");
	out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
	out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
	out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
	out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");
	
	out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt")+"<br>");
	
	BufferedReader br = null;
	try{
		File file = new File("C:/Users/PC19/Desktop/jspSpring/190522.txt");
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fin, "utf-8");
		br = new BufferedReader(isr);
		
		char[] buff = new char[512];
		int len = -1;
		
		while((len = br.read(buff)) != -1){
			out.write(buff);
		}
	}catch(IOException e){
		e.printStackTrace();
	}finally{
		if(br != null){
			try{
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
%>
</body>
</html>