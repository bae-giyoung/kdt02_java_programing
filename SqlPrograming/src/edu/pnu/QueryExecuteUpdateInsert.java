package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecuteUpdateInsert {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/myfirstdb";
			con = DriverManager.getConnection(url,"root","tiger");
			
//			[PreparedStatement로 작성]
//			String sql = "insert into phonebook(name, mobile) values(?,?)";
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, "홍길장");
//			psmt.setString(2, "010-2222-2222");
//			int updateCnt = psmt.executeUpdate();
			
//			[Statement로 작성]
//			String sql = "insert into phonebook(name, mobile) values";
//			st = con.createStatement();
//			int updateCnt = st.executeUpdate(sql + String.format("('%s','%s')", "홍길청", "010-3333-3333"));
//			System.out.println("업데이트가 " + updateCnt + "건 되었습니다.");
			
//			[for루프]
			String[][] updatelist = {{"홍길라","010-7777-7777"}, {"홍길마","010-8888-8888"}, {"홍길바","010-9999-9999"}};
			String sql = "insert into phonebook(name, mobile) values";
			st = con.createStatement();
			int totalCnt = 0;
			for(String[] x : updatelist) {
				int updateCnt = st.executeUpdate(sql + String.format("('%s','%s')", x[0], x[1]));
				if(updateCnt > 0) System.out.println("업데이트 완료");
				totalCnt += updateCnt;
			}
			System.out.println(totalCnt + "건이 업데이트 되었습니다.");
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {	if(st != null) st.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(psmt != null) psmt.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(con != null) con.close();} catch (SQLException e) {	e.printStackTrace();}
		}

	}

}
