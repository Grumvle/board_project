package Persistence;

import java.sql.*;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, url, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt!=null) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
