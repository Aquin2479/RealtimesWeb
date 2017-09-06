package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import realtimes.model.dto.MemberDTO;
import realtimes.model.dto.TestDTO;
import realtimes.model.util.DBUtil;

public class MemberDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static MemberDTO getMember(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMember"));
			 pstmt.setString(1, username);
			 pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				member = new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return member;
	}
}
