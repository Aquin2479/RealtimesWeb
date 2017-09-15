package realtimes.model;

import java.sql.SQLException;
import java.util.ArrayList;

import realtimes.model.dto.LogDTO;
import realtimes.model.dto.MemberDTO;
import realtimes.model.dto.NewsDTO;
import realtimes.model.dto.TopicDTO;

public class RealtimesService {
	
	public static MemberDTO getMember(String username, String password) throws SQLException {
		return MemberDAO.getMember(username, password);
	}
	
	public static boolean addLog(int member_code, String news_code, String topic_name, String viewing_time) throws SQLException {
		return LogDAO.addLog(member_code, news_code, topic_name, viewing_time);
	}
	
	public static ArrayList<LogDTO> getLog(int member_code) throws SQLException {
		return LogDAO.getlog(member_code);
	}
	
	public static ArrayList<NewsDTO> getGeneralNews(String section) throws SQLException {
		return NewsDAO.getGeneralNews(section);
	}
	
	public static ArrayList<NewsDTO> getRecommendNews(int topic) throws SQLException {
		return NewsDAO.getRecommendNews(topic);
	}
	
	public static ArrayList<TopicDTO> getTopicAll() throws SQLException {
		return TopicDAO.getTopicAll();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic1() throws SQLException {
		return TopicDAO.getSectionTopic1();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic2() throws SQLException {
		return TopicDAO.getSectionTopic2();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic3() throws SQLException {
		return TopicDAO.getSectionTopic3();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic4() throws SQLException {
		return TopicDAO.getSectionTopic4();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic5() throws SQLException {
		return TopicDAO.getSectionTopic5();
	}
	
	public static ArrayList<TopicDTO> getSectionTopic6() throws SQLException {
		return TopicDAO.getSectionTopic6();
	}
	
	public static ArrayList<TopicDTO> get10Topic() throws SQLException {
		return TopicDAO.get10Topic();
	}
}
