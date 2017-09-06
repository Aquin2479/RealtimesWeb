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
}
