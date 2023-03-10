package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	// 회원들의 전체 정보를 읽어오는 메서드.(리스트로 반환)
	public ArrayList<MemberVO> getMemberList() {

	

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
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberlist;
	}

	// 회원 추가 DAO
	public boolean add(MemberVO vo) {
		
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
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean delete(MemberVO vo) {
		
		String sql = "delete from member where member_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public MemberVO readOne(String id) {
		
		String sql = "select * from member where id = id";
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
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 회원의 정보를 수정하는 메서드
	public boolean update(MemberVO vo) {
		
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
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public ArrayList<MemberVO> delete(String id) {
		
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		String sql = "delete from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberlist;
	}

}
