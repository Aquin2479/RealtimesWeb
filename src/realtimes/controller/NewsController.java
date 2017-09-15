package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

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
			ArrayList<TopicDTO> recentTopic = RealtimesService.getTopicAll(); // 최신 토픽 10 x 6
			ArrayList<LogDTO> log = RealtimesService.getLog(member_code); // 최신 로그 5개
			ArrayList<String> userKeyword = new ArrayList<String>(); // 사용자 로그에서 취합한 키워를 담을 리스트

			HashMap<Integer, Integer> topicDistance = new HashMap<Integer, Integer>(); 
			// 유저와 최신 토픽간 거리를 계산할 맵

			for (int i = 0; i < log.size(); i++) { // 로그 size : 5
				if ( i % 2 == 0 ) { // 로그가 두개로 들어가는 문제
					ArrayList<String> keywordSet = RealtimesService.getUserKeyword(log.get(i).getTopic_name());
					for(int j = 0; j < keywordSet.size(); j++) { // 로그에 해당하는 topic size 5 
						userKeyword.add(keywordSet.get(j));
					}
				}
			}
	
			Set userKeywordSet = new HashSet(userKeyword); // 사용자 키워드 리스트의 중복을 제거하기 위해 Set 사용

			for (int i = 0; i < recentTopic.size(); i++) {
					topicDistance.put(i, 0);
					if (userKeywordSet.contains(recentTopic.get(i).getKeyword1())) {
						topicDistance.put(i, topicDistance.get(i) + 1);
					}
					if (userKeywordSet.contains(recentTopic.get(i).getKeyword2())) {
						topicDistance.put(i, topicDistance.get(i) + 1);
					} 
					if (userKeywordSet.contains(recentTopic.get(i).getKeyword3())) {
						topicDistance.put(i, topicDistance.get(i) + 1);
					}
					if (userKeywordSet.contains(recentTopic.get(i).getKeyword4())) {
						topicDistance.put(i, topicDistance.get(i) + 1);
					}
					if (userKeywordSet.contains(recentTopic.get(i).getKeyword5())) {
						topicDistance.put(i, topicDistance.get(i) + 1);
					}
			}
			
			ArrayList<NewsDTO> list = new ArrayList<NewsDTO>();
			Iterator it = sortByValue2(topicDistance).iterator();
	        
	        while(it.hasNext()) {
	            Integer temp = (Integer) it.next();
	            String topic_name = recentTopic.get(temp).getTopic_name();
	            list.add(RealtimesService.getRecommendNews(topic_name));
	        }

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
	
	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
	
	public static List sortByValue2(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
         
        Collections.sort(list,new Comparator() {
             
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v2).compareTo(v1);
            }
             
        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }
}

class ValueComparator implements Comparator {
	Map map;
 
	public ValueComparator(Map map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}