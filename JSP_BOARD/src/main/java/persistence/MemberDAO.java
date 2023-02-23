package persistence;

import java.sql.*;
import java.util.*;

import model.MemberVO;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원들의 전체 정보를 읽어오는 메서드.(리스트로 반환)
	public ArrayList<MemberVO> getMemberList() {
		connect();
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		String sql = "select * from member ";
		try {
			pstmt = conn.prepareStatement(sql);
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
			disconnect();
		}
		return memberlist;
	}

	public ArrayList<MemberVO> getOneMemberList(String id) {
		connect();
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		String sql = "select * from student where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
			disconnect();
		}
		return memberlist;
	}

	// 회원 추가 DAO
	public boolean add(MemberVO vo) {
		connect();
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddr());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean delete(MemberVO vo) {
		connect();
		String sql = "delete from member where member_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

//	// 회원의 정보를 삭제하고 전체 리스트를 ArrayList를 반환하는 메서드
//	public ArrayList<MemberVO> delete(String id) {
//		connect();
//		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
//		String sql = "delete from member where member_id = ? ";
//
//		try {
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.executeUpdate();
//			pstmt.close();
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//
//		}
//
//		return memberlist;
//	}

	/*
	 * // 회원 한명의 정보를 읽어오는 메서드. public MemberVO readOne(String username) { connect();
	 * String sql = "select * from member where username = ?"; MemberVO vo = new
	 * MemberVO(); try { pstmt = conn.prepareStatement(sql); pstmt.setString(1,
	 * username); ResultSet rs = pstmt.executeQuery();
	 * 
	 * if (rs.next()) { vo.setId(rs.getString("id")); } rs.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } finally { disconnect(); } return
	 * vo; }
	 */

	// 회원 전체의 정보를 읽어오는 메서드
	// 회원의 이름을 클릭했을시 그 한명의 정보를 불러오는 메서드이다.
	// 미완성. 불완전한 메서드.
	public MemberVO readOne(String id) {
		connect();
		String sql = "select * from student where id like ?";
		MemberVO vo = new MemberVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setName(rs.getString("member_name"));
				vo.setId(rs.getString("member_id"));
				vo.setPwd(rs.getString("member_pwd"));
				vo.setPhone(rs.getString("member_phone"));
				vo.setAddr(rs.getString("member_addr"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 회원의 정보를 수정하는 메서드
	public boolean update(MemberVO vo) {
		connect();
		String sql = "update member set member_pwd=?, member_name=?, member_phone=?, member_addr=? where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
//
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

}
