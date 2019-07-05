package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basicJsonServlet")
public class BasicJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		PrintWriter pw = response.getWriter();
		
		//{"userId" : "brown", "pass" : "brown"1234"}
		pw.write("{'userId':'brown', 'pass' : 'brown1234'}");
		
		pw.flush();
		pw.close();
	}
}
