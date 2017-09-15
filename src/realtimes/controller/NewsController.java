package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import realtimes.model.RealtimesService;
import realtimes.model.dto.LogDTO;
import realtimes.model.dto.NewsDTO;
import realtimes.model.dto.TopicDTO;

@WebServlet("/news")
public class NewsController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		if (command.equals("getGeneralNews")) {
			getGeneralNews(request, response);
		} else if (command.equals("getRecommendNews")) {
			getRecommendNews(request, response);
		}
	}
	
	public void getGeneralNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String section = request.getParameter("section").trim();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			ArrayList<NewsDTO> list = RealtimesService.getGeneralNews(section);
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
	
	public void getRecommendNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int member_code = -1;
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter writer = response.getWriter();		
		JSONObject resultOb = new JSONObject();
		
		if (request.getSession().getAttribute("member_code") != null) {
			member_code = (Integer) request.getSession().getAttribute("member_code");
		} else {
			System.out.println("no user to recommend");
			return;
		}
		
		try {
			// getRecommendNews(미완성) TODO by jangwon
			// 1. member_code를 이용하여  LogDAO에서 getLogByUser함수를 생성하여 관련 로직을 완성한 후, 사용자의 로그들를 불러온다.
			// 2. topic의 경우 테이블을 만들어 놨지만 java 코드가 안 짜여져 있다.
			//      DTO부터 차례로 만들어 TopicDAO에서 getTopicAll 함수를 생성하여 모든 토픽을 불러오도록 한다.
			//      모든 토픽 테이블이 불러와졌고, 사용자의 로그도 모두 수집하였으므로, 적당한 알고리즘을 통해 선호도를 파악하고,
			//      뉴스 리스트를 뽑아낸다(뉴스 아이디의 List? 형식)
			//      이 List를 아래의 getRecommendNews 함수에 전달하여 list를 사용자에게 반환해준다
			
			// 3. 위의 과정은 필요하면 새로운 java class를 생성하여 진행
			ArrayList<TopicDTO> topic = RealtimesService.getTopicAll();
			ArrayList<LogDTO> log = RealtimesService.getLog(member_code);
			ArrayList log_topic = new ArrayList<Integer>();
			
			for(int i = 0; i < 5; i++){
				log_topic.add(log.get(i).getTopic());
			}
			int i = 0;
			int j = 1;
			int[] count = new int[4];//5개의 로그 토픽들 중 같은 토픽 개수를 알아야하므로 4개의 integer를 선언하여 계산
			while(i<5){
				while(j<5){
					if (log_topic.get(i) == log_topic.get(j)){
						count[i]++;
					}
					j++;
				}
				i++;
				j = i+1;
			}
			int max = count[0];
	        int maxTopic = 0;
	        for(int t = 1; t<count.length ; t++){
	            if(count[t] > max){
	                max = count[t];
	                maxTopic = t;
	            }
	        }
	        ArrayList<NewsDTO> list = RealtimesService.getRecommendNews((int) log_topic.get(maxTopic));

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