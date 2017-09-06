package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import realtimes.model.dto.TestDTO;
import realtimes.model.util.DBUtil;

public class TestDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static TestDTO getTest() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TestDTO test = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getTest"));
			rset = pstmt.executeQuery();
			if (rset.next()) {
				test = new TestDTO(rset.getInt(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return test;
		
	}
}
