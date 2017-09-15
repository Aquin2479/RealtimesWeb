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
import realtimes.model.dto.TopicDTO;

@WebServlet("/topic")
public class TopicController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if (command.equals("getTopicAll")) {
			getTopicAll(request, response);
		} else if (command.equals("getSectionTopic")) {
			getSectionTopic(request, response);
		}
	}

	public void getTopicAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getTopicAll();
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
	
	public void getSectionTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic();
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
