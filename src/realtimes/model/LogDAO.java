package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import realtimes.model.util.DBUtil;

public class LogDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static boolean addLog(String username, String news_code, String viewing_time) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			 con = DBUtil.getConnection();
			 pstmt = con.prepareStatement(sql.getString("addLog"));
			 pstmt.setString(1, username);
			 pstmt.setString(2, news_code);
			 pstmt.setString(3, viewing_time);
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
