<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div{
		margin : 0px;
		width : 200px;
		height: 250px;
		border : 1px solid red;
	}
</style>
</head>
<body>
<%! //메서드 선언 %>
<%! public String hello(){
		return "hello";
	}
%>

<%! public int fac(int x){
		// 0!은 수학적 정의에 따라 1이다.
	
		int num = 0;
		if(num==0){
			num=1;
		}
		if(x == 0){
			x=1;
		}
		for(int i=1; i<=x; i++){
			num = num*i;
		}
		return num;
	}
%>
<div>
	hello() : <%=hello() %><br>
	fac(0) : <%= fac(0) %><br>
	fac(1) : <%= fac(1) %><br>
	fac(2) : <%= fac(2) %><br>
	fac(3) : <%= fac(3) %><br>
	fac(4) : <%= fac(4) %><br>
	fac(5) : <%= fac(5) %><br>
	fac(6) : <%= fac(6) %><br>
	fac(7) : <%= fac(7) %><br>
	fac(8) : <%= fac(8) %><br>
</div>
</body>
</html>