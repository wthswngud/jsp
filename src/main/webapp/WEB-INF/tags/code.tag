<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="java.lang.String" required="false"%>
code : ${code}

<%
String code = (String)jspContext.getAttribute("code");
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	conn = DriverManager.getConnection(				//==> 성공하면 conn에 Connection객체가 들어간다.
			"jdbc:oracle:thin:@localhost:1521:xe",
			"pc19",	// 	==> 아이디
			"java"	//	==> 비밀번호
			);
	
	String sql = "select * from "+code;
	stmt = conn.createStatement();	// Statement객체 생성
	rs = stmt.executeQuery(sql);	// ==> select문을 사용할때 사용하는 메서드
	
	%>
	<select>
		<%while(rs.next()){%>
			<option value="<%=rs.getString("lprod_gu")%>"><%=rs.getString(3)%></option>
		<%}%>
	</select>
<%} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}finally{
	if(rs!=null) try{ rs.close();} catch(SQLException e){}
	if(stmt!=null) try{ stmt.close();} catch(SQLException e){}
	if(conn!=null) try{ conn.close();} catch(SQLException e){}
}%>