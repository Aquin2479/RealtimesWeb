package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import realtimes.model.dto.TopicDTO;
import realtimes.model.util.DBUtil;

public class TopicDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static ArrayList<TopicDTO> getTopicAll() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<TopicDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql.getString("getTopicAll"));
				rset = pstmt.executeQuery();
	         
				list = new ArrayList<TopicDTO>();
				while (rset.next()) {
					list.add(new TopicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10), rset.getInt(11)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
	}
	
	public static ArrayList<TopicDTO> getSectionTopic() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic"));
			rset = pstmt.executeQuery();
         
			list = new ArrayList<TopicDTO>();
			while (rset.next()) {
				list.add(new TopicDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10), rset.getInt(11)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
}
}
