package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import realtimes.model.dto.LogDTO;
import realtimes.model.util.DBUtil;

public class LogDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static boolean addLog(int member_code, String news_code, String topic_name, String viewing_time) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			 con = DBUtil.getConnection();
			 pstmt = con.prepareStatement(sql.getString("addLog"));
			 pstmt.setInt(1, member_code);
			 pstmt.setString(2, news_code);
			 pstmt.setString(3, topic_name);
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
	
	public static ArrayList<LogDTO> getlog(int member_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LogDTO> log = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getLog"));
			pstmt.setInt(1, member_code);
			rset = pstmt.executeQuery();
			
			log = new ArrayList<>();
			while (rset.next()) {
				log.add(new LogDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getInt(4), rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return log;
	}
}
