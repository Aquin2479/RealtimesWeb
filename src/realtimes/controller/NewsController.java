package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import realtimes.model.RealtimesService;
import realtimes.model.dto.NewsDTO;

@WebServlet("/news")
public class NewsController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if (command.equals("getGeneralNews")) {
			getGeneralNews(request, response);
		}
	}
	
	public void getGeneralNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String site = request.getParameter("site").trim();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<NewsDTO> list = RealtimesService.getGeneralNews(site);
			String stringList = new Gson().toJson(list);
			resultOb.put("result", 0);
			resultOb.put("list", stringList);
		} catch (SQLException e) {
			resultOb.put("result", 1);
			resultOb.put("content", "Can`t get News Contents(DB Error)");
			e.printStackTrace();
		}
		writer.print(resultOb);
	}

}
