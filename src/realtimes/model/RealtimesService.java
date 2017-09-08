package realtimes.model;

import java.sql.SQLException;
import java.util.ArrayList;

import realtimes.model.dto.MemberDTO;
import realtimes.model.dto.NewsDTO;

public class RealtimesService {
	
	public static MemberDTO getMember(String username, String password) throws SQLException {
		return MemberDAO.getMember(username, password);
	}
	
	public static boolean addLog(int member_code, int news_code, int topic, String viewing_time) throws SQLException {
		return LogDAO.addLog(member_code, news_code, topic, viewing_time);
	}
	
	public static ArrayList<NewsDTO> getGeneralNews(String site) throws SQLException {
		return NewsDAO.getGeneralNews(site);
	}
}
