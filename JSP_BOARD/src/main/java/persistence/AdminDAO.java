package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.MemberVO;

public class AdminDAO {

	private DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static AdminDAO dao = new AdminDAO();
	
	private AdminDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AdminDAO getInstance() {
		if (dao == null) {
			dao = new AdminDAO();
		}
		return dao;
	
	}
	// 멤버의 전체회원목록을 출력하기 위한 메서드
	public ArrayList<MemberVO> getStudentList() {
	
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		String sql = "select * from member ";
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setName(rs.getString("member_name"));
				vo.setId(rs.getString("member_id"));
				vo.setPwd(rs.getString("member_pwd"));
				vo.setPhone(rs.getString("member_phone"));
				vo.setAddr(rs.getString("member_addr"));
				memberlist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberlist;
	}

	// 회원의 전체정보를 수정하는 메서드
	public boolean update(MemberVO vo) {
		
		String sql = "update member set member_name=?, member_pwd=?, member_phone=?, member_addr=? where id= ?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
