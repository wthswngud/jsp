<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//JDBC (Java DataBase Connectivity)
	/*
	 	데이터베이스 처리순서
	 	
	 	1. 드라이버 로딩 ==> JDBC라이브러리를 JVM의 메모리에 적재한다.
	 	 	접속 ==> Class.forName("oracle.jdbc.driver.OracleDriver");	
	 	 	
	 	2. DB시스템에 접속하기 ==> 접속이 완료되면 Connection 객체가 만들어진다.
	 								DriverManager.getConnection()메서드를 이용한다.
	 	
	 	3. 질의하기 ==> Statement객체 또는 PreparedStatement객체를 이용하여
	 					SQL문을 실행하고 그결과를 받아온다.
	 					
	 	4. 받아온 결과를 처리한다.
	 		1) SQL문이 select문일 경우 ==> ResultSet객체가 만들어진다.
	 			(ResultSet객체에는 select한 결과가 저장된다.)
	 		2) SQL문이 insert, update, delete 등일 경우 ==> 정수값을 반환한다.
	 		 	(정수값은 보통 실행에 성공한 레코드 수를 말한다.)
	 	
	 	5. 사용한 자원을 반납한다.
	 	
	 */
//		DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			BasicDataSource bs = new BasicDataSource();
			bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bs.setUsername("pc19");
			bs.setPassword("java");
			bs.setInitialSize(20);
			
			long start = System.currentTimeMillis();
//			2. 접속 ==> Connection객체 생성
			for(int i=0; i<20; i++){
				conn = bs.getConnection();
				conn.close();
			
// 				out.write("schema : " + conn.getSchema() + "<br>");
			}
			long end = System.currentTimeMillis();
			
			System.out.println("duration : " + (end-start));
			bs.close();
//			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
//			6. 사용했던 자원들을 모두 반납한다.
			if(rs!=null) try{ rs.close();} catch(SQLException e){}
			if(stmt!=null) try{ stmt.close();} catch(SQLException e){}
			if(conn!=null) try{ conn.close();} catch(SQLException e){}
		}
%>