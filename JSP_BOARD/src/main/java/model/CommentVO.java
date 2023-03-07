package model;

import java.util.Date;

public class CommentVO {

	private String commentContent;
	private int commentID;
	private String userID;
	private int commentAvailable;
	private int board_idx;
	private String commentDate;

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getCommentAvailable() {
		return commentAvailable;
	}

	public void setCommentAvailable(int commentAvailable) {
		this.commentAvailable = commentAvailable;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
}
