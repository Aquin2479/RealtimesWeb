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
	
	public static ArrayList<TopicDTO> getSectionTopic1() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic1"));
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
	
	public static ArrayList<TopicDTO> getSectionTopic2() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic2"));
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
	
	public static ArrayList<TopicDTO> getSectionTopic3() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic3"));
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
	
	public static ArrayList<TopicDTO> getSectionTopic4() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic4"));
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
	
	public static ArrayList<TopicDTO> getSectionTopic5() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic5"));
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
	
	public static ArrayList<TopicDTO> getSectionTopic6() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getSectionTopic6"));
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
	
	public static ArrayList<TopicDTO> get10Topic() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TopicDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("get10Topic"));
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
