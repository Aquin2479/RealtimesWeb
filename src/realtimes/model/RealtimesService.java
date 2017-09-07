package realtimes.model;

import java.sql.SQLException;

import realtimes.model.dto.MemberDTO;
import realtimes.model.dto.TestDTO;

public class RealtimesService {
	
	public static TestDTO getTest() throws SQLException {
		return TestDAO.getTest();
	}
	
	public static MemberDTO getMember(String username, String password) throws SQLException {
		return MemberDAO.getMember(username, password);
	}
	
	public static boolean addLog(String username, String news_code, String viewing_time) throws SQLException {
		return LogDAO.addLog(username, news_code, viewing_time);
	}
}
