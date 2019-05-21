package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuguDan extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		//localhost/jsp/gugudan?param=6
		String param = req.getParameter("i");
		System.out.println("param : " + param);
		String param2 = req.getParameter("j");
		System.out.println("param : " + param);
		
		
		pw.write("<head>");
		pw.write("	<style>");
		pw.write("		td{border : 1px solid black;}");
		pw.write("	</style>");
		pw.write("</head>");
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>구구단</title>");
		pw.write("		<body>");
		
		pw.write("			<table>");
		
		for(int i=1; i<Integer.parseInt(param2)+1; i++){		//곱
			pw.write("<tr>");
			for(int j=2; j<Integer.parseInt(param)+1; j++){	//단
				pw.write("				<td>"+j+" * "+i+" = "+(i*j)+"</td>");
				
//				if(j == Integer.parseInt(param) && i == Integer.parseInt(param2)){
//					return;
//				}
			}
			pw.write("</tr>");
		}
		
		pw.write("			</table>");
		pw.write("		</body>");
		pw.write("	</head>");
		pw.write("</html>");
	}
}
