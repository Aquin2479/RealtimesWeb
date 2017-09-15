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
		} else if (command.equals("getSectionTopic1")) {
			getSectionTopic1(request, response);
		} else if (command.equals("getSectionTopic2")) {
			getSectionTopic2(request, response);
		} else if (command.equals("getSectionTopic3")) {
			getSectionTopic3(request, response);
		} else if (command.equals("getSectionTopic4")) {
			getSectionTopic4(request, response);
		} else if (command.equals("getSectionTopic5")) {
			getSectionTopic5(request, response);
		} else if (command.equals("getSectionTopic6")) {
			getSectionTopic6(request, response);
		} else if (command.equals("get10Topic")) {
			get10Topic(request, response);
		}
	}
	
	public void get10Topic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.get10Topic();
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
	
	public void getSectionTopic1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic1();
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
	
	public void getSectionTopic2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic2();
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
	
	public void getSectionTopic3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic3();
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
	
	public void getSectionTopic4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic4();
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
	
	public void getSectionTopic5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic5();
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
	
	public void getSectionTopic6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<TopicDTO> list = RealtimesService.getSectionTopic6();
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
