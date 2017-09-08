package realtimes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import realtimes.model.dto.NewsDTO;
import realtimes.model.util.DBUtil;

public class NewsDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static ArrayList<NewsDTO> getGeneralNews(String site) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<NewsDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql.getString("getGeneralNews"));
				pstmt.setString(1, site);
				rset = pstmt.executeQuery();
	         
				list = new ArrayList<NewsDTO>();
				while (rset.next()) {
					list.add(new NewsDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
	}
}
