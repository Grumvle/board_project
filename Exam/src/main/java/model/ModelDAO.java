package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ModelDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	Connection con;
	
	public void getCon() {
		//db연동코드, Connection Pool 사용
		try {
			Context initctx = new InitialContext();
			// Context envctx = (Context) initctx.lookup("java:comp/env/");
			DataSource dsc = (DataSource) initctx.lookup("java:comp/env/jdbc/Exam");
			con = dsc.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//getCon end
	public void MemberInsert(ModelBean bean) {
		getCon();
		try {  //sql문
			String sql = "insert into member values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getJob());
			pstmt.setString(3, bean.getId());
			pstmt.setString(4, bean.getPwd());
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getAddr());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//MemberInsert end
	public ArrayList<ModelBean> getAllList(){
		ArrayList<ModelBean> list = new ArrayList<>();
		getCon();
		try { //sql문
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ModelBean bean = new ModelBean();
				bean.setName(rs.getString(1));
				bean.setJob(rs.getString(2));
				bean.setId(rs.getString(3));
				bean.setPwd(rs.getString(4));
				bean.setPhone(rs.getString(5));
				bean.setAddr(rs.getString(6));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}