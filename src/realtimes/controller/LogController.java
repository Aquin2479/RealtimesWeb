package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import realtimes.model.RealtimesService;

@WebServlet("/log")
public class LogController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command.equals("addLog")) {
			addLog(request, response);
		}
	}
	
	public void addLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int member_code = -1;
		int news_code = Integer.parseInt(request.getParameter("news_code").trim());
		int topic = -1;
		String viewing_time = request.getParameter("viewing_time").trim();
		
		if (request.getSession().getAttribute("member_code") != null) {
			member_code = (Integer) request.getSession().getAttribute("member_code");
		}
		
		try {
			RealtimesService.addLog(member_code, news_code, topic, viewing_time);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
