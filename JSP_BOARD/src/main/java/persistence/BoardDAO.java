package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.BoardVO;

public class BoardDAO {
	// 커넥션 풀 사용?
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void disconnect() {

		if (pstmt != null) {

			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public ArrayList<BoardVO> getBoardList() {
		connect();
		ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
		String sql = "select * from board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setIdx(rs.getInt("board_idx"));
				vo.setTitle(rs.getString("board_title"));
				vo.setContent(rs.getString("board_content"));
				vo.setWriter(rs.getString("board_writer"));
				vo.setDate(rs.getString("board_date"));
				vo.setNewdate(rs.getString("board_newdate"));
				
				
				boardlist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return boardlist;
	}
	
	public BoardVO getBoardPostOne(int idx) {
		connect();
		BoardVO boardPost = new BoardVO();
		String sql = "select * from board where board_idx = "+idx;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
					
				boardPost.setIdx(rs.getInt("board_idx"));
				boardPost.setTitle(rs.getString("board_title"));
				boardPost.setContent(rs.getString("board_content"));
				boardPost.setWriter(rs.getString("board_writer"));
				boardPost.setDate(rs.getString("board_date"));
				boardPost.setNewdate(rs.getString("board_newdate"));
				     
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return boardPost;
	}
	
	
	public boolean add(BoardVO vo, String loginId) {
		connect();
		String nonPwd_sql = "";
		String pwd_sql = "";
		
		
		if ("".equals(vo.getPwd())) {
		
			nonPwd_sql = "insert into board(board_writer,board_title,board_content, board_date, board_newdate)  value('"+loginId+"',?,?,default,null)";
			try {
				pstmt = conn.prepareStatement(nonPwd_sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				disconnect();
			}
		} else { // 비밀번호가 있다면 이 sql문을 써야한다.
			pwd_sql = "insert into board(board_writer,board_title,board_content, board_pwd, board_date, board_newdate) value('"+loginId+"',?,?,?,default, null)";
			try {
				pstmt = conn.prepareStatement(pwd_sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getPwd());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				disconnect();
			}
		}

		return true;
	}

	public boolean update(BoardVO vo,String loginId,String boardTitle,String date) {
		connect();
		String sql = "update board set board_title= ? ,board_content = ?, board_newdate = default where board_writer = '"+loginId+"' and board_title='"+boardTitle+"' and board_date='"+date+"';";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return true;
	}

}
