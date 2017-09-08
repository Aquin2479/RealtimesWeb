package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import realtimes.model.util.DBUtil;

public class LogDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static boolean addLog(int member_code, String news_code, int topic, String viewing_time) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			 con = DBUtil.getConnection();
			 pstmt = con.prepareStatement(sql.getString("addLog"));
			 pstmt.setInt(1, member_code);
			 pstmt.setString(2, news_code);
			 pstmt.setInt(3, topic);
			 pstmt.setString(4, viewing_time);
			 rset = pstmt.executeQuery();
			
			 int result = pstmt.executeUpdate();
			 
			 if (result == 1) {
	            return true;
	         }
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return false;
	}
}
