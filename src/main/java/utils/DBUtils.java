package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.ConnectJDBC;
import models.actBean;

public class DBUtils {
	public static actBean fundUser(Connection conn, String username, String password) throws SQLException {
		String sql = "select id from logins where uname = ? and passwd = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {	
				return new actBean(username, password);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
