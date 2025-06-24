package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecuteUpdateUpdate {
	
	public static void updateDb(Statement st, String sql, String s, int num) throws SQLException {
		int cnt = st.executeUpdate(sql + String.format("home='%s' where id=%d", s, num));
		System.out.println(cnt+"건 업데이트 완료");
	}
	
	public static void prUpdateDb(PreparedStatement psmt, String s, int num) throws SQLException {
		psmt.setString(1, s);
		psmt.setInt(2, num);
		int cnt = psmt.executeUpdate();
		System.out.println(cnt+"건 업데이트 완료");
	}

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","tiger");
			
			String sql1 = "update phonebook set ";
			String sql2 = "update phonebook set home=? where id=?";
			
			st = con.createStatement();
			psmt = con.prepareStatement(sql2);
			
			updateDb(st, sql1, "051-555-5555", 39);
			prUpdateDb(psmt, "051-666-6666", 40);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {	if(st != null) st.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(psmt != null) psmt.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(con != null) con.close();} catch (SQLException e) {	e.printStackTrace();}
		}

	}

}
