package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BoardVO;
import model.CommentVO;

public class CommentDAO {

	private DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static CommentDAO dao = new CommentDAO();

	private CommentDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CommentDAO getInstance() {
		if (dao == null) {
			dao = new CommentDAO();
		}
		return dao;
	}

	public String getDate() {
		String SQL = "select now()";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public int getNext() {
		String SQL = "SELECT commentID from COMMENT order by commentID DESC";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int write(String commentContent, String userID, int bbsID) {
		String SQL = "insert into COMMENT VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, getNext());
			pstmt.setString(3, userID);
			pstmt.setInt(4, 1);
			pstmt.setString(5, getDate());
			pstmt.setInt(6, bbsID);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CommentVO> getList(int bbsID) {
		String SQL = "SELECT * from comment where board_idx = ? AND commentAvailalbe = 1 order by board_idx desc limit 10";

		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentContent(rs.getString(1));
				comment.setCommentID(rs.getInt(2));
				comment.setUserID(rs.getString(3));
				comment.setCommentAvailable(rs.getInt(4));
				comment.setCommentDate(rs.getString(5));
				comment.setBoard_idx(rs.getInt(6));
				list.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public CommentVO getComment(int commentID) {
		String SQL = "SELECT * from comment where commentID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentContent(rs.getString(1));
				comment.setCommentID(rs.getInt(2));
				comment.setUserID(rs.getString(3));
				comment.setCommentAvailable(rs.getInt(4));
				comment.setCommentDate(rs.getString(5));
				comment.setBoard_idx(rs.getInt(6));
				return comment;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int update(int bbsID, int commentID, String commentContent) {
		String SQL = "update comment set commentContent = ? where bbsID = ? and commentID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, bbsID);
			pstmt.setInt(3, commentID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(int commentID) {

		String SQL = "update COMMENT set commentAvailalbe = 0 where commentID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, commentID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

}
