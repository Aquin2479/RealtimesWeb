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
		String news_code = request.getParameter("news_code").trim();
		String viewing_time = request.getParameter("viewing_time").trim();
		String username = "unknown";

		if (request.getSession().getAttribute("login") != null) {
			username = (String) request.getSession().getAttribute("login");
		}
		
		try {
			RealtimesService.addLog(username, news_code, viewing_time);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
